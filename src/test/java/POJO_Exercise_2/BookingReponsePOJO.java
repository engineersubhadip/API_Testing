package POJO_Exercise_2;

public class BookingReponsePOJO {

	private int bookingid;
	private Booking booking;

	public BookingReponsePOJO() {
	};

	public BookingReponsePOJO(int bookingid, Booking booking) {
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
