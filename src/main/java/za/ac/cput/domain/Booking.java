package za.ac.cput.domain;

import java.util.Objects;


public class Booking {
    private String bookingId;
    private String bookingDate;
    private String status;
    private String bookingSession;
    private String student;

    private Booking(Builder builder) {
    this.bookingId =builder.bookingId;
    this.bookingDate = builder.bookingDate;
    this.status = builder.status;
    this.bookingSession = builder.bookingSession;
    this.student = builder.Student;

}
public String getBookingId() {
    return bookingId;
}
public void setBookingId(String bookingId) {
    this.bookingId = bookingId;

}
public String getBookingDate() {
    return bookingDate;
}
public void setBookingDate(String bookingDate) {
    this.bookingDate = bookingDate;

}
public String getstatus() {
    return status;


}
public void setStatus(String status) {
    this.status = status;
}
public String getBookingSession() {
    return bookingSession;
}
public void setBookingSession(String bookingSession) {
    this.bookingSession = bookingSession;
}
public String getStudent() {
    return student;
}
public void setStudent(String student) {
    student = student;
}

    public static class Builder{
    private String bookingId;
    private String bookingDate;
    private String status;
    private String bookingSession;
    private String Student;

    public Builder bookingId(String bookingId){
    this.bookingId = bookingId;
    return this;
    }

    public Builder bookingDate(String bookingDate){
    this.bookingDate = bookingDate;
    return this;
    }
    public Builder status(String status){
        this.status = status;
        return this;
    }
    public Builder bookingSession(String bookingSession){
        this.bookingSession = bookingSession;
        return this;
    }
    public Builder Student(String Student){
        this.Student = Student;
        return this;

    }
    public Booking build(){
        return new Booking(this);



    }
    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Booking booking = (Booking) o;
            return bookingId.equals(booking.bookingId);
        }
        @Override
        public int hashCode() {
            return Objects.hash(bookingId);
        }

        @Override
        public String toString() {
            return "Booking{" +
                    "bookingId= " + bookingId + "\n" +
                    "BookingDate= '" + bookingDate + "\n" +
                    "BookingSession" + bookingSession +"\n" +
                    "BookingStatus" + status + "\n" +
                    "Student" + Student ;

        }
    }
}


