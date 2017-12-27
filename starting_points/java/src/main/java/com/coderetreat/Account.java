package com.coderetreat;

import java.time.Clock;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created by Bogdan Azaric (bogdan.azaric@sbgenomics.com) on 12/27/17.
 */
public class Account {

  private final Clock clock;
  private List<String> statement;
  private int i;

  public Account(Clock clock) {
    this.clock = clock;
    this.statement = Lists.newArrayList();
  }

  public String printStatement() {
    if (statement.isEmpty()) {
      return "0 0";
    }

    return statement.get(0);
  }

  public void deposit(int i) {
    this.i = i;
    statement.add(i + " " + i);
  }
}
