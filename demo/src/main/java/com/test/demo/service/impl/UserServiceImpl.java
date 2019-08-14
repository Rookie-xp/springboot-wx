package com.test.demo.service.impl;

import java.util.Date;
import java.util.List;

import com.test.demo.dao.UserDao;
import com.test.demo.entity.User;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUserList() {
		// 返回所有的区域信息
		return userDao.queryUser();
	}

	@Override
	public User getUserById(int areaId) {
		return userDao.queryUserById(areaId);
	}

	@Transactional
	@Override
	public boolean addUser(User user) {
		// 空值判断，主要是判断areaName不为空
		if (user.getAreaName() != null && !"".equals(user.getAreaName())) {
			// 设置默认值
			user.setCreateTime(new Date());
			user.setLastEditTime(new Date());
			try {
				int effectedNum = userDao.insertUser(user);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean modifyUser(User user) {
		// 空值判断，主要是areaId不为空
		if (user.getAreaId() != null && user.getAreaId() > 0) {
			// 设置默认值
			user.setLastEditTime(new Date());
			try {
				// 更新区域信息
				int effectedNum = userDao.updateUser(user);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deleteUser(int userId) {
		if (userId > 0) {
			try {
				// 删除区域信息
				int effectedNum = userDao.deleteUser(userId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("id不能为空！");
		}
	}
}
