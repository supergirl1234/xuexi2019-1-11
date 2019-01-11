package com;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class ThreadFirst extends Thread{

    private  String title;

    public ThreadFirst( String title) {

        this.title = title;
    }

    @Override
    public void run(){

        //多线程处理的业务逻辑
        for(int i=0;i<10;i++){
            System.out.println(this.title+" "+i);

        }
    }

    public static void main(String[] args) {

        //如果用run调用，就只会按顺序调用，这和多线程没有关系
        //所以正确启动多线程的方式是调用Thread类中的start()方法

        ThreadFirst threadFirst1=new ThreadFirst("线程1");
        //threadFirst1.run();
        threadFirst1.start();
        ThreadFirst threadFirst2=new ThreadFirst("线程2");
        //threadFirst2.run();
        threadFirst2.start();
        ThreadFirst threadFirst3=new ThreadFirst("线程3");
        //threadFirst3.run();
        threadFirst3.start();
    }
}
