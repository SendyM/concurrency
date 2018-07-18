package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annoations.ThreadSafe;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Sets;

@Slf4j
@ThreadSafe
public class CollectionsExample2 {

  //同时并发的线程数
  private static int threadTotal = 200;
  //请求总数
  private static int clientTotal = 5000;

  private  static Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());
  public  static  void  main(String[] args) throws  Exception{
    ExecutorService exec = Executors.newCachedThreadPool();
    final Semaphore semaphore = new Semaphore(threadTotal);
    final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
    for (int index = 0 ; index <clientTotal ; index++) {
      final int count =index;
      exec.execute(()->{
        try{
          semaphore.acquire();
          update(count);
          semaphore.release();
        }catch (Exception e){
          log.error("exception",e);
        }
        countDownLatch.countDown();
      });
    }
    countDownLatch.await();
    exec.shutdown();
    log.info("size:{}", set.size());
  }
  private  static void update(int i){
    set.add(i);
  }

}
