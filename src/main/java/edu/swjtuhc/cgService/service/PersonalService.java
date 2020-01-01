package edu.swjtuhc.cgService.service;

import java.util.List;

import edu.swjtuhc.cgService.model.Personal;

public interface PersonalService {
	int createPersonal(Personal n);
	int updatePersonal(Personal n);
	int deletePersonal(Personal n);
    Long getNextId(); 
    
    public List<Personal> getPersonalList();
    public List<Personal> getAllPersonalList();


}
