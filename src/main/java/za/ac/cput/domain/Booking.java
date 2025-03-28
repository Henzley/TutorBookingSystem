package za.ac.cput.domain;

/*
 * Booking.java
 * Booking domain class
 * Author: Henzley Spogter [230013309]
 * Date: 27 March 2025
 */

public class Booking {
    private String bookingId;
    private String bookingDate;
    private String bookingTime;
    private String studentNumber;
    private String bookingPrice;
    private String bookingStatus;

    //Default constructor
    public Booking() {
    }

    //Parameterised constructor
    private Booking(BookingBuilder builder) {
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.bookingTime = builder.bookingTime;
        this.studentNumber = builder.studentNumber;
        this.bookingPrice = builder.bookingPrice;
        this.bookingStatus = builder.bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getBookingPrice() {
        return bookingPrice;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", bookingPayment='" + bookingPrice + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                '}';
    }

    // Creating the nested BookingBuilder class
    public static class BookingBuilder {
        private String bookingId;
        private String bookingDate;
        private String bookingTime;
        private String studentNumber;
        private String bookingPrice;
        private String bookingStatus;

        //default builder constructor
        public BookingBuilder() {

        }

        //parameterised builder constructor
        public BookingBuilder(String bookingId,
                              String bookingDate,
                              String bookingTime,
                              String studentNumber,
                              String bookingPayment,
                              String bookingStatus) {
            this.bookingId = bookingId;
            this.bookingDate = bookingDate;
            this.bookingTime = bookingTime;
            this.studentNumber = studentNumber;
            this.bookingPrice = bookingPayment;
            this.bookingStatus = bookingStatus;
        }

        public BookingBuilder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public BookingBuilder setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public BookingBuilder setBookingTime(String bookingTime) {
            this.bookingTime = bookingTime;
            return this;
        }

        public BookingBuilder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public BookingBuilder setBookingPrice(String bookingPayment) {
            this.bookingPrice = bookingPayment;
            return this;
        }

        public BookingBuilder setBookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        //build() method that returns a Booking object
        //calling constructor of outer class
        //and supplying an object of this class (BookingBuilder)
        //which is passed to the outer constructor to define all  the instance variables
        public Booking build() {
            return new Booking(this);
        }

    }

}
