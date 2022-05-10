package com.pondit.b4.config;

import com.pondit.b4.service.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.homeWork3.service"})
public class RootConfig {

    @Bean
    public Account accountDetails() {
        Account account = new Account();
        account.setAccountId("1234");
        account.setAccountType("Business");
        account.setAccountHolderName("ABC Org");
        return account;
    }

}

