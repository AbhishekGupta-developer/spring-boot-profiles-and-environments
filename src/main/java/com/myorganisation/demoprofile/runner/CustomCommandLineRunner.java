package com.myorganisation.demoprofile.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    @Value("${application.thread.pool.size:10}")
    private int threadPoolsize;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("thread pool size is: " + threadPoolsize);
    }
}
