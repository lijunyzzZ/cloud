package org.lijuny.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountDao {
	void decreaseMoney(@Param("money") Integer money, @Param("id") Integer id);
}
