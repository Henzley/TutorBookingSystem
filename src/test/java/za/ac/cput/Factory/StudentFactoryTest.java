package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StudentFactoryTest.java
 * Test for StudentFactory
 * Author: [Cameron Savage] ([230582567])
 * Date: [27/03/25]
 */


class StudentFactoryTest {


    //Test to make sure a student object is created successfully
    @Test
    void createStudent_Successful() {
        Student student = StudentFactory.createStudent("Saurez", "Jonkler", "Jonkles123@gmail.com", "0679794738", "230582567", "CNF152S");
        assertEquals("Saurez", student.getName());
        assertEquals("Jonkler", student.getSurname());
        assertEquals("Jonkles123@gmail.com", student.getEmail());
        assertEquals("0679794738", student.getPhone());
        assertEquals("230582567", student.getStudentNumber());
        assertEquals("CNF152S", student.getCourse());
    }


}