package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;
import java.util.Collections;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {


  private   static Map<Integer,Integer>  maps;


  static {
    maps.put(1,2);
    maps.put(3,4);
    maps.put(5,6);
    maps=Collections.unmodifiableMap(maps);
  }

  public static void main(String[] args) {
    maps.put(1,3);
    log.info("{}",maps.get(1));
  }

}
