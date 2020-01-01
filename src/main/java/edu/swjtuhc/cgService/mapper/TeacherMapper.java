package edu.swjtuhc.cgService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.Teacher;

@Mapper
public interface TeacherMapper {
	Teacher getTeacherBytCenterId(Long tCenterId);
	Integer createTeacher(Teacher teacher);
	Integer updateTeacher(Teacher teacher);
	Integer deleteTeacher(Teacher teacher);
	
	public List<Teacher> getTeacher();
	public List<Teacher> getAllTeacher();
}
