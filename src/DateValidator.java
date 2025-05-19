
public class DateValidator {

    int[] hasThirtyDays = {2, 4, 6, 9, 11};

    public boolean validateDate(String date) {
        int day = 0, month = 0, year = 0;
        try {
            String[] dates = date.split("/");
            day = Integer.parseInt(dates[0]);
            month = Integer.parseInt(dates[1]);
            year = Integer.parseInt(dates[2]);
        } catch (NumberFormatException e) {
            System.out.println("Date must have format dd/mm/yyyy");
        }
        if (!monthIsValid(month)) {
            System.out.println("Month " + month + " invalid");
            return false;
        }
        if (!dayIsValid(day, month, year)) {
            return false;
        }
        System.out.println("Date " + date + " is valid!");
        return true;
    }

    public boolean dayIsValid (int day, int month, int year) {
        if (day < 1 || day > 31) {
            System.out.println("Days must be between 1 and 31");
            return false;
        }
        if (hasThirtyDays(month) && day == 31) {
            System.out.println("Month " + month + " has less than 31 days");
            return false;
        }
        if (isFebruary(month) && !isLeapYear(year)) {
            if (day > 28) {
                System.out.println("Year " + year + " is not a leap year, February has 28 days!");
                return false;
            }
        }
        return true;
    }

    public boolean monthIsValid (int month) {
        return month >= 1 && month <= 12;
    }

    public boolean hasThirtyDays (int month) {
        for (int i = 0; i < hasThirtyDays.length; i++) {
            if (month == hasThirtyDays[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean isFebruary (int month) {
        if (month != 02) {
            return false;
        }
        return true;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else return year % 100 != 0;
    }
}
