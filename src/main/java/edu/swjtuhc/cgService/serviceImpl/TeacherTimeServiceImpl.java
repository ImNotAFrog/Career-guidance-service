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


	public int createTime(TeacherTime t) {
		// TODO Auto-generated method stub
		if(t.getFreeDown()==null||t.getFreeTop()==null){
			return -1;
		}else {
			t.settId(getNextId());
			return TeacherTimeMapper.createTime(t);
		}	
		
	}


	@Override
	public int updateTime(TeacherTime t) {
		// TODO Auto-generated method stub
		
			return TeacherTimeMapper.updateTime(t);
		
		
	}
	public int deleteTime(TeacherTime t) {
		// TODO Auto-generated method stub
		
			return TeacherTimeMapper.deleteTime(t);
		
		
	}


	@Override
	public List<TeacherTime> getTimeList() {
		// TODO Auto-generated method stub
		return TeacherTimeMapper.selectTime();
	}


	@Override
	public List<TeacherTime> getNameList() {
		// TODO Auto-generated method stub
		return TeacherTimeMapper.selectName();
	}
	



    
}

