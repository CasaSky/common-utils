package com.casasky.example;

import com.casasky.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CryptoEventControllerTest {

    @Autowired
    private CryptoEventController sut;

    @Test
    public void smokeTest() {
        assertThat(sut).isNotNull();

        var sentEvent = CryptoEvent.builder()
                .message("message")
                .title("title")
                .requestTime(ZonedDateTime.now())
                .money(Money.valueOf(BigDecimal.valueOf(1.5), "BTC"))
                .build();

        CryptoEvent response = sut.info(sentEvent);

        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(sentEvent);
    }
}