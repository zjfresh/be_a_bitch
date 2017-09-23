package com.gdut.points.component;

import com.gdut.points.util.Const;
import com.gdut.points.util.Data;

import javax.swing.*;
import java.awt.*;

public class Bottom extends JPanel {
    private JProgressBar progressBar;

    public Bottom() {
        this.setPreferredSize(new Dimension(Const.WIDTH,(Const.HEIGHT - Const.MAINHEIGHT)/2));
        this.setBackground(new Color(231,208,197));
        initJProgressBar();
        this.add(progressBar);
        new Thread(()->{
            int count = 0;
            while (count  <= 100 ) {
                if (Data.isPlay) {
                    try {
                        Thread.sleep((Const.TIME * 1000) / 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setValue(count);
                    if (count == 100) {
                        count = 0;
                        Data.LEVEL++;
                        Const.SPEED = Const.SPEED + Const.SPEED / 3;
                        Const.COUNT = Const.COUNT + Const.COUNT / 3;
                    }
                    count++;
                }
                if (Data.gameOver){
                    count = 0;
                }
            }
        }).start();
    }

    private void initJProgressBar() {
        progressBar = new JProgressBar(0,100);
        progressBar.setStringPainted(true);
        //progressBar.setPreferredSize(new Dimension(Const.WIDTH - 30,Const.HEIGHT/17 - 8));
    }

}
