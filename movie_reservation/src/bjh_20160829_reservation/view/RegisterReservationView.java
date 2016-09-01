package bjh_20160829_reservation.view;

import java.util.Scanner;

import bjh_20160829_reservation.domain.Reservation;

public class RegisterReservationView {
	
	private Scanner keyboard;

	public RegisterReservationView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public Reservation inputReservation() {
		
		Reservation newReservation = null;
		int movieNumber = 0;
		int reservationCount = 1;
		
		System.out.println("[예매하실 영화의 번호를 입력해주세요.]");
		System.out.print("영화 번호 : ");
		movieNumber = keyboard.nextInt();
		System.out.println("[예매할 좌석수를 입력해주세요.]");
		System.out.print("좌석 수  : ");
		reservationCount = keyboard.nextInt();
		
		newReservation = new Reservation(movieNumber, reservationCount);
		return newReservation;
	}
}
