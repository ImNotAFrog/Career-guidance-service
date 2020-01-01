package edu.swjtuhc.cgService.service;

import java.util.List;

import edu.swjtuhc.cgService.model.Reservation;

public interface ReservationService {
	int createReservation(Reservation n);
	int updateReservation(Reservation n);
	int deleteReservation(Reservation n);
	Long getNextId();
	
	public List<Reservation> getReservationList();
	public List<Reservation> getAllReservationList();
}
