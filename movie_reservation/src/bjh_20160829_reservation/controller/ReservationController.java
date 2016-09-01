package bjh_20160829_reservation.controller;

import java.util.ArrayList;

import bjh_20160829_reservation.dao.ReservationDao;
import bjh_20160829_reservation.domain.Reservation;
import bjh_20160829_reservation.view.AlertView;
import bjh_20160829_reservation.view.DeleteReservationView;
import bjh_20160829_reservation.view.RegisterReservationView;
import bjh_20160829_reservation.view.SelectAllReservationView;
import bjh_20160829_reservation.view.SelectOneReservationView;
import bjh_20160829_reservation.view.SelectReservationView;

public class ReservationController {

	private ReservationDao reservationDao;
	private SelectOneReservationView selectOneReservationView;


	public ReservationController() {

		reservationDao = new ReservationDao();

	}

	//1. 영화 예매 요청 메서드
	public void requestReservateMovie(Object i) {

		//로그인 여부 판별
		boolean success = false;
		//		success = Controllers.getLoginController().requestCheckLogin();

		if(!success) {
			new AlertView().alert("로그인이 필요한 서비스입니다. 로그인을 해주세요.");
			//			Controllers.getLoginController().requestLogin();
		}

		//예매할 영화의 영화번호(고유번호)를 입력하는 화면을 통해 새로운 Reservation 생성
		RegisterReservationView registerReservationView = new RegisterReservationView();
		Reservation newReservation = registerReservationView.inputReservation();

		//이미 주문된 상품 판별 
		success = reservationDao.checkReservation(newReservation);
		if(success) {
			new AlertView().alert("이미 예매한 영화입니다. 그래도 예매하시겠습니까?");
			//			int selectNumber = 0;
			SelectReservationView selectReservationView = new SelectReservationView();

			//			if(selectNumber == 1) {
			//				selectNumber = reservationDao.continueReservation();
			//				new AlertView().alert("예매가 완료되었습니다.");
			//			} else if(selectNumber == 2) {
			//				new AlertView().alert("예매가 취소되었습니다.");
			//			}

		} else {
			//dao 메서드로 newReservation을 전달
			success = reservationDao.reservateMovie(newReservation);

			AlertView alertView = new AlertView();
			if(success) {
				alertView.alert("예매가 완료되었습니다.");
			} else {
				alertView.alert("예매를 다시 진행해주세요.");
			}
		}
		new AlertView().alert("영화 컨트롤러의 영화 목록을 요청함.");
		//		Controllers.getMovieController().requestSelectAllMovie();
	}

	//2. 예매 취소 요청 메서드
	public void requestDeleteReservation(Reservation searchedReservation) {

		//취소할 예매에 대한 취소의사를 재확인 하기 위해 DeleteReservationView로 이동
		DeleteReservationView deleteReservationView = new DeleteReservationView();
		deleteReservationView.decideDeleteReservation();

		//획득한 취소 결정을 dao 메서드에 전달하여 예매 취소 처리
		reservationDao.deleteReservation(searchedReservation);

	}


	//3. 예매 정보보기 (selectOne) 메서드
	public void requestSelectOneReservation() {

		//예매를 구분하는 값인 예매 번호를 입력
		SelectOneReservationView selectOneReservationView = new SelectOneReservationView();
		int searchReservationNumber = selectOneReservationView.searchReservationNumber();

		//획득한 예매번호를 dao 메서드에 전달하여 원하는 예매정보 획득
		Reservation searchedReservation = reservationDao.selectOneReservation(searchReservationNumber);

		//획득한 예매 정보를 화면에 출력
		if(searchedReservation == null) {
			AlertView alertView = new AlertView();
			alertView.alert("찾으시는 예매 정보가 없습니다.");
			alertView.alert("영화 컨트롤러에 영화 목록보기 요청함");
			//Controllers.getMovieControllers().requestAllMovle();
		} else {
			selectOneReservationView.outputOneReservation(searchedReservation);

		}
	}

	//4. 전체 예매 현황(목록) 보기(selectAll) - 관리자일 경우에만 실행
	public void requestSelectAllProduct() {
	//예매 목록을 dao를 통해 가져오기
	ArrayList<Reservation> allReservation = reservationDao.selectAllReservation();
	
	//가져온 제품 목록을 뷰로 전달해 표시
	SelectAllReservationView selectAllReservationView = new SelectAllReservationView(allReservation);
	selectAllReservationView.outputAllReservation();

	}


}
