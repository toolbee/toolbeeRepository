package bjh_20160829_reservation.domain;

public class Reservation {

	private int reservationNumber; //예매번호, 자동으로 1씩 증가
	private int movieNumber; // 영화 번호 
	private int reservationCount; // 예매 수량
//	private int theaterNumber;
//	private int seatNumber;
//	private String movieTime;
	
	public Reservation() {
		
	}
	
	public Reservation(int movieNumber, int reservationCount) {
		
		this.movieNumber = movieNumber;
		this.reservationCount = reservationCount;
//		this.theaterNumber = theaterNumber;
//		this.seatNumber = seatNumber;
//		this.movieTime = movieTime;
	
	}

	public int getReservationNumber() {
		return reservationNumber;
	}


	public void setReservationNumber(int nextReservationNumber) {
		// TODO Auto-generated method stub
		
	}

	public int getReservationCount() {
		return reservationCount;
	}

	public void setReservationCount(int reservationCount) {
		this.reservationCount = reservationCount;
	}

	public void setMovieNumber(int movieNumber) {
		this.movieNumber = movieNumber;
	}
	
	public int getMovieNumber() {
		return movieNumber;
	}
	

//	public int getTheaterNumber() {
//		return theaterNumber;
//	}
//
//	public int getSeatNumber() {
//		return seatNumber;
//	}
//
//	public String getMovieTime() {
//		return movieTime;
//	}

} 
