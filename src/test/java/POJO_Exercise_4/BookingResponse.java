package POJO_Exercise_4;

public class BookingResponse {

	private int bookingid;
	private Booking booking;

	private BookingResponse() {
	};

	private BookingResponse(int bookingid, Booking booking) {
		setBookingid(bookingid);
		setBooking(booking);
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
