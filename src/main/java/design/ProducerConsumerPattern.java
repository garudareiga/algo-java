package design;

import java.util.concurrent.*;

public class ProducerConsumerPattern {
    public static class Producer implements Runnable {
        private final BlockingQueue<Double> queue;
        
        Producer(BlockingQueue<Double> queue) {
            this.queue = queue;
        }
        
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    queue.put(produce());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer: " + e.getMessage());
                //e.printStackTrace();        
            }
        }
        
        public Double produce() {
            double d = Math.random();
            System.out.println("Producing " + d);
            return d;
        }  
    }

    public static class Consumer implements Runnable {
        private final BlockingQueue<Double> queue;
        
        public Consumer(BlockingQueue<Double> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    consume(queue.take());
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer: " + e.getMessage());
                //e.printStackTrace();
            }
        }   
        
        public void consume(Double d) {
            System.out.println("Consuming " + d);
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Double> sharedQueue = new LinkedBlockingQueue<Double>();
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        
        producerThread.start();
        consumerThread.start();
        
        try {
            Thread.sleep(5000);
            producerThread.interrupt();
            consumerThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producer/Consumer pattern finished!");
    }
}
