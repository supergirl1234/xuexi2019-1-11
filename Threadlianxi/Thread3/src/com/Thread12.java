package com;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
public class Thread12 {
    public static void main(String[] args) {
        //共享业务逻辑
        Runnable runnable=new TicketRunnable();

        Thread threadA=new Thread(runnable,"黄牛A");
        Thread threadB=new Thread(runnable,"黄牛B");
        Thread threadC=new Thread(runnable,"黄牛C");
        threadA.start();
        threadB.start();
        threadC.start();
    }


}

class TicketRunnable implements Runnable{

    private  int ticket=10;
    @Override
    public void run() {
        //this指的是Runnable对象
        synchronized (this){

            while(this.ticket>0){

                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"还剩余"+(this.ticket--)+"张票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            System.out.println(Thread.currentThread().getName()+"票卖光了");
        }
    }
}
