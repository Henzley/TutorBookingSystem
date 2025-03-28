package za.ac.cput.Factory;
/*  TutorFactoryTest.java
    Tutor factory test class
    Author: Angelo Kane Smidt (230688020)
    Date: 28 March 2025
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Tutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TutorFactoryTest {
    //Test to see if the creation of a Tutor object is successful
    @Test
    void createTutor_Successful() {
        Tutor tutor = TutorFactory.createTutor("Sally", "Porche", "porches@gmail.com", "0215500012", "Diploma in ICT Applications Development");
        assertEquals("Sally", tutor.getTutorName());
        assertEquals("Porche", tutor.getTutorSurname());
        assertEquals("porches@gmail.com", tutor.getTutorEmail());
        assertEquals("0215500012", tutor.getTutorPhoneNumber());
        assertEquals("Diploma in ICT Applications Development", tutor.getQualifications());
    }

}
