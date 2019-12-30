package edu.swjtuhc.cgService.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.TeacherTime;

@Mapper
public interface TeacherTimeMapper {
	Integer createTime(TeacherTime teachertime);
	Integer updateTime(TeacherTime teachertime);
	Integer deleteTime(TeacherTime teachertime);
	public List<TeacherTime> selectTime();
	public List<TeacherTime> selectName();
	}
