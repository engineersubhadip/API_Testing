package Pojo_Via_Builder;

import javax.management.RuntimeErrorException;

public class BookingDates {

	private String checkin;
	private String checkout;

	private BookingDates() {
	};

	private BookingDates(BookingDatesBuilder bookingDatesBuilder) {
		checkin = bookingDatesBuilder.checkin;
		checkout = bookingDatesBuilder.checkout;
	}

	public String getCheckin() {
		return checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public static BookingDatesBuilder getBuilder() {
		return new BookingDatesBuilder();
	}

	static class BookingDatesBuilder {

		private String checkin;
		private String checkout;

		public BookingDates build() {
			if (this.checkin == null || this.checkin.length() == 0) {
				throw new RuntimeException("Please enter valid checkin date");
			}
			if (this.checkout == null || this.checkout.length() == 0) {
				throw new RuntimeException("Please enter valid checkout date");
			}
			BookingDates bookingDates = new BookingDates(this);
			return bookingDates;
		}

		public BookingDatesBuilder setCheckin(String checkin) {
			this.checkin = checkin;
			return this;
		}

		public BookingDatesBuilder setCheckout(String checkout) {
			this.checkout = checkout;
			return this;
		}

	}
}
