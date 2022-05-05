package com.homeWork3.config;

import com.homeWork3.service.Account;
import com.homeWork3.service.AccountService;
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

