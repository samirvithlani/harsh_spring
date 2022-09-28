package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Courses;
import com.service.CourseServices;
import com.util.ResponseManager;

@RestController
public class CourseController {

	@Autowired
	CourseServices courseServices;

	@PostMapping(value = "/course")
	public ResponseEntity<?> addCourse(@RequestBody Courses courses) {

		int res = courseServices.addCourse(courses);
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

	@GetMapping(value = "/course")
	public ResponseEntity<?> getAllCourses() {

		List<Courses> courseList = courseServices.getAllCourses();
		ResponseManager responseManager = new ResponseManager();
		if (courseList.size() > 0) {

			responseManager.setStatus(HttpStatus.OK);
			responseManager.setObject(courseList);
			responseManager.setMessage("success");
			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.OK);

		}
		responseManager.setStatus(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		responseManager.setMessage("failed");
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/course/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable("id") int id) {

		Courses course = courseServices.getCourseById(id);
		ResponseManager responseManager = new ResponseManager();
		if (course != null) {

			responseManager.setStatus(HttpStatus.OK);
			responseManager.setObject(course);
			responseManager.setMessage("success");
			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.OK);

		}
		responseManager.setStatus(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		responseManager.setMessage("failed");
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}

}
