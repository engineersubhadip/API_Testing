package Pojo_Via_Builder;

public class BookingResponse {

	private int bookingid;
	private Booking booking;

	private BookingResponse() {
	};

	private BookingResponse(BookingResponseBuilder builder) {
		bookingid = builder.bookingid;
		booking = builder.booking;
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

	public static BookingResponseBuilder getBuild() {
		return new BookingResponseBuilder();
	}

	static class BookingResponseBuilder {

		private int bookingid;
		private Booking booking;

		private BookingResponseBuilder() {
		};

		private BookingResponse build() {
			if (this.bookingid < 0) {
				throw new RuntimeException("Booking ID cannot be negative");
			}
			if (this.booking == null) {
				throw new RuntimeException("Booking Object needs to be created first");
			}
			BookingResponse bookingResponse = new BookingResponse(this);
			return bookingResponse;
		}

		public BookingResponseBuilder setBookingid(int bookingid) {
			this.bookingid = bookingid;
			return this;
		}

		public BookingResponseBuilder setBooking(Booking booking) {
			this.booking = booking;
			return this;
		}

	}
}
