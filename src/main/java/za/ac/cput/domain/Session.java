/*
Session.java
Session domain model class
Author: Henzley Spogter
Date: 27 March 2025
 */

package za.ac.cput.domain;

public class Session {
    private String sessionID;
    private String tutorID;
    private String studentNumber;
    private String subjectCode;
    private String sessionStart;
    private String sessionEnd;
    private String sessionStatus;
    private String sessionVenue;
    private String sessionDate;

    //Default constructor
    public Session() {
    }

    //Parameterised constructor
    private Session(SessionBuilder session) {
        this.sessionID = session.sessionID;
        this.tutorID = session.tutorID;
        this.studentNumber = session.studentNumber;
        this.subjectCode = session.subjectCode;
        this.sessionStart = session.sessionStart;
        this.sessionEnd = session.sessionEnd;
        this.sessionStatus = session.sessionStatus;
        this.sessionVenue = session.sessionVenue;
        this.sessionDate = session.sessionDate;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getTutorID() {
        return tutorID;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getSubjectCode() {
        return subjectCode;
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

    public String getSessionVenue() {
        return sessionVenue;
    }

    public String getSessionDate() {
        return sessionDate;
    }


    @Override
    public String toString() {
        return "Session{" +
                "sessionID='" + sessionID + '\'' +
                ", tutorID='" + tutorID + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", sessionStart='" + sessionStart + '\'' +
                ", sessionEnd='" + sessionEnd + '\'' +
                ", sessionStatus='" + sessionStatus + '\'' +
                ", sessionVenue='" + sessionVenue + '\'' +
                ", sessionDate='" + sessionDate + '\'' +
                '}';
    }

    //Create nested Builder class
    public static class SessionBuilder {
        private String sessionID;
        private String tutorID;
        private String studentNumber;
        private String subjectCode;
        private String sessionStart;
        private String sessionEnd;
        private String sessionStatus;
        private String sessionVenue;
        private String sessionDate;

        //Create SessionBuilder class constructor
        public SessionBuilder(String sessionID,
                              String tutorID,
                              String studentNumber,
                              String subjectCode,
                              String sessionStart,
                              String sessionEnd,
                              String sessionStatus,
                              String sessionVenue,
                              String sessionDate) {
            this.sessionID = sessionID;
            this.tutorID = tutorID;
            this.studentNumber = studentNumber;
            this.subjectCode = subjectCode;
            this.sessionStart = sessionStart;
            this.sessionEnd = sessionEnd;
            this.sessionStatus = sessionStatus;
            this.sessionVenue = sessionVenue;
            this.sessionDate = sessionDate;
        }

        //SessionBuilder set methods to set optional parameters
        public SessionBuilder setSessionID(String sessionID) {
            this.sessionID = sessionID;
            return this;
        }

        public SessionBuilder setTutorID(String tutorID) {
            this.tutorID = tutorID;
            return this;
        }

        public SessionBuilder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public SessionBuilder setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public SessionBuilder setSessionStart(String sessionStart) {
            this.sessionStart = sessionStart;
            return this;
        }

        public SessionBuilder setSessionEnd(String sessionEnd) {
            this.sessionEnd = sessionEnd;
            return this;
        }

        public SessionBuilder setSessionStatus(String sessionStatus) {
            this.sessionStatus = sessionStatus;
            return this;
        }

        public SessionBuilder setSessionVenue(String sessionVenue) {
            this.sessionVenue = sessionVenue;
            return this;
        }

        public SessionBuilder setSessionDate(String sessionDate) {
            this.sessionDate = sessionDate;
            return this;
        }

        //build() method that returns a Session object
        //calling constructor of outer class
        //and supplying an object of this class (SessionBuilder)
        //which is passed to the outer constructor to define the values of all the instance variables
        public Session build() {
            return new Session(this);
        }
    }
}
