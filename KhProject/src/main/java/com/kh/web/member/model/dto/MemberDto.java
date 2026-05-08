package com.kh.web.member.model.dto;

<<<<<<< HEAD
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
=======
import java.sql.Date;

public class MemberDto {
	private Long userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	public MemberDto() {
		super();
	}
	public MemberDto(String userId, String userPwd, String userName, String email) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
	}
	public MemberDto(Long userNo, String userId, String userPwd, String userName, String email, Date enrollDate,
			Date modifyDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
>>>>>>> b23dc6e (커밋 메시지)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
<<<<<<< HEAD
=======
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
>>>>>>> b23dc6e (커밋 메시지)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
<<<<<<< HEAD
=======
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "MemberDto [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
>>>>>>> b23dc6e (커밋 메시지)
	
	
}
