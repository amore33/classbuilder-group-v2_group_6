package edu.coolschool.students;

import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;

public record StudentRecord(
        PersonInfo studentInfo,
        String studentID,
        PersonInfo fatherInfo,
        PersonInfo motherInfo,
        DateRecord enrollmentDate
) {

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int tabCount) {
        String indent = "\t".repeat(Math.max(0, tabCount));
        String indent1 = "\t".repeat(Math.max(0, tabCount + 1));
        String indent2 = "\t".repeat(Math.max(0, tabCount + 2));

        StringBuilder sb = new StringBuilder();

        sb.append(indent).append("Student ID: ").append(studentID).append("\n");
        sb.append(indent1).append("Enrollment Date: ").append(enrollmentDate.toString()).append("\n");
        sb.append(indent1).append("Student Information:\n");
        sb.append(studentInfo.toString(tabCount + 2));

        if (fatherInfo != null) {
            sb.append(indent1).append("Father Information:\n");
            sb.append(fatherInfo.toString(tabCount + 2));
        }

        if (motherInfo != null) {
            sb.append(indent1).append("Mother Information:\n");
            sb.append(motherInfo.toString(tabCount + 2));
        }

        sb.append("\n");
        return sb.toString();
    }

    public static class Builder {
        private PersonInfo studentInfo;
        private String studentID;
        private PersonInfo fatherInfo;
        private PersonInfo motherInfo;
        private DateRecord enrollmentDate;

        public Builder setStudentInfo(PersonInfo studentInfo) {
            this.studentInfo = studentInfo;
            return this;
        }

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setFatherInfo(PersonInfo fatherInfo) {
            this.fatherInfo = fatherInfo;
            return this;
        }

        public Builder setMotherInfo(PersonInfo motherInfo) {
            this.motherInfo = motherInfo;
            return this;
        }

        public Builder setEnrollmentDate(DateRecord enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
            return this;
        }

        public StudentRecord build() {
            if (studentInfo == null) throw new IllegalArgumentException("studentInfo required");
            if (studentID == null || studentID.isBlank() || studentID.length() != 9)
                throw new IllegalArgumentException("studentID invalid");
            if (enrollmentDate == null) throw new IllegalArgumentException("enrollmentDate required");

            return new StudentRecord(studentInfo, studentID, fatherInfo, motherInfo, enrollmentDate);
        }
    }
}
