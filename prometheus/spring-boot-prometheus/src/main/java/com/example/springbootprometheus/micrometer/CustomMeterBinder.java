package com.example.springbootprometheus.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomMeterBinder implements MeterBinder {

    private Counter counter;

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        Gauge.builder("custom_gauge", this, value -> value.getCustomValue())
                .description("Custom Gauge")
                .register(meterRegistry);
        counter = Counter.builder("custom_counter")
                .description("Custom Counter")
                .register(meterRegistry);
    }

    private Double getCustomValue() {
        counter.increment();
        return (double) new Random().nextInt(10);
    }

}
