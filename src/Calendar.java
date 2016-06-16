import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Calendar {
    public void getCalendar(int month) {
        Year year = Year.of(LocalDate.now().getYear());
        Month m;
        if (month == 0) {
            m = LocalDate.now().getMonth();
        } else {
            m = Month.of(month);
        }
        DayOfWeek firstDayOfWeek = DayOfWeek.from(LocalDate.of(year.getValue(), m.getValue(), 1));
        System.out.println("    CALENDAR FOR " + m + " " + year);
        System.out.println(" Mon Tue Wed Thu Fri" + (char) 27 + "[34m Sat Sun " + (char) 27 + "[37m");
        for (int i = 1; i < firstDayOfWeek.getValue(); i++)
            System.out.print("    ");
        int lengthMonth = m.length(year.isLeap());
        for (int i = 1; i <= lengthMonth; i++) {
            if ((m == LocalDate.now().getMonth()) && (i == LocalDate.now().getDayOfMonth())) {
                System.out.print((char) 27 + "[31m");
                System.out.printf("%3d ", i);
                System.out.print((char) 27 + "[37m");
            } else {
                if (((i - 1 + firstDayOfWeek.getValue()) % 7 == 0) || ((i + firstDayOfWeek.getValue()) % 7 == 0))
                    System.out.print((char) 27 + "[34m");
                System.out.printf("%3d ", i);
            }
            if (((i - 1 + firstDayOfWeek.getValue()) % 7 == 0) || (i == lengthMonth)) {
                System.out.println((char) 27 + "[37m");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Calendar c = new Calendar();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of the month ");
        String tmp = reader.readLine();
        if (tmp.isEmpty()) {
            c.getCalendar(0);
        } else
            c.getCalendar(Integer.parseInt(tmp));
    }
}
