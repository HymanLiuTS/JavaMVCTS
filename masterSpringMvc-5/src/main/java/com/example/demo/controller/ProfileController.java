package com.example.demo.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.date.CNLocalDateFormatter;
import com.example.demo.session.UserProfileSession;

@Controller
public class ProfileController {

	@ModelAttribute("dateFormat")
	public String localeFormat(Locale locale) {
		return CNLocalDateFormatter.getPattern(locale);
	}

	private UserProfileSession userProfileSession;

	@Autowired
	public ProfileController(UserProfileSession userProfileSession) {
		this.userProfileSession = userProfileSession;
	}

	@ModelAttribute
	public ProfileForm getProfileForm() {
		return this.userProfileSession.toFrom();
	}

	@RequestMapping("/profile")
	public String displayProfile(ProfileForm profileForm) {
		return "profile/profilePage";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "profile/profilePage";
		}

		this.userProfileSession.saveForm(profileForm);
		return "redirect:/profile";
	}
}
