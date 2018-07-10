package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NotThreadSafe;
import java.util.Collections;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ImmutableExample2 {


  private  final  static Map<Integer,Integer>  maps = Maps.newHashMap();


  static {
    maps.put(1,2);
    maps.put(3,4);
    maps.put(5,6);
  }

  public static void main(String[] args) {
    maps.put(1,3);
    log.info("{}",maps.get(1));
  }

}
