package edu.coolschool.utilities;

import edu.coolschool.utilities.dateutils.DateRecord;

public record PersonInfo(
        String firstName,
        String middleName,
        String lastName,
        DateRecord dateOfBirth,
        CountriesEnum countryOfResidence,
        CountriesEnum countryOfBirth
) {

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int tabCount) {
        String indent = "\t".repeat(Math.max(0, tabCount));

        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("First Name: ").append(firstName).append("\n");

        if (middleName != null && !middleName.isBlank()) {
            sb.append(indent).append("Middle Name: ").append(middleName).append("\n");
        }

        sb.append(indent).append("Last Name: ").append(lastName).append("\n");
        sb.append(indent).append("Date of Birth: ").append(dateOfBirth.toString()).append("\n");
        sb.append(indent).append("Country of Residence: ").append(countryOfResidence.toString()).append("\n");
        sb.append(indent).append("Country of Birth: ").append(countryOfBirth.toString()).append("\n");

        return sb.toString();
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private DateRecord dateOfBirth;
        private CountriesEnum countryOfResidence;
        private CountriesEnum countryOfBirth;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setDateOfBirth(DateRecord dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setCountryOfResidence(CountriesEnum countryOfResidence) {
            this.countryOfResidence = countryOfResidence;
            return this;
        }

        public Builder setCountryOfBirth(CountriesEnum countryOfBirth) {
            this.countryOfBirth = countryOfBirth;
            return this;
        }

        public PersonInfo build() {
            // Tests only require IllegalArgumentException for missing required fields.
            if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Invalid firstName");
            if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Invalid lastName");
            if (dateOfBirth == null) throw new IllegalArgumentException("Invalid dateOfBirth");
            if (countryOfResidence == null) throw new IllegalArgumentException("Invalid countryOfResidence");
            if (countryOfBirth == null) throw new IllegalArgumentException("Invalid countryOfBirth");

            return new PersonInfo(firstName, middleName, lastName, dateOfBirth, countryOfResidence, countryOfBirth);
        }
    }
}
