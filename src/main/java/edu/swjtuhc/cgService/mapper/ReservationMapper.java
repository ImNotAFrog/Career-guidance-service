package edu.swjtuhc.cgService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.cgService.model.Reservation;

@Mapper
public interface ReservationMapper {
	Reservation getReservationByrId(Long rId);
	
	Integer createReservation(Reservation reservation);
	Integer updateReservation(Reservation reservation);
	Integer deleteReservation(Reservation reservation);
	
	public List<Reservation> getReservation();
	public List<Reservation> getAllReservation();
}
