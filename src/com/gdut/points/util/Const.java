package com.gdut.points.util;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Const {
    private static final Properties properties;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int MAINWIDTH;
    public static final int MAINHEIGHT;
    public static final int FPS;
    public static final int TIME;
    public static int SPEED;
    public static int COUNT;

    static{
        properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
        } catch (IOException e) {
            System.out.println("找不到配置文件");
            e.printStackTrace();
        }
        WIDTH = Integer.valueOf(properties.getProperty("width"));
        HEIGHT = Integer.valueOf(properties.getProperty("height"));
        MAINWIDTH = Integer.valueOf(properties.getProperty("mainWidth"));
        MAINHEIGHT = Integer.valueOf(properties.getProperty("mainHeight"));
        FPS = Integer.valueOf(properties.getProperty("fps"));
        SPEED = Integer.valueOf(properties.getProperty("speed"));
        COUNT = Integer.valueOf(properties.getProperty("count"));
        TIME = Integer.valueOf(properties.getProperty("time"));
    }

    public static void reset() {
        SPEED = Integer.valueOf(properties.getProperty("speed"));
        COUNT = Integer.valueOf(properties.getProperty("count"));
    }

    public static void main(String[]args) {
        System.out.println(WIDTH);
        System.out.println(HEIGHT);
        System.out.println(MAINHEIGHT);
        System.out.println(MAINHEIGHT);
    }
}
