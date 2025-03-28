package za.ac.cput.Factory;

import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;
//import za.ac.cput.domain.util.Helper;

/**
 * StudentFactory.java
 * Factory for Student domain
 * Author: [Cameron Savage] ([230582567])
 * Date: [26/03/2025]
 */
public class StudentFactory {
    public static Student createStudent(String name, String surname, String email,
                                        String phone, String studentNumber, String course) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) ||
                Helper.isNullOrEmpty(studentNumber)) {
            throw new IllegalArgumentException("Name, surname and student number are required");
           // System.out.println("Error: Name or Surname or Student number is empty");
        }

        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        String studentId = Helper.generateId();

        return new Student.Builder()
                .studentId(studentId)
                .name(name)
                .surname(surname)
                .email(email)
                .phone(phone)
                .studentNumber(studentNumber)
                .course(course)
                .build();
    }
}