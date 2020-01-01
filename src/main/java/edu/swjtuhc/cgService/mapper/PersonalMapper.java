package edu.swjtuhc.cgService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.Personal;
@Mapper
public interface PersonalMapper {
	Personal getPersonalBypId(Long  pId);
	
	Integer createPersonal(Personal personal);	
	Integer updatePersonal(Personal personal);
	Integer deletePersonal(Personal personal);
	
	public List<Personal> getPersonal();
	public List<Personal> getAllPersonal();

}
