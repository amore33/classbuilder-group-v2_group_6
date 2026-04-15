package autogradertests.GroupSixTests;

import edu.coolschool.utilities.dateutils.DateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MorelandArieannaTests {

    @Test
    @DisplayName("determines leap years correctly")
    public void testLeapYearDivision() {
        assertTrue(DateValidator.isLeapYear(2000));
        assertFalse(DateValidator.isLeapYear(1900));
        assertTrue(DateValidator.isLeapYear(2024));
        assertFalse(DateValidator.isLeapYear(2023));
    }

    @Test
    @DisplayName("determines days in month correctly")
    public void testDaysInMonth() {
        // May = 31
        assertEquals(31, DateValidator.getDaysInMonth(5, 2023));
        // April = 30
        assertEquals(30, DateValidator.getDaysInMonth(4, 2023));
    }

    @Test
    @DisplayName("determines days in February correctly")
    public void testDaysInMonthFeb() {
        // Leap year = 29
        assertEquals(29, DateValidator.getDaysInMonth(2, 2024));
        // Leap year = 28
        assertEquals(28, DateValidator.getDaysInMonth(2, 2023));
    }

    @Test
    @DisplayName("correctly identifies invalid months")
    public void testDaysInMonthInvalid() {
        // month too low
        assertThrows(IllegalArgumentException.class, () -> {
            DateValidator.getDaysInMonth(0, 2023);
        });
        // month too high
        assertThrows(IllegalArgumentException.class, () -> {
            DateValidator.getDaysInMonth(13, 2023);
        });
    }

}
