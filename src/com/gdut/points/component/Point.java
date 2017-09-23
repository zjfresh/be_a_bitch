package com.gdut.points.component;

import com.gdut.points.util.Const;
import com.gdut.points.util.Data;
import java.awt.geom.Rectangle2D;

/**
 * 不断发射的点
 */
public class Point extends Rectangle2D.Double implements Runnable {
    private final int TOP = 1;
    private final int RIGHT = 2;
    private final int BOTTOM = 3;
    private final int LEFT = 4;
    private boolean flag = true;
    private String s;
    private double l; //初始位置,不变
    private double n; //当前位置
    private double angle; //发射角度
    private int direct;
    private double k;//等于tan(angle)
    private double step;


    public Point() {
        s = ((int)Math.random() * 10000) + "";
        while (true) {
            if (Data.hashcode.contains(s)){
                s = (int)(Math.random() * 10000) + "";
            }
            Data.hashcode.add(s);
            break;
        }

        this.angle = Math.random()*Math.PI;
        //this.direct = RIGHT;
        this.direct = (int)(Math.random() * 4) + 1;
        this.k = Math.tan(angle);
        l = Math.random() * Const.WIDTH;
        n = l;
    }

    public void start() {
        new Thread(this).start();
    }

    /**
     * 移动，一个单位
     */
    private void move() {
        if (this.intersects(Data.BOOM)){
            Data.isPlay = false;
            Data.gameOver = true;
            return;
        }
        if (direct == TOP || direct == BOTTOM) {
            step = Math.abs(1 * Math.cos(angle));
            verticalMove();
        }else if (direct == RIGHT || direct == LEFT) {
            step = Math.abs(1 * Math.cos(angle));
            horizontalMove();
        }else{
            throw new IllegalArgumentException("不合法的边");
        }
    }

    @Override
    public void run() {
        try {
            Data.lim.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (flag && Data.isPlay && !Data.gameOver) {
            move();
            try {
                Thread.sleep(1000/Const.SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 出生在下边
     */
    private void verticalMove() {
        double y = direct == BOTTOM ? Const.MAINHEIGHT - Math.abs(k * (n - l)) : Math.abs(k * (n - l));
        if ((k > 0 && n < Const.WIDTH && y <= Const.MAINHEIGHT && y >= 0) || (k < 0 && n > 0 && y <= Const.MAINHEIGHT && y >= 0)) {
            this.setRect(n,y,5,5);
        }else{
            Data.points.remove(this);
            flag = false;
            Data.count --;
            return;
        }
        if (k > 0){
            n = n + step;
        }
        if (k < 0){
            n = n - step;
        }
    }

    private void horizontalMove() {
        double y = direct == RIGHT ? Const.WIDTH - Math.abs(k * (n - l)) : Math.abs(k * (n - l));
        if ((k > 0 && n <= Const.MAINHEIGHT && y <= Const.WIDTH && y >= 0 ) || (k < 0 && n >= 0 && y >= 0 && y <= Const.WIDTH)) {
            this.setRect(y,n,5,5);
        }else{
            Data.points.remove(this);
            flag = false;
            Data.count --;
            return;
        }
        if (k > 0){
            n = n + step;
        }
        if (k < 0){
            n = n - step;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(s);
    }
}


