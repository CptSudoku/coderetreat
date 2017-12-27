package com.coderetreat;

import java.time.Clock;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * Created by Bogdan Azaric (bogdan.azaric@sbgenomics.com) on 12/27/17.
 */
public class Account {

  public static final String NEW_LINE = "\\n";
  private final Clock clock;
  private List<String> statement;
  private int balance;

  public Account(Clock clock) {
    this.clock = clock;
    this.statement = Lists.newArrayList();
    this.statement.add("Date Amount Balance");
  }

  public String printStatement() {
    StringBuilder result = new StringBuilder();

    for (String statementElement : statement) {
      result.append(statementElement);
      result.append(NEW_LINE);
    }

    result.replace(result.lastIndexOf(NEW_LINE), result.length(), "");
    return result.toString();
  }

  public void deposit(int amount) {
    Preconditions.checkArgument(amount > 0);
    adjustBalance(amount);
  }

  public void withdraw(int amount) {
    Preconditions.checkArgument(amount > 0);
    adjustBalance(-amount);
  }

  private void adjustBalance(int amount) {
    balance += amount;
    statement.add(clock.instant() + " " + amount + " " + balance);
  }
}
