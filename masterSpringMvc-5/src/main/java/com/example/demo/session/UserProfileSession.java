package com.example.demo.session;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.example.demo.controller.ProfileForm;
import com.example.demo.date.PastLocalDate;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserProfileSession implements Serializable {

	private String twiiterHandle;
	private String email;
	private LocalDate birthDate;

	public void saveForm(ProfileForm form) {
		this.twiiterHandle = form.getTwiiterHandle();
		this.email = form.getEmail();
		this.birthDate = form.getBirthDate();
	}

	public ProfileForm toFrom() {
		ProfileForm profileForm = new ProfileForm();
		profileForm.setTwiiterHandle(twiiterHandle);
		profileForm.setEmail(email);
		profileForm.setBirthDate(birthDate);
		return profileForm;
	}
}
