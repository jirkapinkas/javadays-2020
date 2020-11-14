package com.example.springbootprometheus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.util.Random;

@EnableCaching
public class TestCacheConfiguration {

    @Lazy
    @Autowired
    private TestCacheConfiguration self;

    @Scheduled(fixedDelay = 1_000)
    public void run() {
        self.testCache(new Random().nextInt(100));
    }

    @Cacheable("testCache")
    public BigDecimal testCache(long number) {
        return BigDecimal.valueOf(number);
    }

}
