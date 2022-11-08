package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bean.FileBean;
import com.service.FileStorageServices;

@RestController
public class FileUploadController {

	@Autowired
	FileStorageServices fileStorageServices;
	
	@PostMapping(value = "/upload")
	public ResponseEntity<?> uploadfile(@RequestParam("profilePic") MultipartFile file,FileBean fileBean){
	
		
		fileBean.setProfilePic(file);
		int res = fileStorageServices.saveFile(fileBean);
		if(res>0) {
			
			return new ResponseEntity<Object>(file.getOriginalFilename()+"is uploaded", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(file.getOriginalFilename()+"is Not uploaded", HttpStatus.EXPECTATION_FAILED);
		
		
	}
}
