package com.thecodereveal.core.di;

import com.thecodereveal.core.models.Account;

public class SavingAccount implements AccountService {

	@Override
	public void create(Account account) {
		System.out.println("Creating Savings Account");
	}

}
