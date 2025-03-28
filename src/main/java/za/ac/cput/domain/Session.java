package za.ac.cput.domain;
/*Session.java
Session model class
Author: Hope Ringane(221174109)
Date 28 March 2.25
 */
public class Session {
    private final String sessionID;
    private final String bookingID;
    private final String tutorID;
    private final Student student;
    private final String sessionStart;
    private final String sessionEnd;
    private final String sessionStatus;
    private final String location;
    private final Subject sessionSubject;

    private Session(Builder builder) {
        this.sessionID = builder.sessionID;
        this.bookingID = builder.bookingID;
        this.tutorID = builder.tutorID;
        this.student = builder.student;
        this.sessionStart = builder.sessionStart;
        this.sessionEnd = builder.sessionEnd;
        this.sessionStatus = builder.sessionStatus;
        this.location = builder.location;
        this.sessionSubject = builder.sessionSubject;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getTutorID() {
        return tutorID;
    }

    public Student getStudent() {
        return student;
    }

    public String getSessionStart() {
        return sessionStart;
    }

    public String getSessionEnd() {
        return sessionEnd;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public String getLocation() {
        return location;
    }

    public Subject getSessionSubject() {
        return sessionSubject;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionID='" + sessionID + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", tutorID='" + tutorID + '\'' +
                ", student=" + student +
                ", sessionStart='" + sessionStart + '\'' +
                ", sessionEnd='" + sessionEnd + '\'' +
                ", sessionStatus='" + sessionStatus + '\'' +
                ", location='" + location + '\'' +
                ", sessionSubject=" + sessionSubject +
                '}';
    }

    public static class Builder {
        private String sessionID;
        private String bookingID;
        private String tutorID;
        private Student student;
        private String sessionStart;
        private String sessionEnd;
        private String sessionStatus;
        private String location;
        private Subject sessionSubject;

        public Builder sessionID(String sessionID) {
            this.sessionID = sessionID;
            return this;
        }

        public Builder bookingID(String bookingID) {
            this.bookingID = bookingID;
            return this;
        }

        public Builder tutorID(String tutorID) {
            this.tutorID = tutorID;
            return this;
        }

        public Builder student(Student student) {
            this.student = student;
            return this;
        }

        public Builder sessionStart(String sessionStart) {
            this.sessionStart = sessionStart;
            return this;
        }

        public Builder sessionEnd(String sessionEnd) {
            this.sessionEnd = sessionEnd;
            return this;
        }

        public Builder sessionStatus(String sessionStatus) {
            this.sessionStatus = sessionStatus;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder sessionSubject(Subject sessionSubject) {
            this.sessionSubject = sessionSubject;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }
}
