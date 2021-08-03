package com.thecodereveal.core.di;

import com.thecodereveal.core.models.Account;

public class MyBankAccount {
	
	private AccountService accountService;
	private String name;
	private Account account;
	
	public MyBankAccount(AccountService accountService,Account account) {
		this.accountService=accountService;
		this.account=account;
	}
	
	public void createAccount() {
		accountService.create(account);
	}
	
	

}
