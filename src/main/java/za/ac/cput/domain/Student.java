package za.ac.cput.domain;

import java.util.Objects;

/**
 * Student.java
 * Student domain class
 * Author: [Cameron savage] ([230582567])
 * Date: [26/03/2025]
 */
public class Student {
    private String studentId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String studentNumber;
    private String course;

    // Private constructor for Builder
    public Student(Builder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.studentNumber = builder.studentNumber;
        this.course = builder.course;
    }



    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getStudentNumber() { return studentNumber; }
    public String getCourse() { return course; }

    // Builder Class
    public static class Builder {
        private String studentId;
        private String name;
        private String surname;
        private String email;
        private String phone;
        private String studentNumber;
        private String course;


        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.name = student.name;
            this.surname = student.surname;
            this.email = student.email;
            this.phone = student.phone;
            this.studentNumber = student.studentNumber;
            this.course = student.course;
            return this;
        }

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder studentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }


        public Builder course(String course) {
            this.course = course;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}