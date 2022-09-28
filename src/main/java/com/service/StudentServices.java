package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.StudentBean;

@Service
public interface StudentServices {

	public int addStudent(StudentBean studentBean);
	public List<StudentBean> getAllStudents();
	public StudentBean getStudentById(int id);
	
	
}
