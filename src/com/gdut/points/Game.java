package com.gdut.points;

import com.gdut.points.component.Bottom;
import com.gdut.points.component.Main;
import com.gdut.points.component.MyDialog;
import com.gdut.points.component.Top;
import com.gdut.points.util.Const;
import com.gdut.points.util.Data;
import com.gdut.points.util.PointFactory;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame implements Runnable {
    private JPanel top;
    private JPanel main;
    private JPanel bottom;
    private MyDialog dialog = new MyDialog(this,"欢迎");

    public static void main(String[] args) {
        Game game = new Game();
        try {
            Class.forName("com.gdut.points.util.Const");
            //Class.forName("com.gdut.points.util.PointFactory");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        new PointFactory();
        game.init();
        new Thread(game).start();
    }

    private void init() {
        //this.getContentPane().setSize(Const.WIDTH,Const.HEIGHT);
        this.setSize(Const.WIDTH,Const.HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        initMain();
        initTop();
        initBottom();
        this.add(main,BorderLayout.CENTER);
        this.add(top,BorderLayout.NORTH);
        this.add(bottom,BorderLayout.SOUTH);
        this.setVisible(true);
        dialog.setVisible(true);
        main.setRequestFocusEnabled(true);
        main.requestFocus();
    }

    private void initTop() {
        this.top = new Top();
    }

    private void initMain() {
        this.main = new Main();
    }

    private void initBottom() {
        this.bottom = new Bottom();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000/Const.FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Data.gameOver){
                dialog.setTitle("游戏结束！");
                dialog.setVisible(true);
                Data.clear();
            }
            main.repaint();
        }
    }
}
