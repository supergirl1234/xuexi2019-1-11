package com;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
//线程停止
    //通过标记位的方式终止线程
public class ThreadNine {


    public static void main(String[] args)  {

        Runnable mrunnable=new MRunnable2();
        Thread thread=new Thread(mrunnable,"子线程");
        thread.start();

        try {
            Thread.sleep(3000);//这个地方是主线程休眠3S

            //主动调用thread中断方法
           thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MRunnable2 implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while(this.flag){

            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i+"次");
            try {

                //判断线程的中断情况
                boolean interruptedStatus= Thread.currentThread().isInterrupted();
                //非阻塞情况
                if (interruptedStatus) {
                     break;
                }

               Thread.sleep(1000);  //如果不休眠sleep，1S中会执行上百万次
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("阻塞中断"+Thread.currentThread().isInterrupted());
                return;
            }
        }

    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


