package com;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
public class ThreadSeven {

    public static void main(String[] args) {

        //业务逻辑
        MyRunnable runnable=new MyRunnable();

        //线程
        Thread thread=new Thread(runnable,"Thread-A");//这个线程在main线程下建立的线程
        thread.start();

        //在主线程中调用线程对象的join方法，会阻塞主线程
        //直到调用线程对象的run方法执行完毕，主线程才会继续执行
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前线程："+Thread.currentThread().getName());//main


    }
}

 class MyRunnable implements Runnable{

     private static int tick=10;
     @Override
     public void run() {
         while(tick>0){

             System.out.println(Thread.currentThread().getName()+"剩余："+tick--+"票");
         }

     }
 }
