package edu.coolschool.utilities.dateutils;

import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;

public record DateRecord(int day, int month, int year) {

    public DateRecord {
        if (!DateValidator.isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public DateRecord(int day, MonthsEnum monthEnum, int year) {
        this(day, monthEnumToNumber(monthEnum), year);
    }

    @Override
    public String toString() {
        // Default format: MM/DD/YYYY (per tests)
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public String toString(DateFormatOptionsEnum format) {
        if (format == null) {
            return toString();
        }

        return switch (format) {
            case MM_DD_YYYY -> String.format("%02d/%02d/%04d", month, day, year);
            case DD_MM_YYYY -> String.format("%02d/%02d/%04d", day, month, year);
            case YYYY_MM_DD -> String.format("%04d/%02d/%02d", year, month, day);
            case MONTH_DD_YYYY -> String.format("%s %02d, %04d", monthNumberToName(month), day, year);
        };
    }

    public static class Builder {
        private Integer day;
        private MonthsEnum month;
        private Integer year;

        public Builder setDay(int day) {
            this.day = day;
            return this;
        }

        public Builder setMonth(MonthsEnum month) {
            this.month = month;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public DateRecord build() {
            if (day == null || month == null || year == null) {
                throw new IllegalArgumentException("Missing required fields");
            }
            return new DateRecord(day, month, year);
        }
    }

    private static int monthEnumToNumber(MonthsEnum m) {
        if (m == null) throw new IllegalArgumentException("Month cannot be null");
        return switch (m) {
            case JANUARY -> 1;
            case FEBRUARY -> 2;
            case MARCH -> 3;
            case APRIL -> 4;
            case MAY -> 5;
            case JUNE -> 6;
            case JULY -> 7;
            case AUGUST -> 8;
            case SEPTEMBER -> 9;
            case OCTOBER -> 10;
            case NOVEMBER -> 11;
            case DECEMBER -> 12;
        };
    }

    private static String monthNumberToName(int monthNumber) {
        return switch (monthNumber) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> throw new IllegalArgumentException("Invalid month number: " + monthNumber);
        };
    }
}
