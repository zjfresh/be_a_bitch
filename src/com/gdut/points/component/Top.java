package com.gdut.points.component;

import com.gdut.points.util.Const;
import com.gdut.points.util.Data;

import javax.swing.*;
import java.awt.*;

public class Top extends JPanel {
    private JLabel label;
    private JLabel score;

    public Top() {
        init();
    }

    void init() {
        this.setBackground(new Color(200,191,231));
        showLabel();
        this.add(label);
        this.add(score);
        this.setPreferredSize(new Dimension(Const.WIDTH,(Const.HEIGHT - Const.MAINHEIGHT)/2));
        this.setBorder(BorderFactory.createLineBorder(Color.cyan,1,false));
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000/Const.FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                score.setText(Data.LEVEL + "");
            }
            }).start();
    }


    private void showLabel() {
        label = new JLabel("关卡");
        score = new JLabel(Data.LEVEL + "");
    }

}
