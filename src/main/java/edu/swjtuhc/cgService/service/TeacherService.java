package edu.swjtuhc.cgService.service;

import java.util.List;

import edu.swjtuhc.cgService.model.Teacher;

public interface TeacherService {
	int createTeacher(Teacher n);
	int updateTeacher(Teacher n);
	int deleteTeacher(Teacher n);
	Long getNextId();
	
	public List<Teacher> getTeacherList();
	public List<Teacher> getAllTeacherList();
}
