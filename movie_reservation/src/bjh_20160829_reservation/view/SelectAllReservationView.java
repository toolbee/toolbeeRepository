package bjh_20160829_reservation.view;

import java.util.ArrayList;
import java.util.Scanner;

import bjh_20160829_reservation.domain.Reservation;
 
public class SelectAllReservationView {

	private ArrayList<Reservation> allReservation;
	private Scanner keyboard;


	public SelectAllReservationView(ArrayList<Reservation> allReservation) {

		this.allReservation = allReservation;
		keyboard = new Scanner(System.in);

	}

	public void outputAllReservation() {

		System.out.println("[예매 목록 모드]");
		System.out.println("예매번호\t영화제목\t상영관\t좌석\t상영시간");

		if(allReservation.size() == 0) {
			AlertView alertView = new AlertView();
			alertView.alert("예매건이 없습니다.");			
		} else {
			for(int i = 0 ; i < allReservation.size() ; i++) {
				System.out.print(allReservation.get(i).getMovieNumber() + "\t");
				System.out.print(allReservation.get(i).getMovieNumber() + "\t");
				System.out.print(allReservation.get(i).getMovieNumber() + "\t");
				System.out.println(allReservation.get(i).getMovieNumber());
			}
		}
	}

}
