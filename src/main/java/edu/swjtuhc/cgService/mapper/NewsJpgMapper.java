package edu.swjtuhc.cgService.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.NewsJpg;
import edu.swjtuhc.cgService.model.TeacherTime;

@Mapper
public interface NewsJpgMapper {
	public int createJpg(NewsJpg newsJpg);
	
	}
