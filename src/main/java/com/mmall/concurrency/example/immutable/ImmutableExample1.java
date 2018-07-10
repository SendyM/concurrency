package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NotThreadSafe;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

  private  final  static  Integer  a = 1;

  private  final  static  String   b = "2";

  private  final  static Map<Integer,Integer>  maps = Maps.newHashMap();


  static {
    maps.put(1,2);
    maps.put(3,4);
    maps.put(5,6);

  }

  public static void main(String[] args) {
    //a=2;
    //b="3";
    //maps=Maps.newHashMap();
    maps.put(1,3);
    log.info("{}",maps.get(1));
  }
  private  void  test(final int  a ){
    //a=1;
  }

}
