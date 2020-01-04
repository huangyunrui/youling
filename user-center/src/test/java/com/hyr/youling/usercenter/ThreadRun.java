package com.hyr.youling.usercenter;

/*
 * @author hyr
 * @date 20-1-3-下午10:46
 * @description
 * */
public class ThreadRun {
    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            MyRunable myRunable1 = new MyRunable();
            Thread thread1 = new Thread(myRunable1);
            thread1.start();

        }
    }
}
