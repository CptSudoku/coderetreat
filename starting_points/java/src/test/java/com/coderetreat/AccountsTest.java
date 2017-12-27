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

  private static String HEADER = "Date Amount Balance\\n";

  @Test
  public void newAccountShouldDisplayZeros() {
    assertThat(new Account(Clock.systemDefaultZone()).printStatement()).isEqualTo("0 0");
  }

  @Test
  public void depositShouldIncreaseFunds() {
    // given
    Instant instant = Instant.now();
    Account account = new Account(getClock(instant));

    // when
    account.deposit(100);

    // then
    String expected = HEADER + instant.toString() + " 100 100";
    assertThat(account.printStatement()).isEqualTo(expected);
  }

  private Clock getClock(Instant instant) {
    Clock clock = mock(Clock.class);
    when(clock.instant()).thenReturn(instant);
    return clock;
  }

}
