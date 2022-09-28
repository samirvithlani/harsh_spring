package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bean.Courses;
import com.service.CourseRepository;
import com.service.CourseServices;

import org.springframework.stereotype.Repository;

@Repository
public class CoursesDao implements CourseServices {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public int addCourse(Courses courses) {

		int res = 0;
		try {
			courseRepository.save(courses);
			res = 1;
		} catch (Exception e) {
			res = -1;
		}

		return res;
	}

	@Override
	public Courses getCourseById(int cid) {
		// TODO Auto-generated method stub
		return courseRepository.getById(cid);
	}

	@Override
	public List<Courses> getAllCourses() {

		return courseRepository.findAll();
	}

}
