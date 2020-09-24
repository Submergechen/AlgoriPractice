package RePractice.OperatorSystem;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Code_0923_ProducerConsumer_1 {


    public static void main(String[] agrs){
        List<String> mantous = new ArrayList<>();
        produce1 p = new produce1(mantous);
        consumer1 c = new consumer1(mantous);
        Thread p1 = new Thread(p,"周杰伦");
        Thread p2 = new Thread(p,"林俊杰");
        Thread c1 = new Thread(c,"蔡依林");
        Thread c2 = new Thread(c,"侯佩岑");
        Thread c3 = new Thread(c,"田馥甄");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}

class consumer1 implements Runnable {
    private final List<String> mantous;

    public consumer1(List<String> mantous) {
        this.mantous = mantous;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        Random random = new Random();
        while (true) {
            synchronized (mantous) {
                int num = Math.abs(random.nextInt()) % 5 + 1;
                if (mantous.size() < num) {
                    mantous.notifyAll();
                    try {
                        mantous.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    for (int i = 0; i < num; i++) {
                        mantous.remove(mantous.size() - 1);
                    }
                    System.out.println(threadName + "我吃了" + num + "一个馒头，当前馒头数量为" + mantous.size()
                            + "！！！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
class produce1 implements Runnable{
        private final List<String> mantous;

        public produce1(List<String> mantous) {
            this.mantous = mantous;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (true){
                synchronized (mantous){
                    if (mantous.size() >= 10){
                        System.out.println(threadName + "当前馒头数量为" + mantous.size() + "！！！");
                        mantous.notifyAll();
                        try {

                            mantous.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        mantous.add("馒头");
                        System.out.println(threadName + "我生产了一个馒头,当前馒头数量为" + mantous.size() +  "！！！");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

