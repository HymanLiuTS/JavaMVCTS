package com.example.demo.controller;

import java.time.LocalDate;

public class ProfileForm {

	private String twiiterHandle;
	private String email;
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
