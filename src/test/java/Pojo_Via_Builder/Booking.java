package Pojo_Via_Builder;

import javax.management.RuntimeErrorException;

public class Booking {

	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private BookingDates bookingdates;
	private String additionalneeds;

	private Booking() {
	};

	private Booking(BookingBuilder bookingBuilder) {
		firstname = bookingBuilder.firstname;
		lastname = bookingBuilder.lastname;
		totalprice = bookingBuilder.totalprice;
		depositpaid = bookingBuilder.depositpaid;
		bookingdates = bookingBuilder.bookingdates;
		additionalneeds = bookingBuilder.additionalneeds;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public BookingDates getBookingdates() {
		return bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public static BookingBuilder getBuilder() {
		return new BookingBuilder();
	}

	static class BookingBuilder {

		private String firstname;
		private String lastname;
		private int totalprice;
		private boolean depositpaid;
		private BookingDates bookingdates;
		private String additionalneeds;

		private BookingBuilder() {
		};

		public Booking build() {
			if (this.firstname == null || this.firstname.length() == 0) {
				throw new RuntimeException("Please enter valid first name");
			}
			if (this.lastname == null || this.lastname.length() == 0) {
				throw new RuntimeException("Please enter valid last name");
			}
			if (this.totalprice < 0) {
				throw new RuntimeException("Total Price cannot be negative");
			}
			if (this.bookingdates == null) {
				throw new RuntimeException("Please create Booking Dates first");
			}
			if (this.additionalneeds == null || this.additionalneeds.length() == 0) {
				throw new RuntimeException("Additional Needs cannot be empty");
			}

			Booking booking = new Booking(this);
			return booking;
		}

		public BookingBuilder setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public BookingBuilder setLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public BookingBuilder setTotalprice(int totalprice) {
			this.totalprice = totalprice;
			return this;
		}

		public BookingBuilder setDepositpaid(boolean depositpaid) {
			this.depositpaid = depositpaid;
			return this;
		}

		public BookingBuilder setBookingdates(BookingDates bookingdates) {
			this.bookingdates = bookingdates;
			return this;
		}

		public BookingBuilder setAdditionalneeds(String additionalneeds) {
			this.additionalneeds = additionalneeds;
			return this;
		}
	}
}
