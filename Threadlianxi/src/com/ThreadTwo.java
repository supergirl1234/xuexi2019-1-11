package com;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */

//使用多线程方法
    //1.复用业务逻辑
    //2.实现Runnable接口，可以继续实现接口
    //3.实现Runnable接口，可以采用函数式编程
public class ThreadTwo {

    public static void main(String[] args) {

        PrintInfo printInfo=new PrintInfo();
        printInfo.print("hsh","qwt","dwn");


        Runnable runnable1=new PrintInfoRunnable(printInfo);
        Thread thread1=new Thread(runnable1);
        thread1.start();
        Thread thread2=new Thread(runnable1);
        thread2.start();



        //这个地方的Lambda表达式没太懂
        Thread thread3=new Thread(()->printInfo.print("hello","hi"));
        System.out.println(thread3.getName());
        thread3.start();

        Thread thread4=new Thread(()->printInfo.print("hello","hi"));
       thread4.setName("xxx");
        System.out.println(thread4.getName());
        thread4.start();
    }
}

class PrintInfo{

    public void print(Object... args){
        for (int i=0;i<args.length;i++)
            System.out.println(args[i]);
    }
}

class PrintInfoRunnable implements Runnable{

    private  final PrintInfo task;
    public PrintInfoRunnable(PrintInfo task){
        this.task=task;

    }

    @Override
    public void run() {
        this.task.print("Hello","jaii","sqii");
    }
}
