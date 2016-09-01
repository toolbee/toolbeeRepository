package bjh_20160829_reservation.view;

import java.util.Scanner;

import bjh_20160829_reservation.controller.Controllers;
import bjh_20160829_reservation.domain.Reservation;

public class SelectOneReservationView {

	private Scanner keyboard;

	public SelectOneReservationView() {

		keyboard = new Scanner(System.in);
	}

	public int searchReservationNumber() {

		int searchReservationNumber = 0;

		System.out.println("예매 조회 메뉴입니다.");
		System.out.print("예매 번호 : ");
		searchReservationNumber = keyboard.nextInt();

		return searchReservationNumber;

	}

	public void outputOneReservation(Reservation searchedReservation) {

		System.out.println("번호 : " + searchedReservation.getMovieNumber());
		//		System.out.println("제목: " + searchedReservation.getMovie());
		//		System.out.println("상영관 : " + searchedReservation.getMovie());
		//		System.out.println("좌석 : " + searchedReservation.getMovie());
		//		System.out.println("상영시간 : " + searchedReservation.getMovie());

		this.showMenu(searchedReservation);
	}

	public void showMenu(Reservation searchedReservation) {

		int selectedMenu = 0;

		System.out.println("[1.영화 목록으로 가기   2.예매 취소]");
		selectedMenu = keyboard.nextInt();

		if(selectedMenu == 1) {
			new AlertView().alert("영화 컨트롤러에 영화 목록을 요청");
//			Controllers.getMovieController().requestSelectAllReservation();
		} else if(selectedMenu == 2) {
			new AlertView().alert("예매 컨트롤러에 예매 취소를 요청함");
			Controllers.getReservationController().requestDeleteReservation(searchedReservation);
		} else {
			System.out.println("메뉴를 다시 선택해주세요.");
			showMenu(searchedReservation);
		}
	}
}
