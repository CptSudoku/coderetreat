package com.coderetreat;

import java.time.Clock;
import java.util.List;

import com.google.common.base.Preconditions;
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
    this.statement.add("Date Amount Balance");
  }

  public String printStatement() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < statement.size(); i++) {
      result.append(statement.get(i));
      result.append("\\n");
    }
    result.replace(result.lastIndexOf("\\n"), result.length(), "");
    return result.toString();
  }

  public void deposit(int i) {
    Preconditions.checkArgument(i > 0);

    this.i = i;
    statement.add(clock.instant() + " " + i + " " + i);
  }
}
