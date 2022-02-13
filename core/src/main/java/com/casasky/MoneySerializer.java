package com.casasky;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MoneySerializer extends StdSerializer<Money> {

    public MoneySerializer() {
        this(null);
    }

    protected MoneySerializer(Class<Money> t) {
        super(t);
    }

    @Override
    public void serialize(Money money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("amount", money.getAmount());
        jsonGenerator.writeStringField("currency", money.getCurrency());
        jsonGenerator.writeEndObject();
    }
}
