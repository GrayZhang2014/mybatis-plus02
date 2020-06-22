package com.mp.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data   //编译时  自动 加入   get  set方法
public class User {
	
	@TableId   //表示 主键  mybatis plus  中  默认的名称未 id 
    private Long userId;

    private String name;

    private Integer age;

    private String email;

    //直属上级
    private Long managerId; 

    
    //创建时间
    private LocalDateTime createTime;
    
    @TableField(exist=false)
    private String remark;
}
