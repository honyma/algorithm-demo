/**
 * @author mazehong
 * @date 2024/8/8
 */
public class Test {


    boolean b = true;


    long x = 1;



    public void go1() {
        x = 40;
        b = false;
        System.out.println("go1方法打印x=" + x);
    }

    public void go2() {
        while (b) {
            System.out.println("go2方法循环");
        }
        System.out.println("go2方法打印x=" + x);
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                test.go2();

                System.out.println("线程a执行结束...");
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                test.go1();

                System.out.println("线程b执行结束...");
            }
        });
        a.start();
        b.start();
    }
}
