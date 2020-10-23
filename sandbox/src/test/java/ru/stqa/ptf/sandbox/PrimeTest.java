package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest {

  @Test

  public void primeTest1(){

    Assert.assertTrue(Prime.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void primeTest2(){

    Assert.assertFalse(Prime.isPrime(Integer.MAX_VALUE-2));
  }
  @Test(enabled = false)
  public void primeTest3(){
long n = Integer.MAX_VALUE;
    Assert.assertTrue(Prime.isPrime(n));
  }

  @Test

  public void primeTestFast(){

    Assert.assertTrue(Prime.isPrimeFast(Integer.MAX_VALUE));
  }
}
