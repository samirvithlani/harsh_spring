package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Courses;
import com.bean.StudentBean;
import com.service.CourseServices;
import com.service.StudentServices;
import com.util.ResponseManager;

@RestController
public class StudentController {

	@Autowired
	StudentServices studentServices;

	@Autowired
	CourseServices courseServices;

	@PostMapping(value = "/student")
	public ResponseEntity<?> addStudent(@RequestBody StudentBean studentBean) {
 
		Courses c1 = courseServices.getCourseById(1);
		Courses c2 = courseServices.getCourseById(2);
		List<Courses> getAllCourse = courseServices.getAllCourses();
		//studentBean.setCourses(getAllCourse);
		//List<Courses> courses = new ArrayList<>();
		//courses.add(c1);
		//courses.add(c2);
		
		studentBean.setCourses(getAllCourse);

		int res = studentServices.addStudent(studentBean);

		ResponseManager responseManager = new ResponseManager();
		if (res > 0) {
			responseManager.setStatus(HttpStatus.CREATED);
			responseManager.setObject(null);
			responseManager.setMessage("success");
			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.CREATED);

		}
		responseManager.setStatus(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		responseManager.setMessage("failed");
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}
}
