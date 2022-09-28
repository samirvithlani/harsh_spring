package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.Courses;

@Service
public interface CourseServices {

	public int addCourse(Courses courses);

	public Courses getCourseById(int cid);

	public List<Courses> getAllCourses();
}
