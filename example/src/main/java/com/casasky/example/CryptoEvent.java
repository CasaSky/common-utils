package com.casasky.example;

import com.casasky.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CryptoEvent {

    public String title;
    public String message;
    public Money money;
    public ZonedDateTime requestTime;

    @Builder.Default
    public ZonedDateTime responseTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/Berlin"));

}
