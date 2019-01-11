package com;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class ThreadFour {

    public static void main(String[] args) {

        //业务
        Callable<String> callable=new MyCallable();
        FutureTask<String> futureTask=new FutureTask<>(callable);
        Thread thread=new Thread(futureTask);
        thread.start();


        //当前线程的名称
        System.out.println(Thread.currentThread().getName());
    }
}

class MyCallable implements Callable<String>{

    private int tick=10;

    @Override
    public String call() throws Exception {
        while(tick>10){
              //Thread.currentThread()获取当前线程
            System.out.println(Thread.currentThread().getName()+"剩余"+tick--+"张票");

        }
        return "票卖完了";
    }
}
