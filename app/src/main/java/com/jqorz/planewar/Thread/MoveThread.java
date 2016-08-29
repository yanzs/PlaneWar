package com.jqorz.planewar.Thread;

import com.jqorz.planewar.Entity.Bomb;
import com.jqorz.planewar.Entity.Bullet;
import com.jqorz.planewar.Entity.ChangeBullet;
import com.jqorz.planewar.Entity.EnemyPlane;
import com.jqorz.planewar.Entity.GameView;

/**
 * 除了我方飞机外所有移动物的移动线程
 */

public class MoveThread extends Thread {
    GameView gameView;
    private boolean flag = true;//循环标志位

    public MoveThread(GameView gameView) {//构造器
        this.gameView = gameView;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        while (flag) {

            //子弹碰撞检测
            for (Bullet b : gameView.mBullet) {
                if (b.getY() < -b.getBitmap().getHeight()) {
                    b.setStatus(false);
                } else {
                    for (EnemyPlane ep : gameView.mEnemy) {
                        if (ep.getStatus() && b.getStatus() && ep.getBitmap() != null) {
                            if (ep.contain(b, gameView)) {//打中敌机
                                b.setStatus(false);
                            }
                        }
                    }
                }
            }

            //敌军飞机碰撞检测
            for (EnemyPlane ep : gameView.mEnemy) {

                if (ep.getY() > GameView.screenHeight) {
                    ep.setStatus(false);
                } else if (ep.getStatus() && gameView.plane.getStatus() && gameView.plane.getBitmap() != null) {
                    if (gameView.plane.contain(ep, gameView)) {
                        if (ep.getLife() <= 0) {
                            ep.setStatus(false);
                        }
                    }

                }

            }


            //移动炸弹补给
            Bomb b = gameView.bomb;
            if (b.getY() > GameView.screenHeight) {
                b.setStatus(false);
                b.reset();
            } else if (b.getStatus() && gameView.plane.getStatus() && gameView.plane.getBitmap() != null) {
                if (gameView.plane.contain(b, gameView)) {
                    b.setStatus(false);
                    b.reset();

                }

            }


            //移动子弹补给
            ChangeBullet cb = gameView.changeBullet;

            if (cb.getY() > GameView.screenHeight) {
                cb.setStatus(false);
                cb.reset();
            } else if (cb.getStatus() && gameView.plane.getStatus() && gameView.plane.getBitmap() != null) {
                if (gameView.plane.contain(cb,gameView)) {
                    cb.setStatus(false);
                    cb.reset();
                }


            }


        }
    }
}