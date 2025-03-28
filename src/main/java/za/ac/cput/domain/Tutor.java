/*
Tutor.java
Tutor model class
Author: Henzley Spogter (230013309)
Date: 26 March 2025
 */
package za.ac.cput.domain;
/*  Tutor.java
    Tutor class with builder
    Author: Angelo Kane Smidt (230688020)
 */

public class Tutor {
    private String tutorID;
    private String tutorName;
    private String tutorSurname;
    private String tutorEmail;
    private long tutorPhoneNumber;
    // tutorSubject: List <Subject>
    private String qualifications;

    public Tutor(TutorBuilder tutorBuilder) {
    }

    public Tutor(String tutorID, String tutorName, String tutorSurname, String tutorEmail, long tutorPhoneNumber, String qualifications) {
        this.tutorID = tutorID;
        this.tutorName = tutorName;
        this.tutorSurname = tutorSurname;
        this.tutorEmail = tutorEmail;
        this.tutorPhoneNumber = tutorPhoneNumber;
        this.qualifications = qualifications;
    }

    public String getTutorID() {
        return tutorID;
    }

    // public void setTutorID(String tutorID) {
    //   this.tutorID = tutorID;
    //}

    public String getTutorName() {
        return tutorName;
    }

    //public void setTutorName(String tutorName) {
    //  this.tutorName = tutorName;
    //}

    public String getTutorSurname() {
        return tutorSurname;
    }

    //public void setTutorSurname(String tutorSurname) {
    //    this.tutorSurname = tutorSurname;
    //}

    public String getTutorEmail() {
        return tutorEmail;
    }

    //public void setTutorEmail(String tutorEmail) {
    //    this.tutorEmail = tutorEmail;
    //}

    public long getTutorPhoneNumber() {
        return tutorPhoneNumber;
    }

    //public void setTutorPhoneNumber(long tutorPhoneNumber) {
    //    this.tutorPhoneNumber = tutorPhoneNumber;
    //}

    public String getQualifications() {
        return qualifications;
    }

    //public void setQualifications(String qualifications) {
    //    this.qualifications = qualifications;
    //}

    @Override
    public String toString() {
        return "Tutor{" +
                "ID:'" + tutorID + '\'' +
                ", Name:'" + tutorName + '\'' +
                ", Surname:'" + tutorSurname + '\'' +
                ", Email:'" + tutorEmail + '\'' +
                ", Phone Number:" + tutorPhoneNumber +
                ", Qualifications:'" + qualifications + '\'' +
                '}';
    }

    public static class TutorBuilder {
        private String tutorID;
        private String tutorName;
        private String tutorSurname;
        private String tutorEmail;
        private long tutorPhoneNumber;
        // tutorSubject: List <Subject>
        private String qualifications = "None";

        public TutorBuilder setQualifications(String qualifications) {
            this.qualifications = qualifications;
            return this;
        }

        public Tutor build() {
            return new Tutor(this);
        }
    }
}
