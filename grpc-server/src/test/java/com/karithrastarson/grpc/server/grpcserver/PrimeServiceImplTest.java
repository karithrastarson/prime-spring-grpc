package com.karithrastarson.grpc.server.grpcserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class PrimeServiceImplTest {

    @TestConfiguration
    static class TestConfig {

        @Bean
        public PrimeServiceImpl primeServiceImpl() {
            return new PrimeServiceImpl();
        }
    }

    @Autowired
    PrimeServiceImpl primeService;

    @Test
    public void testPrime() {
        String primes = primeService.primes(1);
        assertEquals("", primes);

        primes = primeService.primes(17);
        assertEquals("2,3,5,7,11,13,17", primes);
    }
}
