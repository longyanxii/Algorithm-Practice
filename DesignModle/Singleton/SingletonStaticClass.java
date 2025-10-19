package DesignModle.Singleton;

import AtumnTest.BaoMa.SingletonDCL;

public class SingletonStaticClass {
    private SingletonStaticClass(){
        System.out.println("构造方法执行！");
    }

    /**
     * 1.只有在第一次调用getInstance()方法时，才会执行LazyHolder（静态内部类）
     * 2.类加载中clinit()方法只会执行一次，并且会自动地加锁放锁保证线程安全。
     */
    private static class LazyHolder{
        private static final SingletonStaticClass INSTANCE = new SingletonStaticClass();
        static {
            System.out.println("静态内部类初始化INSTANCE完成！");
        }
    }

    public static SingletonStaticClass getInstance(){
        System.out.println("getInstance执行！");
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("main方法执行！");
        SingletonStaticClass instance1 = getInstance();
        SingletonStaticClass instance2 = getInstance();
        System.out.println("instance1是否与instance2相同？");
        System.out.println(instance1 == instance2);
        System.out.println("main方法执行完毕！");

    }
}
