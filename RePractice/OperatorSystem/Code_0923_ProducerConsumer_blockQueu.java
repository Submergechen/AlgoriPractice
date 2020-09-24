package RePractice.OperatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingDeque;

public class Code_0923_ProducerConsumer_blockQueu {

    public static void main(String[] agrs){

        BlockingQueue mantous =  new LinkedBlockingDeque();
        produce2 p = new produce2(mantous);
        consumer2 c = new consumer2(mantous);
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

class consumer2 implements Runnable {
    BlockingQueue mantous =  new LinkedBlockingDeque();

    public consumer2(BlockingQueue mantous) {
        this.mantous = mantous;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        while (true) {
            try {
                mantous.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class produce2 implements Runnable{
    BlockingQueue<String> mantous =  new LinkedBlockingDeque();

    public produce2(BlockingQueue mantous) {
        this.mantous = mantous;
    }

    @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            for (int i = 0;i < 10;i++){
                System.out.println();
                try {
                    mantous.put("mantous");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

