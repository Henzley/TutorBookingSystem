package za.ac.cput.domain;

public class TutorBuilder {
    private String tutorID;
    private String tutorName;
    private String tutorSurname;
    private String tutorEmail;
    private long tutorPhoneNumber;
    // tutorSubject: List <Subject>
    private String qualifications = "None";

    public TutorBuilder() {
    }

    public TutorBuilder(String tutorID, String tutorName, String tutorSurname, String tutorEmail, long tutorPhoneNumber) {
        this.tutorID = tutorID;
        this.tutorName = tutorName;
        this.tutorSurname = tutorSurname;
        this.tutorEmail = tutorEmail;
        this.tutorPhoneNumber = tutorPhoneNumber;
    }

    public TutorBuilder setQualifications(String qualifications) {
        this.qualifications = qualifications;
        return this;
    }

    public Tutor build() {
        return new Tutor(this);
    }
}

