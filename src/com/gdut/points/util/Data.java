package com.gdut.points.util;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Data {
    public static int LEVEL = 1;

    public static final Rectangle BOOM = new Rectangle();

    public static final Set<Rectangle2D.Double> points = new HashSet<>();

    public static int count = 0;//缓存点的个数

    public static Set<String> hashcode = new HashSet<>();

    public static CountDownLatch lim = new CountDownLatch(1);

    public static volatile boolean isPlay = false;

    public static volatile boolean gameOver = false;

    private static Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
    private static Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
    public static int screenWidth = screenSize.width; //获取屏幕的宽
    public static int screenHeight = screenSize.height; //获取屏幕的高

    static {
        BOOM.setSize(40,40);
        BOOM.setLocation(Const.WIDTH/2,Const.MAINHEIGHT/2);
        Collections.synchronizedSet(points);
    }

    public static void clear() {
        LEVEL = 1;
        points.clear();
        count = 0;
        hashcode.clear();
        gameOver = false;
        BOOM.setLocation(Const.WIDTH/2,Const.HEIGHT/3);


        Const.reset();
    }
}
