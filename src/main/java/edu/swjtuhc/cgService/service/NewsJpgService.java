package edu.swjtuhc.cgService.service;

import java.io.InputStream;
import java.util.List;

import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.NewsJpg;
import edu.swjtuhc.cgService.model.TeacherTime;

public interface NewsJpgService {
	  Long getNextId();
	  public int createJpg(NewsJpg newsjpg, InputStream fileStream);
}
