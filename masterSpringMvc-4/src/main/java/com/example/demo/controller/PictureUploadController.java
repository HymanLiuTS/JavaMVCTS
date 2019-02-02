package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

@Controller
public class PictureUploadController {

	private final MessageSource messageSource;

	@Autowired
	public PictureUploadController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public static final Resource PICTURES_DIR = new FileSystemResource("pictures/");

	@RequestMapping("/upload")
	public String uploadPage(Model model) {
		model.addAttribute("submit", "提交");
		return "profile/uploadPage";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String onUpload(MultipartFile file, RedirectAttributes redirectAttrs, Model model) {
		String filename = file.getOriginalFilename();
		File tempFile;
		if (file.isEmpty() || !isImage(file)) {
			redirectAttrs.addFlashAttribute("error", "���ϴ�һ��ͼƬ�ļ�");
			return "redirect:/upload";
		}
		try {
			Resource picturePath = copyToPictures(file, filename);
			model.addAttribute("picturePath", picturePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("submit", "提交");
		return "profile/uploadPage";
	}

	private Resource copyToPictures(MultipartFile file, String filename) throws IOException, FileNotFoundException {
		File tempFile;
		tempFile = File.createTempFile("pic", getFileExtension(filename), PICTURES_DIR.getFile());
		InputStream in = file.getInputStream();
		OutputStream out = new FileOutputStream(tempFile);
		IOUtils.copy(in, out);
		return new FileSystemResource(tempFile.getAbsolutePath());
	}

	private boolean isImage(MultipartFile file) {
		return file.getContentType().startsWith("image");
	}

	private static String getFileExtension(String name) {
		return name.substring(name.lastIndexOf("."));
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(Locale locale) {
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("error", messageSource.getMessage("upload.io.exception", null, locale));
		return modelAndView;
	}

	@RequestMapping("/exception")
	public String exception() throws IOException {
		throw new IOException("IO 错误");
	}

	@RequestMapping("/uploadError")
	public ModelAndView onUploadError(HttpServletRequest request,Locale locale) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("error", messageSource.getMessage("upload.file.too.big", null, locale));
		mav.addObject("servletName", request.getAttribute(WebUtils.ERROR_SERVLET_NAME_ATTRIBUTE));
		return mav;
	}

}
