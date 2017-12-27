package com.coderetreat;


import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

/**
 * Created by Bogdan Azaric (bogdan.azaric@sbgenomics.com) on 12/27/17.
 */
@Test
public class AccountsTest {

  @Test
  public void newAccountShouldDisplayZeros() {
    assertThat(new Account().printStatement()).isEqualTo("0 0");
  }

  @Test
  public void depositShouldIncreaseFunds() {
    Account account = new Account();

    account.deposit(100);

    assertThat(account.printStatement()).isEqualTo("0 100");
  }

}
