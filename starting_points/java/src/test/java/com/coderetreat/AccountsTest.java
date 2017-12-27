package com.coderetreat;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Clock;
import java.time.Instant;

import org.testng.annotations.Test;

/**
 * Created by Bogdan Azaric (bogdan.azaric@sbgenomics.com) on 12/27/17.
 */
@Test
public class AccountsTest {

  private static String HEADER = "Date Amount Balance";

  @Test
  public void newAccountShouldDisplayZeros() {
    assertThat(new Account(Clock.systemDefaultZone()).printStatement()).isEqualTo(HEADER);
  }

  @Test
  public void depositShouldIncreaseFunds() {
    // given
    Instant instant = Instant.now();
    Account account = buildAccount(instant);

    // when
    account.deposit(100);

    // then
    String expected = HEADER + "\\n" + instant.toString() + " 100 100";
    assertThat(account.printStatement()).isEqualTo(expected);
  }

  @Test
  public void multipleDepositsShouldIncreaseMultipleTimes() {
    // given
    Instant instant = Instant.now();
    Account account = buildAccount(instant);

    // when
    account.deposit(100);
    account.deposit(150);

    // then
    String expected = HEADER;
    expected += "\\n" + instant.toString() + " 100 100";
    expected += "\\n" + instant.toString() + " 150 250";

    assertThat(account.printStatement()).isEqualTo(expected);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void depositAmountShouldBeGreaterThanZero() {
    buildAccount(Instant.now()).deposit(-50);
  }

  private Account buildAccount(Instant instant) {
    return new Account(getClock(instant));
  }

  private Clock getClock(Instant instant) {
    Clock clock = mock(Clock.class);
    when(clock.instant()).thenReturn(instant);
    return clock;
  }

}
