package com.mp.test;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mp.dao.UserMapper;
import com.mp.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void insert(){
		 User user = new User();
	     user.setName("刘明强");
	     user.setAge(31);
	     user.setManagerId(1088248166370832389L);
//	        user.setEmail("lmq@baomidou.com");
	     user.setCreateTime(LocalDateTime.now());
	     int row = userMapper.insert(user);
	     System.out.println("影响记录数："+row);
	}

	
	
	/**
	 * 未设置 id   由mybatis 自动生成 主键id
	 * 
	 * */
	@Test
	public void insert02(){
		 User user = new User();
	     user.setName("张帮龙02");
	     user.setAge(31);
	     user.setEmail("lmq@baomidou.com");
	     user.setCreateTime(LocalDateTime.now());
	     int row = userMapper.insert(user);
	     System.out.println("影响记录数："+row);
	}
	
	/**
	 * 数据库 字段 名称 与  bean 字段名称不一致
	 * 
	 * bean  对应字段 添加  注解   @TbableFileId
	 * 
	 * */
	@Test
	public void insert03(){
		 User user = new User();
	     user.setName("张帮龙04");
	     user.setAge(31);
	     user.setEmail("lmq@baomidou.com");
	     user.setCreateTime(LocalDateTime.now());
	     int row = userMapper.insert(user);
	     System.out.println("影响记录数："+row);
	}
	
	/**
	 * 数据库 未映射 字段   保存成功
	 * 
	 * bean  对应字段 添加  注解   @TbableFileId
	 * 
	 * */
	@Test
	public void insert04(){
		 User user = new User();
	     user.setName("张帮龙05");
	     user.setAge(31);
	     user.setRemark("这是备注信息");
	     user.setEmail("lmq@baomidou.com");
	     user.setCreateTime(LocalDateTime.now());
	     int row = userMapper.insert(user);
	     System.out.println("影响记录数："+row);
	}
}
