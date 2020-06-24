package com.mp.test;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mp.dao.UserMapper;
import com.mp.entity.User;



/**
 * 
 * 条件 构造器 查询测试
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectByWrapper {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void slelectByallEq(){
		
		QueryWrapper<User>  queryWrapper=new QueryWrapper<User>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name","张帮龙");
		map.put("age",31);
		queryWrapper.allEq(map);
		List<User>  list=userMapper.selectList(queryWrapper);
	    list.forEach(System.out::println);
		
	}
	
	@Test
	public void selectByWrapper(){
		
		//   名字中包含雨并且年龄小于40
		//   name like '%雨%' and age<40
		QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
		queryWrapper.like("name","雨").lt("age",40);
        List<User> list=userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}
	
	@Test
	public void selectByWrapper01(){
		
		//   名字中包含雨并且年龄小于40
		//   name like '%雨%' and age<40
		QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
		queryWrapper.likeRight("name", "王").and(wq->wq.lt("age", 40).or().isNotNull("email"));
        List<User> list=userMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}
}
