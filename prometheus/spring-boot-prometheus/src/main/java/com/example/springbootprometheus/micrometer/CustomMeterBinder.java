package com.example.springbootprometheus.micrometer;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

import java.util.Random;

public class CustomMeterBinder implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        Gauge.builder("custom_stuff", this, value -> value.getCustomValue())
                .description("Just Regular Custom Stuff")
                .register(meterRegistry);
    }

    private Double getCustomValue() {
        return (double) new Random().nextInt(10);
    }

}
