package edu.swjtuhc.cgService.service;

import java.util.List;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.TeacherTime;

public interface TeacherTimeService {
	  Long getNextId();
	  int createTime(TeacherTime t);
	  int updateTime(TeacherTime t);
	  int deleteTime(TeacherTime t);
	  public List<TeacherTime> getTimeList();
	  public List<TeacherTime> getNameList();
}
