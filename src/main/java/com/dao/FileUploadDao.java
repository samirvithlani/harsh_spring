package com.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;

import com.bean.FileBean;
import com.service.FileStorageServices;

@Repository
public class FileUploadDao implements FileStorageServices {

	// upload
	private final Path root = Paths.get("uploads");

	@Override
	public int saveFile(FileBean fileBean) {

		int res = 0;
		// url
		try {
			Files.copy(fileBean.getProfilePic().getInputStream(),
					this.root.resolve(fileBean.getProfilePic().getOriginalFilename()));
			res = 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("error while storing file");
		}
		return res;
	}

}
