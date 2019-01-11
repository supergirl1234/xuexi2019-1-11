package com;

/**
 * Author:Fanleilei
 * Created:2018/12/22 0022
 */
public class TestThread extends Thread{

    private String name;

    public TestThread(String name){
        this.name=name;

    }


    public void run(){
        for (int i=0;i<3;i++)
           System.out.println("这是第"+i+"个");

    }
    public static void main(String[] args) {
        TestThread thread1=new TestThread("thread1");
        thread1.start();
    }
}
