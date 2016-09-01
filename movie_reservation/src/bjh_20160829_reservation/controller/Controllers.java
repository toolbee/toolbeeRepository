package bjh_20160829_reservation.controller;

public class Controllers {

	private static ReservationController reservationController;
	
	public Controllers() {
		
		reservationController = new ReservationController();
	}

	public static ReservationController getReservationController() {
		return reservationController;
	}
	
}
