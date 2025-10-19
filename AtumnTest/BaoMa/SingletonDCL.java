package AtumnTest.BaoMa;

public class SingletonDCL {
    private static volatile SingletonDCL instance = null;

    /**
     *构造方法虽然是默认的，但一旦执行就会将instance赋值某个内存的对象引用，从而和null区分开。
     */
    private SingletonDCL (){
        System.out.println("构造方法执行！");
    }

    /**
     * @return Singleton对象便于后续获取到单例对象。
     */
    private static SingletonDCL getInstance (){
        if (instance == null){
            synchronized (SingletonDCL.class){
                if (instance == null){
                    instance = new SingletonDCL();
                    System.out.println("单例对象已创建！");
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("开始执行main方法！");
        SingletonDCL instance1 = SingletonDCL.getInstance();
        SingletonDCL instance2 = SingletonDCL.getInstance();
        System.out.println("main方法执行完毕！");
        System.out.println("instance1 和 instance2 是否为同一个对象？");
        System.out.println(instance1 == instance2);
    }


}
