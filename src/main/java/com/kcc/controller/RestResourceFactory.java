package com.kcc.controller;

import java.util.UUID;

public class RestResourceFactory {
  
  private RestResourceFactory() {}
  
  public static <E> RestResource<E> newInstance() {
    RestResource<E> r = new RestResource<>();
    r.setKey(UUID.randomUUID());
    return r;
  }
}
