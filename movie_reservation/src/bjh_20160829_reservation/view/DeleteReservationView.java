package bjh_20160829_reservation.view;

import java.util.Scanner;

import bjh_20160829_reservation.repository.ReservationRepository;

public class DeleteReservationView {

	private Scanner keyboard;

	public DeleteReservationView() {

		keyboard = new Scanner(System.in);
	}

	public void decideDeleteReservation() {

		int selectNumber = 0;

		System.out.println("[정말로 예매를 취소하시겠습니까?]");
		System.out.print("1.예      2.아니오 ");
		selectNumber = keyboard.nextInt();

			if(selectNumber == 1) { 
				System.out.println("예매가 취소되었습니다.이용해주셔서 감사합니다.");
				
				
			} else if(selectNumber == 2) {
				System.out.println("메인메뉴로 돌아갑니다.");
				//Controllers.MovieController.requsetMovieList();
			} else {
				System.out.println("메뉴를 다시 선택해주세요.");
				decideDeleteReservation();
			}
		

	}
}
