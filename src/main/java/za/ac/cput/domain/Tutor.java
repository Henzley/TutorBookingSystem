package za.ac.cput.domain;




/*  Tutor.java
    Tutor domain class
    Author: Angelo Kane Smidt (230688020)
    Date: 26 March 2025
 */

//import za.ac.cput.domain.Subject;

import java.util.List;

public class Tutor {
    private String tutorId;
    private String tutorName;
    private String tutorSurname;
    private String tutorEmail;
    private String tutorPhoneNumber;
    // private List<Subject> tutorDB;
    private String qualifications;

    //default constructor
    public Tutor() {
    }

    //constructor with parameters
    public Tutor(TutorBuilder builder) {
        this.tutorId = builder.tutorId;
        this.tutorName = builder.tutorName;
        this.tutorSurname = builder.tutorSurname;
        this.tutorEmail = builder.tutorEmail;
        this.tutorPhoneNumber = builder.tutorPhoneNumber;
        this.qualifications = builder.qualifications;
    }

    //getters
    public String getTutorId() {
        return tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public String getTutorSurname() {
        return tutorSurname;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public String getTutorPhoneNumber() {
        return tutorPhoneNumber;
    }

    public String getQualifications() {
        return qualifications;
    }

    //overridden toString
    @Override
    public String toString() {
        return "Tutor{" +
                "tutorId='" + tutorId + '\'' +
                ", tutorName='" + tutorName + '\'' +
                ", tutorSurname='" + tutorSurname + '\'' +
                ", tutorEmail='" + tutorEmail + '\'' +
                ", tutorPhoneNumber='" + tutorPhoneNumber + '\'' +
                ", qualifications='" + qualifications + '\'' +
                '}';
    }

    //TutorBuilder class
    public static class TutorBuilder {
        private String tutorId;
        private String tutorName;
        private String tutorSurname;
        private String tutorEmail;
        private String tutorPhoneNumber;
        /*tutorSubject: List<Subject>*/
        private String qualifications;

        public TutorBuilder() {
            this.tutorId = tutorId;
            this.tutorName = tutorName;
            this.tutorSurname = tutorSurname;
            this.tutorEmail = tutorEmail;
            this.tutorPhoneNumber = tutorPhoneNumber;
            this.qualifications = qualifications;
        }

        public TutorBuilder tutorId(String tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public TutorBuilder tutorName(String tutorName) {
            this.tutorName = tutorName;
            return this;
        }

        public TutorBuilder tutorSurname(String tutorSurname) {
            this.tutorSurname = tutorSurname;
            return this;
        }

        public TutorBuilder tutorEmail(String tutorEmail) {
            this.tutorEmail = tutorEmail;
            return this;
        }

        public TutorBuilder tutorPhoneNumber(String tutorPhoneNumber) {
            this.tutorPhoneNumber = tutorPhoneNumber;
            return this;
        }

        public TutorBuilder qualifications(String qualifications) {
            this.qualifications = qualifications;
            return this;
        }

        public Tutor build() {
            return new Tutor(this);
        }
    }

}

