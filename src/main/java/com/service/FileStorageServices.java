package com.service;

import org.springframework.stereotype.Service;

import com.bean.FileBean;

@Service
public interface FileStorageServices {

	public int saveFile(FileBean fileBean);
}
