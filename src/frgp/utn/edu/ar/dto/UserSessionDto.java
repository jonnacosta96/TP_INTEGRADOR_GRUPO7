package frgp.utn.edu.ar.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserSessionDto {
	
	private String userName;
	private LocalDateTime activeSince;
	private String userType;
	public UserSessionDto() {
		super();
	}
	public UserSessionDto(String userName, LocalDateTime activeSince, String userType) {
		super();
		this.userName = userName;
		this.activeSince = activeSince;
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDateTime getActiveSince() {
		return activeSince;
	}
	public void setActiveSince(LocalDateTime activeSince) {
		this.activeSince = activeSince;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
