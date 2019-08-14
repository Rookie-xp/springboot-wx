package com.test.demo.service;

import java.util.List;

import com.test.demo.entity.User;

public interface UserService {

	/**
	 * 获取区域列表
	 * 
	 * @return
	 */
	List<User> getUserList();

	/**
	 * 通过区域Id获取区域信息
	 * 
	 * @param userId
	 * @return
	 */
	User getUserById(int userId);

	/**
	 * 增加区域信息
	 * 
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * 修改区域信息
	 * 
	 * @param user
	 * @return
	 */
	boolean modifyUser(User user);

	/**
	 * 删除区域信息
	 * 
	 * @param userId
	 * @return
	 */
	boolean deleteUser(int userId);

}
