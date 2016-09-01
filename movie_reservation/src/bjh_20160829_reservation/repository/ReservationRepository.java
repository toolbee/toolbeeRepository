package bjh_20160829_reservation.repository;

import java.util.ArrayList;

import bjh_20160829_reservation.domain.Reservation;

public class ReservationRepository {

	private static ArrayList<Reservation> reservations;
	private static int reservationNumber;
	
	public ReservationRepository() {
		
		reservations = new ArrayList<Reservation>();
		reservationNumber = 0;
		
	}

	public static ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public static void setReservations(ArrayList<Reservation> reservations) {
		ReservationRepository.reservations = reservations;
	}

	public static int getReservationNumber() {
		return reservationNumber;
	}

	public static void setReservationNumber(int reservationNumber) {
		ReservationRepository.reservationNumber = reservationNumber;
	}
	
	
		
}
