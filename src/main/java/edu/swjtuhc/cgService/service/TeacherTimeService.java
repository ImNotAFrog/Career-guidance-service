package edu.swjtuhc.cgService.service;

import java.util.List;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.TeacherTime;

public interface TeacherTimeService {
	  Long getNextId();
	  int createtime(TeacherTime t);
}
