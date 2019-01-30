package com.example.demo.controller;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProfileForm {

	@Size(min=2,message="请输入有效的用户名")
	private String twiiterHandle;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotNull
	private LocalDate birthDate;

	public String getTwiiterHandle() {
		return twiiterHandle;
	}

	public void setTwiiterHandle(String twiiterHandle) {
		this.twiiterHandle = twiiterHandle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return String.format(" twiiterHandle:%s,email:%s,birthDate:%s", twiiterHandle, email, birthDate.toString());
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
