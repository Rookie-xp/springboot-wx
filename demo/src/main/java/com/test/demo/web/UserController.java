package com.test.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.demo.entity.User;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 获取所有的区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listuser", method = RequestMethod.GET)
	private Map<String, Object> listArea() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<User> list = new ArrayList<User>();
		// 获取区域列表
		list = userService.getUserList();
		modelMap.put("areaList", list);
		return modelMap;
	}

	/**
	 * 通过区域Id获取区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getuserbyid", method = RequestMethod.GET)
	private Map<String, Object> getAreaById(Integer userId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		User user = userService.getUserById(userId);
		modelMap.put("area", user);
		return modelMap;
	}

	/**
	 * 添加区域信息
	 *
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody User user)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", userService.addUser(user));
		return modelMap;
	}

	/**
	 * 修改区域信息，主要修改名字

	 */
	@RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody User user)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", userService.modifyUser(user));
		return modelMap;
	}

	@RequestMapping(value = "/removeuser", method = RequestMethod.GET)
	private Map<String, Object> removeArea(Integer areaId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", userService.deleteUser(areaId));
		return modelMap;
	}

}
