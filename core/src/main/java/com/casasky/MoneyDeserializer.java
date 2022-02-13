package com.casasky;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class MoneyDeserializer extends StdDeserializer<Money> {

    public MoneyDeserializer() {
        this(null);
    }

    protected MoneyDeserializer(Class<Money> t) {
        super(t);
    }

    @Override
    public Money deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        BigDecimal amount = BigDecimal.valueOf(node.get("amount").asDouble());
        String currency = node.get("currency").asText();

        return Money.valueOf(amount, currency);
    }

}
