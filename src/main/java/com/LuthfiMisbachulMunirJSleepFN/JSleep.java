package com.LuthfiMisbachulMunirJSleepFN;

import java.util.*;

import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonDBEngine;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JSleep {
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}