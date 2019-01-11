package com;

import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
public class ThreadFive {


    public static void main(String[] args) {


       /* //最简洁的写法
        new Thread(()->{

          while(true){

              try {
                  Thread.sleep(1000);//1000ms,每休息1S执行一次
                  System.out.println("执行 当前时："+LocalDateTime.now());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        },"Thread-A").start();*/



       //写多个

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(1000);//1000ms,每休息1S执行一次
                        System.out.println(Thread.currentThread().getName()+"执行当前时间：" + LocalDateTime.now());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };

        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();
        new Thread(runnable,"Thread-C").start();

    }
}
