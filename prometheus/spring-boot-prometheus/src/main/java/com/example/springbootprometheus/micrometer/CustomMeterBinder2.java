package com.example.springbootprometheus.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class CustomMeterBinder2 implements MeterBinder {

    private Timer timer;

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        timer = meterRegistry.timer("long.operation.run.timer");
    }

    @Scheduled(fixedDelay = 3_000)
    public void sampleLongOperation() throws InterruptedException {
        long startTime = System.nanoTime();
        Thread.sleep(new Random().nextInt(7_000));
        timer.record(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

    }

}
