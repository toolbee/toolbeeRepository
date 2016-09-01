package bjh_20160829_reservation.view;

import java.util.Scanner;

public class SelectReservationView {

	private Scanner keyboard;
	
	public SelectReservationView() {
		
		keyboard = new Scanner(System.in);
	}
	
	public int selectReservation(int selectNumber) {
	
		System.out.println("1.예매 계속  2.예매 취소");
		selectNumber = keyboard.nextInt();
		
		return selectNumber;
	}
}
