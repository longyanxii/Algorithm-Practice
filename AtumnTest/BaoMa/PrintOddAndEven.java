package AtumnTest.BaoMa;

class Solution {

    private final int maxCount; // 最大数字

    public Solution(int maxCount) {
        this.maxCount = maxCount;
    }

    // 开启两个线程分别打印奇数和偶数
    public void start() throws InterruptedException {
        // 线程 OddThread 调用 printOdd();
        Thread oddThread = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "OddThread");

        // 线程 EvenThread 调用 printEven();
        Thread evenThread = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "EvenThread");

        // 启动两个线程
        oddThread.start();
        evenThread.start();

        // 等待子线程执行完成
        oddThread.join();
        evenThread.join();
    }

    public void printOdd() throws InterruptedException {

        for (int i = 1; i <= maxCount ; i ++){
            if (i <= maxCount && i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
            Thread.sleep(1);
        }

    }

    public void printEven() throws InterruptedException {
        Thread.sleep(1);
        for (int i = 2 ;i <= maxCount ;i ++){
            if (i <= maxCount && i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
            Thread.sleep(1);
        }
    }
}

class PrintOddAndEven{
    public static void main(String[] args) {
            PrintOddAndEven option = new PrintOddAndEven();

    }
}
