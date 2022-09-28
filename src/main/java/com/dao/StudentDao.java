package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.StudentBean;
import com.service.StudentRepository;
import com.service.StudentServices;

@Repository
public class StudentDao implements StudentServices {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public int addStudent(StudentBean studentBean) {
		int res = 0;
		try {

			studentRepository.save(studentBean);
			res = 1;
		} catch (Exception e) {

			res = -1;
		}
		return res;
	}

	@Override
	public List<StudentBean> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBean getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
