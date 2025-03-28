package za.ac.cput.domain;
/**

 * Author: Keewan Titus,230778577
 * Date:27/03/2025
 */
public class Subject {
    private String subjectId;
    private String subjectName;
    private String code;
    private String department;

    private Subject(Builder builder) {
        this.subjectId = builder.subjectId;
        this.subjectName = builder.subjectName;
        this.code =builder.code;
        this.department = builder.department;

    }
    public String getSubjectId() {
        return subjectId;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public String getCode() {
        return code;
    }
    public String getDepartment() {
        return department;
    }
    public static class Builder {
        private String subjectId;
        private String subjectName;
        private String code;
        private String department;

        public Builder setSubjectId(String subjectId) {
            this.subjectId = subjectId;
            return this;

        }
        public Builder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }
        public Builder setCode(String code) {
            this.code = code;
            return this;
        }
        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }
        public Subject build() {
            return new Subject(this);

        }
        @Override
        public String toString() {
            return "Subject " +
                    "SubjectId" + subjectId + '\n' +
                    "SubjectNAme" + subjectName + '\n' +
                    "Code" + code + '\n' +
                    "Department" + department ;

        }

    }

    }
