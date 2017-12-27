package com.coderetreat;

/**
 * Created by Bogdan Azaric (bogdan.azaric@sbgenomics.com) on 12/27/17.
 */
public class Account {

  private int i;

  public String printStatement() {
    return "0 " + i;
  }

  public void deposit(int i) {

    this.i = i;
  }
}
