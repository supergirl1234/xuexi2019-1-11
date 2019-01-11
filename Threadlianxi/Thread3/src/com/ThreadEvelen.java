package com;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
public class ThreadEvelen {
    public static void main(String[] args) {
        //主线程是非守护线程（用户线程）
        //System.out.println(Thread.currentThread().isDaemon());

        //线程ThreadA
        Thread threadA=new Thread(new DaemonRuable(),"Thread-A");
        //必须在start之前调用，否则无效
        threadA.setDaemon(true);//设置为守护线程
        threadA.start();

        //线程ThreadB
        Thread threadB=new Thread(new DaemonRuable(),"Thread-B");
        threadB.start();

        //主线程
        try {
            Thread.sleep(3000);

            threadB.interrupt();

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DaemonRuable implements  Runnable{


    @Override
    public void run() {
        int i=0;
        try {
            while(true){

                System.out.println(Thread.currentThread().getName()+"调用第"+ ++i +"次");

                    Thread.sleep(1000);
                }
        }catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"中断");

        }
    }
}