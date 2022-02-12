package com.casasky;

import lombok.Builder;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Builder
public class CryptoEvent {

    public String title;
    public String message;
    public Money money;
    public ZonedDateTime requestTime;

    @Builder.Default
    public ZonedDateTime responseTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/Berlin"));

}
