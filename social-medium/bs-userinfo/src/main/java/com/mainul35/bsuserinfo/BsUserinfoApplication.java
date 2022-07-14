package com.mainul35.bsuserinfo;

import com.mainul35.bsuserinfo.initialize.InitializeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BsUserinfoApplication implements CommandLineRunner {

    @Autowired
    private InitializeData initializeData;

    public static void main(String[] args) {
        SpringApplication.run(BsUserinfoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializeData.initialize();
    }
}
