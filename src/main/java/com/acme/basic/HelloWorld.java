package com.acme.basic;

public class HelloWorld {

  void sayHello() {
     try {
            System.out.println("go to sleep...");
	    Thread.sleep(60000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }	  
    System.out.println("Hello World!");
  }

  void notCovered() {
    System.out.println("This method is not covered by unit tests");
  }

}
