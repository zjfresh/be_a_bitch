package com.gdut.points.component;

import com.gdut.points.util.Const;
import com.gdut.points.util.Data;

import javax.swing.*;
import java.awt.*;

public class MyDialog extends JDialog {
    public MyDialog(JFrame owner,String title) {
        super(owner,title,true);
        JPanel panel = new JPanel();
        this.setBounds(Data.screenWidth/2 - 40,Data.screenHeight/2 - 50,Const.WIDTH/2,100);

        JButton start = new JButton("开始");
        //start.setPreferredSize(new Dimension(Const.WIDTH/5, Const.HEIGHT/20));
        start.setBackground(new Color(200,191,231));
        start.setFont(new Font("DialogInput",Font.PLAIN,12));
        start.setFocusable(false);
        start.addActionListener(e-> {
            Data.isPlay = true;
            Data.gameOver = false;
            this.setVisible(false);
        });

        JButton cancel = new JButton("退出");
        //start.setPreferredSize(new Dimension(Const.WIDTH/5, Const.HEIGHT/20));
        cancel.setBackground(new Color(200,191,231));
        cancel.setFont(new Font("DialogInput",Font.PLAIN,12));
        cancel.setFocusable(false);

        cancel.addActionListener(e-> {
            System.exit(0);
            this.setVisible(false);
        });

        panel.add(start);
        panel.add(cancel);
        add(panel);
        //setSize(Const.WIDTH/2,100);

    }
}
