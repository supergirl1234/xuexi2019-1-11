package com;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
//线程停止
    //通过标记位的方式终止线程
public class ThreadEight {


    public static void main(String[] args)  {

        Runnable mrunnable=new MRunnable();
        Thread thread=new Thread(mrunnable,"子线程");
        thread.start();

        try {
            Thread.sleep(3000);//这个地方是主线程休眠3S

            //修改标记位
            ((MRunnable) mrunnable).setFlag(false);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MRunnable implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while(this.flag){

            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i+"次");
            try {
                Thread.sleep(1000);  //如果不休眠sleep，1S中会执行上百万次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


