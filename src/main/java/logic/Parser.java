package logic;

import logic.Interval;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


/**
 * Created by Егор on 31.03.2018.
 */
public class Parser {
    public static void parse(String[] files, Person person) throws IOException {

        int k = 0;

        for (int j = 0; j < 3; j++) {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(files[j]));
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            Row row;

            for (int i = 0; i < 5; i++)
                if (rows.hasNext())
                    row = rows.next();
                else return;

            String tmp;
            int[] date = new int[3];
            int[] prevDate = new int[3];
            int[] time1 = new int[2], time2 = new int[2];

            boolean firstRec = true;

            while (rows.hasNext()) {
                row = rows.next();

                tmp = row.getCell(0).getStringCellValue();

                if (!splitToDate(tmp, date))
                    return;
                //date = splitToDate(tmp);

                if (firstRec) {
                    prevDate[0] = date[0];
                    prevDate[1] = date[1];
                    prevDate[2] = date[2];
                    firstRec = false;
                }

                tmp = row.getCell(1).getStringCellValue();
                time1 = splitToTime(tmp);
                tmp = row.getCell(3).getStringCellValue();
                time2 = splitToTime(tmp);
                Interval inter = new Interval(time1[0], time1[1], time2[0], time2[1]);
                if (!equalDates(prevDate, date)) {
                    k++;
                    prevDate[0] = date[0];
                    prevDate[1] = date[1];
                    prevDate[2] = date[2];
                }
                person.addInterval(inter, k);
            }

            wb.close();
        }
    }

    private static boolean splitToDate(String str, int[] date)
    {
        String[] s = str.split("\\.");

        for (int i = 0; i < s.length; i++)
        {
            try {
                date[i] = Integer.parseInt(s[i]);
            }catch (NumberFormatException p)
            {
                return false;
            }
        }
        return true;
        //return date;
    }

    private static int[] splitToTime(String str)
    {
        int[] time = new int[2];
        String[] s = str.split(":");

        for (int i = 0; i < s.length; i++)
        {
            time[i] = Integer.parseInt(s[i]);
        }
        return time;
    }

    private static boolean equalDates(int[] date1, int[] date2)
    {
        if (date1[2] == date2[2])
            if (date1[1] == date2[1])
                if (date1[0] == date2[0])
                    return true;
        return false;
    }
}
