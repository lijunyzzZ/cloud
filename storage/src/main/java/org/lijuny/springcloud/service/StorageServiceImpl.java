package org.lijuny.springcloud.service;

import org.lijuny.springcloud.dao.StorageDao;
import org.lijuny.springcloud.service.impl.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lijunyi
 */
@Component
public class StorageServiceImpl implements StorageService {

	private final StorageDao dao;

	public StorageServiceImpl(StorageDao dao) {
		this.dao = dao;
	}

	@Override
	public void decrease(Integer productId, Integer count) {
		dao.decrease(productId, count);
	}
}
