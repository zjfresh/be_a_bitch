package com.gdut.points.component;

import com.gdut.points.util.Const;
import com.gdut.points.util.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JPanel {
    public Main() {
        init();
    }

    private void init() {
        this.setBackground(new Color(174, 211,226));
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);
        this.setPreferredSize(new Dimension(Const.MAINWIDTH, Const.MAINHEIGHT));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (Data.isPlay && !Data.gameOver)
                Data.BOOM.setLocation(e.getX() - 20,e.getY() - 20);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(Data.BOOM);
        fillPoints(g2);
    }

    private void fillPoints(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        Data.points.forEach(g2::fill);
    }
}
