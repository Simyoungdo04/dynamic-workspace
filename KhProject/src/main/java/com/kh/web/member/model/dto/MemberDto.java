package com.kh.web.member.model.dto;

public class MemberDto {
	private long userNo;
	private String userName;
	private String userId;
	private String email;
	
	public MemberDto() {}
	public MemberDto(String userName, String userId, String email) {
		this.userName = userName;
		this.userId = userId;
		this.email = email;
	}
	public MemberDto(long userNo, String userName, String userId, String email) {
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.email = email;
	}
	
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
