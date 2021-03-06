package com.jqorz.planewar.Thread;

import com.jqorz.planewar.Entity.EnemyPlane;
import com.jqorz.planewar.Entity.GameView;
import com.jqorz.planewar.Entity.Plane;
import com.jqorz.planewar.Utils.ConstantUtil;

/**
 * 该类是为飞机运行时动画服务的线程类，
 * 主要的操作是换帧
 */
public class RunThread extends Thread {
    GameView gameView;
    private boolean flag = true;//循环标记位


    public RunThread(GameView gameView) {//构造器
        this.gameView = gameView;
    }

    public void setFlag(boolean flag) {//设置循环标记位
        this.flag = flag;
    }

    public void run() {
        while (flag) {
            //绘制英雄飞机动画
            Plane p = gameView.plane;
            p.nextFrame();

            //绘制所有的敌军飞机动画
            for (EnemyPlane e : gameView.mEnemy) {
                e.nextFrame();
            }

            try {
                Thread.sleep(ConstantUtil.RUN_THREAD_SPAN);//睡眠休息
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}