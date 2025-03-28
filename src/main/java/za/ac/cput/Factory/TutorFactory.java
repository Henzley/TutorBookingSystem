package za.ac.cput.factory;
/*  TutorFactory.java
    Factory for Tutor domain
    Author: Angelo Kane Smidt (230688020)
    Date: 26 March 2025
 */

import za.ac.cput.domain.Tutor;
import za.ac.cput.util.Helper;

public class TutorFactory {
    public static Tutor createTutor(String tutorName, String tutorSurname, String tutorEmail, String tutorPhoneNumber, String qualifications) {
        if (Helper.isNullOrEmpty(tutorName) || Helper.isNullOrEmpty(tutorSurname)) {
            throw new IllegalArgumentException("Name and surname required.");
        }
        if (!Helper.isValidEmail(tutorEmail)) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        String tutorId = Helper.generateId();

        return new Tutor.TutorBuilder()
                .tutorId(tutorId)
                .tutorName(tutorName)
                .tutorSurname(tutorSurname)
                .tutorEmail(tutorEmail)
                .tutorPhoneNumber(tutorPhoneNumber)
                .qualifications(qualifications)
                .build();
    }

}

