package edu.swjtuhc.cgService.serviceImpl;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.cgService.mapper.TeacherMapper;
import edu.swjtuhc.cgService.model.Teacher;
import edu.swjtuhc.cgService.service.TeacherService;
import edu.swjtuhc.cgService.util.IdWorker;

@Service
public class TeacherServiceImpl implements TeacherService{
	private  TeacherMapper teacherMapper;
	private IdWorker idWorker;
	
	@Autowired
	public TeacherServiceImpl(
			TeacherMapper teacherMapper
			) {
		this.teacherMapper = teacherMapper;
		this.idWorker = IdWorker.getInstance();
	}
	
	@Override
	public Long getNextId() {
		return idWorker.nextId();
	}

	@Override
	public int createTeacher(Teacher n) {
		// TODO Auto-generated method stub
		if (n.gettName().length()<1) {
			return -1;
		}else if (n.gettMajor().length()<1) {
			return -2;
		}else if (n.gettSynopsis().length()<1) {
			return -3;
		}else if (n.gettPhone().length()<1) {
			return -4;
		}else {
			n.settCenterId(getNextId());
		}
		return teacherMapper.createTeacher(n);
	}

	@Override
	public int updateTeacher(Teacher n) {
		// TODO Auto-generated method stub
		
		if (n.gettCenterId()<1) {
			return -1;
		}else if (n.gettName().length()<1) {
			return -2;
		}else if (n.gettMajor().length()<1) {
			return -3;
		}else if (n.gettSynopsis().length()<1) {
			return -4;
		}else if (n.gettPhone().length()<1) {
			return -5;
		}
		return teacherMapper.createTeacher(n);
	}

	@Override
	public int deleteTeacher(Teacher n) {
		// TODO Auto-generated method stub
		if (n.gettCenterId()<1) {
			return -1;
		}else {
			return teacherMapper.deleteTeacher(n);
		}
		
	}

	@Override
	public List<Teacher> getTeacherList() {
		// TODO Auto-generated method stub
		return teacherMapper.getTeacher();
	}

	@Override
	public List<Teacher> getAllTeacherList() {
		// TODO Auto-generated method stub
		return teacherMapper.getAllTeacher();
	}
}
