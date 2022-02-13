package com.casasky.example;

import com.casasky.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class CryptoEventController {

    @PostMapping("/")
    CryptoEvent info(@RequestBody CryptoEvent jacksonEvent) {
        log.info("http message received {}", JsonUtil.toJson(jacksonEvent));
        return jacksonEvent;
    }

}