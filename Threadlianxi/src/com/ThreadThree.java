package com;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class ThreadThree extends Thread{

    private static int tick=10;

    @Override
    public void run(){
        while(tick>0){

            System.out.println(this.getName()+"剩余："+tick--+"票");
        }

    }
    public static void main(String[] args) {
        /*Thread thread1=new ThreadThree();
        thread1.setName("Thread-A");


        Thread thread2=new ThreadThree();
        thread2.setName("Thread-B");
        thread1.start();
        thread2.start();*/


        Runnable runnable=new Runnable() {
            private int tick=10;
            @Override
            public void run() {
                while(tick>0){
                    //Thread.currentThread()获取当前线程
                    System.out.println(Thread.currentThread().getName()+"剩余："+tick--+"票");
                }
            }
        };

      new Thread(runnable,"Thread-A").start();
      new Thread(runnable,"Thread-B").start();
    }
}
