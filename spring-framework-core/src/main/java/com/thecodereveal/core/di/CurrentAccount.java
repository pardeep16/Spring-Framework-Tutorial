package com.thecodereveal.core.di;

import com.thecodereveal.core.models.Account;

public class CurrentAccount implements AccountService {
	
	private Account account;

	@Override
	public void create(Account account) {
		System.out.println("Creating Current Account");
		System.out.println("Id "+account.getAccountId());
	}

}
