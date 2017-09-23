package com.gdut.points.util;

import com.gdut.points.component.Point;

public class PointFactory implements Runnable{

    public PointFactory() {

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            if (Data.isPlay){
                for(int i = 0;i < Const.COUNT; i++){
                    Point p = new Point();
                    Data.points.add(p);
                    p.start();
                }
                Data.lim.countDown();
                Data.count = Const.COUNT;
                break;
            }
            try {
                Thread.sleep(1000/Const.FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            if (Data.count < Const.COUNT) {
                Point p = new Point();
                Data.points.add(p);
                p.start();
                Data.count ++;
            }
            if (Data.gameOver){
                break;
            }
            try {
                Thread.sleep(1000/Const.FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        run();//...再次调用自己
    }
}
