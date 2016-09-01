package bjh_20160829_reservation.dao;

import java.util.ArrayList;

import bjh_20160829_reservation.domain.Reservation;
import bjh_20160829_reservation.repository.ReservationRepository;

public class ReservationDao {

	public ReservationDao() {
		
		new ReservationRepository();
	}
	
	//1. 예매 하기 메서드 
	public boolean reservateMovie(Reservation newReservation) {
		
		boolean success = false;
		
		int currentReservationNumber = ReservationRepository.getReservationNumber();
		int nextReservationNumber = currentReservationNumber + 1;
		ReservationRepository.setReservationNumber(nextReservationNumber);
		newReservation.setReservationNumber(nextReservationNumber);
		
		ArrayList<Reservation> reservations = ReservationRepository.getReservations();
		reservations.add(newReservation);
		
		success = true;
		
		return success;
	}
	
	
	//2. 예매 취소(삭제)
	public void deleteReservation(Reservation searchedReservation) {
		
		ReservationRepository.getReservations().remove(searchedReservation);
		
	}
	
	
	//3. 예매 정보 보기(selectOne) - 고객
	public Reservation selectOneReservation(int searchReservationNumber) {
		
		Reservation searchedReservation = null;
		
		for(int i = 0; i < ReservationRepository.getReservations().size(); i++) {
			if(searchReservationNumber == ReservationRepository.getReservations().get(i).getReservationNumber()) {
				searchedReservation = ReservationRepository.getReservations().get(i);
				break;
			}
		}
		return searchedReservation;
	}
	
	
	//4. 전체 예매 현황보기(selectAll) - 관리자
	public ArrayList<Reservation> selectAllReservation() {
		
		ArrayList<Reservation> allReservation = null;
		allReservation = ReservationRepository.getReservations();
		
		return allReservation;
	}
	
	//5. 예매영화 이미 예매했는지 여부 판별(존재한다면 경고메시지 출력 후 예매)
	public boolean checkReservation(Reservation newReservation) {
		
		boolean success = false;
		
		for(int i = 0; i < ReservationRepository.getReservations().size(); i++) {
			if(newReservation.getMovieNumber() == 
					ReservationRepository.getReservations().get(i).getMovieNumber()) {
				ReservationRepository.getReservations().get(i).setReservationCount(newReservation.getReservationCount());
//				int number = i;
				success = true;
				break;
			}
		}
//		return number;
		return success;
	}

//	public int continueReservation() {
//		ReservationRepository.getReservations().get(i).setReservationCount(newReservation.getReservationCount());
//		return 0;
//	}
	
}
