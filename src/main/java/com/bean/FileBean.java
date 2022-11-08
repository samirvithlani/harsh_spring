package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class FileBean {

	private String userName;
	private MultipartFile profilePic;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}
	
	
}
