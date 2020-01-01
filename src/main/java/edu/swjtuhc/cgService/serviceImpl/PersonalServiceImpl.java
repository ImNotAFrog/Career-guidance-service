package edu.swjtuhc.cgService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.cgService.mapper.PersonalMapper;
import edu.swjtuhc.cgService.model.Personal;
import edu.swjtuhc.cgService.service.PersonalService;
import edu.swjtuhc.cgService.util.IdWorker;

@Service
public class PersonalServiceImpl implements PersonalService{
	
	private PersonalMapper personalMapper;
	private IdWorker idWorker;
	
	@Autowired
	public PersonalServiceImpl(
			PersonalMapper personalMapper) {
		this.personalMapper = personalMapper;
        this.idWorker= IdWorker.getInstance();
	}
	
	@Override
	public Long getNextId() {
		return idWorker.nextId();
	}
	
	@Override
	public int createPersonal(Personal n) {
		n.setpId(getNextId());
		return personalMapper.createPersonal(n);
	}
	@Override
	public int updatePersonal(Personal n) {
//		Personal u = personalMapper.getPersonalBypId(n.getpId());
		if (n.getpId()<1) {
			return -1;
		}else {
			return personalMapper.updatePersonal(n);
		}
	}
	@Override
	public int deletePersonal(Personal n) {
		if (n.getpId()<1) {
			return -1;
		}else {
			return personalMapper.deletePersonal(n);
		}
	}
	@Override
	public List<Personal> getPersonalList(){
		return personalMapper.getPersonal();
	}
	@Override
	public List<Personal> getAllPersonalList(){
		return personalMapper.getAllPersonal();
	}
}
