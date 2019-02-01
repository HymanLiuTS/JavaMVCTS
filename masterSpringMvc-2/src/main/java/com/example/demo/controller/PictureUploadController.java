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

import javax.servlet.http.HttpServletResponse;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.config.PicturesUploadProperties;

@Controller
@SessionAttributes("picturePath")
public class PictureUploadController {

	public static final Resource PICTURES_DIR = new FileSystemResource("pictures/");

	private final Resource picturesDir;
	private final Resource anonymousPicture;

	@Autowired
	public PictureUploadController(PicturesUploadProperties picturesUploadProperties) {
		picturesDir = picturesUploadProperties.getUploadPath();
		anonymousPicture = picturesUploadProperties.getAnonymousPicture();
	}

	@RequestMapping("/upload")
	public String uploadPage(Model model) {
		model.addAttribute("submit", "提交");
		return "profile/uploadPage";
	}

	/**
	 * @param file
	 * @param redirectAttrs
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String onUpload(MultipartFile file, RedirectAttributes redirectAttrs, Model model) {
		String filename = file.getOriginalFilename();
		File tempFile;
		if (file.isEmpty() || !isImage(file)) {
			redirectAttrs.addFlashAttribute("error", "请上传一个图片文件");
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
		tempFile = File.createTempFile("pic", getFileExtension(filename), picturesDir.getFile());
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

	@RequestMapping("/uploadedPicture")
	public void getUploadedPicture(HttpServletResponse response, @ModelAttribute("picturePath") Resource picturePath)
			throws IOException {
//		response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(anonymousPicture.getFilename()));
//		IOUtils.copy(anonymousPicture.getInputStream(), response.getOutputStream());
		response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(picturePath.getFilename()));
		IOUtils.copy(picturePath.getInputStream(), response.getOutputStream());
	}

	@ModelAttribute("picturePath")
	public Resource picturePath() {
		return anonymousPicture;
	}
}
