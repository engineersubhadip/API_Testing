package POJO_Exercise_3;

public class BookingResponse {

	private Booking booking;
	private int bookingid;

	private BookingResponse() {
	};

	public BookingResponse(Booking booking, int bookingid) {
		setBooking(booking);
		setBookingid(bookingid);
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

}
