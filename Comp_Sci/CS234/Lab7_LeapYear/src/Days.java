
public final class Days { // FINAL CLASS CAN'T BE EXTENDED
    /* this method returns true the year is a leap year */
	
	private Days() {
	}
	
    public static boolean isLeapYear(int year) {
        //TODO: Implement the code of this method below
    	if (year % 4 == 0) return true;
    	else if (year % 4 == 0 && year % 100 != 0) return true;
    	else return false;
    }

    /* this method returns how many days in the month in such a year */
    public static int howManyDays(int month, int year) {
        //TODO: Implement the code of this method below
    	    	
    	if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12  ) return 31;
    	else if (month == 4 || month == 6 || month == 9 ) return 30;
    	else if (month == 2 && isLeapYear(year) == true) return 29;
    	else if (month == 2 && isLeapYear(year) == false) return 28;
    	else return -1;
    }
} // end of Days class