package com.example.springbootprometheus;

import io.github.mweirauch.micrometer.jvm.extras.ProcessMemoryMetrics;
import io.github.mweirauch.micrometer.jvm.extras.ProcessThreadMetrics;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootPrometheusApplication {

    // https://github.com/mweirauch/micrometer-jvm-extras
    @Bean
    public MeterBinder processMemoryMetrics() {
        return new ProcessMemoryMetrics();
    }

    // https://github.com/mweirauch/micrometer-jvm-extras
    @Bean
    public MeterBinder processThreadMetrics() {
        return new ProcessThreadMetrics();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPrometheusApplication.class, args);
    }

}
