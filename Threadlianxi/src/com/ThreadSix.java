package com;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
public class ThreadSix {

    public static void main(String[] args) {
        Runnable runnable=()->{

            for (int i=0;i<3;i++){


                Thread.yield();
                System.out.println(Thread.currentThread().getName()+"i="+i);
            }

        };

        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();
        new Thread(runnable,"Thread-C").start();

    }
}
