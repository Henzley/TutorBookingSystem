package za.ac.cput.domain;

public class Subject {
    private final String subjectCode;
    private final String subjectName;

    private Subject(Builder builder) {
        this.subjectCode = builder.subjectCode;
        this.subjectName = builder.subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    public static class Builder {
        private String subjectCode;
        private String subjectName;

        public Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder subjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }
}
