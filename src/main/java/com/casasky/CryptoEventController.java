package com.casasky;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CryptoEventController {

    @PostMapping("/")
    CryptoEvent info(@RequestBody CryptoEvent jacksonEvent) {
        return jacksonEvent;
    }

}