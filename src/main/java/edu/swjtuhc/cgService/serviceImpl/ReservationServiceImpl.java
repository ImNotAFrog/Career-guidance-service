package edu.swjtuhc.cgService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.cgService.mapper.ReservationMapper;
import edu.swjtuhc.cgService.model.Reservation;
import edu.swjtuhc.cgService.service.ReservationService;
import edu.swjtuhc.cgService.util.IdWorker;

@Service
public class ReservationServiceImpl implements ReservationService{
	private ReservationMapper reservationMapper;
	private IdWorker idWorker;
	
	@Autowired
	public ReservationServiceImpl(
			ReservationMapper reservationMapper) {
		this.reservationMapper = reservationMapper;
        this.idWorker= IdWorker.getInstance();
	}
	
	@Override
	public Long getNextId() {
		return idWorker.nextId();
	}
	
	@Override
	public int createReservation(Reservation n) {
		// TODO Auto-generated method stub
		if (n.gettName().length()<1) {
			return -1;
		}else if (n.getuName().length()<1) {
			return -2;
		}else if (n.getTime()==null) {
			return -3;
		}else if (n.getProject().length()<1) {
			return -4;
		}else {
			n.setrId(getNextId());
		}
		
		return reservationMapper.createReservation(n);
	}

	@Override
	public int updateReservation(Reservation n) {
		// TODO Auto-generated method stub
		if (n.gettName().length()<1) {
			return -1;
		}else if (n.getuName().length()<1) {
			return -2;
		}else if (n.getTime()==null) {
			return -3;
		}else if (n.getProject().length()<1) {
			return -4;
		}
		else {
			return reservationMapper.updateReservation(n);
		}
	}

	@Override
	public int deleteReservation(Reservation n) {
		// TODO Auto-generated method stub
		if (n.getrId()<1) {
			return -1;
		}else {
			return reservationMapper.deleteReservation(n);
		}
	}

	@Override
	public List<Reservation> getReservationList() {
		// TODO Auto-generated method stub
		return reservationMapper.getReservation();
	}

	@Override
	public List<Reservation> getAllReservationList() {
		// TODO Auto-generated method stub
		return reservationMapper.getAllReservation();
	}
}
