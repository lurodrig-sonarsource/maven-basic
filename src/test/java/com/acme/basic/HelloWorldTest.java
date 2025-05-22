package com.acme.basic;


import org.junit.jupiter.api.Test;

public class HelloWorldTest {

  @Test
  public void sayHello() {
    /*try {
            //Thread.sleep(60000000);
	    Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    new HelloWorld().sayHello();
  }
}
