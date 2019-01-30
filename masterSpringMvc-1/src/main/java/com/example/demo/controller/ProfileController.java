package com.example.demo.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.date.CNLocalDateFormatter;

/**
 * @author Hyman
 *
 */
@Controller
public class ProfileController {

	/**
	 * ��¶һ�����Խoweb
	 * 
	 * @param locale
	 * @return
	 */
	@ModelAttribute("dateFormat")
	public String localeFormat(Locale locale) {
		return CNLocalDateFormatter.getPattern(locale);
	}

	@RequestMapping("/profile")
	public String displayProfile(ProfileForm profileForm) {
		return "profile/resultPage";
	}

	/**
	 * ��������ض���
	 * 
	 * @param profileForm
	 * @return
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "profile/resultPage";
		}

		System.out.println("save ok" + profileForm);
		return "redirect:/profile";
	}
}
