package com;

/**
 * Author:Fanleilei
 * Created:2019/1/10 0010
 */
public class ThreadTen {
    public static void code1() {
        //主线程的优先级
        System.out.println("主线程的优先级："+Thread.currentThread().getPriority());//5

        //在主线程中创建一个线程，并且不指定优先级
        Thread threadA=new Thread(()->{
            System.out.println(Thread.currentThread().getName()
                    +"优先级是："+Thread.currentThread().getPriority());
        },"Thread-A");//5
        //threadA.setPriority(6);
        threadA.start();
    }

    public static void main(String[] args) {

        //不要依赖优先级执行线程顺序
        Runnable runnable=new PriorityRunnable();
        Thread thread1=new Thread(runnable,"Thread-A");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        Thread thread2=new Thread(runnable,"Thread-B");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
        Thread thread3=new Thread(runnable,"Thread-C");
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread3.start();



    }
}

//看优先级的高低会不会影响线程的执行顺序
class PriorityRunnable implements Runnable{


    @Override
    public void run() {
        Thread t=Thread.currentThread();
        System.out.println(t.getName()+"优先级是："+t.getPriority());
        System.out.println(t.isDaemon());

    }
}
