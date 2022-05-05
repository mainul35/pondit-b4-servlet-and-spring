package com.homeWork3.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public Account getAccountDetails() {
        return this.account;
    }
}
