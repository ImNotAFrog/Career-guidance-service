package edu.swjtuhc.cgService.serviceImpl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.cgService.mapper.TeacherTimeMapper;
import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.TeacherTime;
import edu.swjtuhc.cgService.service.TeacherTimeService;
import edu.swjtuhc.cgService.service.articleService;
import edu.swjtuhc.cgService.util.IdWorker;
import edu.swjtuhc.cgService.util.JwtTokenUtil;


@Service
public class TeacherTimeServiceImpl implements TeacherTimeService {
    private TeacherTimeMapper TeacherTimeMapper;
    private IdWorker idWorker;
    @Autowired
    public TeacherTimeServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            TeacherTimeMapper TeacherTimeMapper) {
        this.TeacherTimeMapper = TeacherTimeMapper;
        this.idWorker=new IdWorker(0, 0);
    }


	@Override
	public Long getNextId() {
		// TODO Auto-generated method stub
		return idWorker.nextId();
	}


	public int createtime(TeacherTime t) {
		// TODO Auto-generated method stub
		if(t.getWeek()==null||t.getWeek().length()<1){
			return -1;
		}else {
			t.settId(getNextId());
		}	
		return TeacherTimeMapper.createTime(t);
	}

	



    
}

