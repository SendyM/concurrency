package com.mmall.concurrency.example.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CyclicBarrierExample3 {

  private static CyclicBarrier barrier = new CyclicBarrier(5,()-> log.info("callback is running"));

  public static void main(String[] args) throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      final int threadNum = i;
      Thread.sleep(1000);
      executor.execute(() -> {
        try {
          race(threadNum);
        } catch (Exception e) {
          log.error("exception", e);
        }

      });
    }
    executor.shutdown();
  }

  private static void race(int threadNum) throws Exception {
    Thread.sleep(1000);
    log.info("{} is ready", threadNum);
    barrier.await();
    log.info("{} is continue",threadNum);
  }
}
