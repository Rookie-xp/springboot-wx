package com.test.demo.dao;

import java.util.List;

import com.test.demo.entity.User;

public interface UserDao {
	/**
	 * 列出区域列表
	 * 
	 * @return areaList
	 */
	List<User> queryUser();

	/**
	 * 根据Id列出具体区域
	 * 
	 * @return area
	 */
	User queryUserById(int userId);

	/**
	 * 插入区域信息
	 * 
	 * @param user
	 * @return
	 */
	int insertUser(User user);

	/**
	 * 更新区域信息
	 * 
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 * 删除区域信息
	 * 
	 * @param userId
	 * @return
	 */
	int deleteUser(int userId);
}
