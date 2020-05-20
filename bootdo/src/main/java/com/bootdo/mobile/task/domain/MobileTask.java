package com.bootdo.mobile.task.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MobileTask implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long taskId;
	
	private String taskTitle;	
	private String taskDesc;
	private Integer shareCount;
	private String webUrl;
	private Date createDate;
	private Date modifiedDate;
	private Date fromDate;
	//截止日期
	private Date expireDate;
	private String address;
	private Float money;
	private String imageUrl;
	private String videoUrl;
	private String voiceUrl;

}
