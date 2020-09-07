package org.lijuny.springcloud.service.impl;

import org.lijuny.springcloud.dao.AccountDao;
import org.lijuny.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author lijunyi
 */
@Service
public class AccountServiceImpl implements AccountService {
	private final AccountDao accountDao;

	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void decreaseMoney(Integer money, Integer id) {
		accountDao.decreaseMoney(money, id);
	}
}
