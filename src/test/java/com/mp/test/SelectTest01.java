package com.mp.test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mp.dao.UserMapper;
import com.mp.entity.User;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest01 {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void select01(){
		User user=userMapper.selectById(1094592041087729666L);
		System.out.println(user);
	}

	
	@Test
	public void select02(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_name","张帮龙02");
		map.put("age",25);
		// 相当于   where name='张帮龙02' and  age=25
		//主要   map中  key  为 数据库字段名称
		List<User> user=userMapper.selectByMap(map);
		user.forEach(System.out::println);
	}
	
	
	
}
