package edu.coolschool.utilities.dateutils;

public final class DateValidator {

    private DateValidator() {
        // utility class
    }

    public static boolean isLeapYear(int year) {
        // Standard leap year rules
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static int getDaysInMonth(int monthNumber, int year) {
        // Months MUST be 1..12 (your current code is rejecting 2 and 9)
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Invalid month number: " + monthNumber);
        }

        return switch (monthNumber) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> throw new IllegalArgumentException("Invalid month number: " + monthNumber);
        };
    }

    public static boolean isValidDate(int day, int monthNumber, int year) {
        if (year <= 0) return false;
        if (monthNumber < 1 || monthNumber > 12) return false;
        if (day <= 0) return false;

        int maxDays = getDaysInMonth(monthNumber, year);
        return day <= maxDays;
    }
}
