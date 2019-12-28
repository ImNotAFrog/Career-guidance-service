package edu.swjtuhc.cgService.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import edu.swjtuhc.cgService.model.TeacherTime;

@Mapper
public interface TeacherTimeMapper {
	Integer createTime(TeacherTime teachertime);	
	}
