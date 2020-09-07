package org.lijuny.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lijunyi
 */
@Mapper
@Repository
public interface StorageDao {
	void decrease(@Param("productId") Integer productId, @Param("count") Integer count);
}
