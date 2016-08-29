package com.jqorz.planewar.Entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.jqorz.planewar.Utils.ConstantUtil;

/**
 * 该类为子弹的封装类
 * 记录了子弹自身的相关参数
 * 外界通过调用move方法移动子弹
 */
public class Bullet {
    private int type;//子弹的类型
    private Bitmap bitmap;//当前子弹的图片
    private int x;
    private int y;//子弹的坐标
    private boolean status = true;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        setType(ConstantUtil.BULLET_RED);
    }


    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        switch (type) {
            case ConstantUtil.BULLET_RED:
                bitmap = GameView.bmp_bullet1;
                break;
            case ConstantUtil.BULLET_BLUE:
                bitmap = GameView.bmp_bullet2;
                break;
        }
        this.type = type;
    }


    public Bitmap getBitmap() {
        return bitmap;
    }


    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void draw(Canvas canvas) {//绘制的方法
        if (bitmap != null) {
            if (type == ConstantUtil.BULLET_RED) {
                canvas.drawBitmap(bitmap, x, y, new Paint());
            }
            if (type == ConstantUtil.BULLET_BLUE) {//子弹类型为2时，需要绘制3个子弹，呈三角形呈现
                canvas.drawBitmap(bitmap, x, y - ConstantUtil.BULLET_SPAN, new Paint());
                canvas.drawBitmap(bitmap, x - ConstantUtil.BULLET_SPAN, y, new Paint());
                canvas.drawBitmap(bitmap, x + ConstantUtil.BULLET_SPAN, y, new Paint());
            }
        }
    }

    public void move() {//移动的方法
        int moveSpan = ConstantUtil.BULLET_VELOCITY;
        this.y = this.y - moveSpan;

    }
}