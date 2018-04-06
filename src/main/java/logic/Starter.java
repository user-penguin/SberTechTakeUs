package logic;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Егор on 31.03.2018.
 */

public class Starter {
    public static ArrayList<AssocInterval> main(int id, double ch) throws IOException {
        Person person = new Person(id);

        IdToString idToStr = new IdToString();
        String name = idToStr.getFIO(id);
        String[] files = new String[3];
        files[0] = "C:\\excel\\15-1-18\\" + name + ".xlsx";
        files[1] = "C:\\excel\\22-1-18\\" + name + ".xlsx";
        files[2] = "C:\\excel\\29-1-18\\" + name + ".xlsx";

        Parser.parse(files, person);

        if (person.mass_data.size() == 0)
        {
            System.out.println("not correct");
        }

        ArrayList<AssocInterval> result = findIntervals(person, ch);

        return result;
    }
    private static ArrayList<AssocInterval> findIntervals(Person person, double ch)
    {
        ArrayList<AssocInterval> intervals = new ArrayList<AssocInterval>();
        double chance = 0, prevchance = 0;

        //текущий час и минута
        int hour = 8, min = 0;

        //переменные левая и правая границы времени
        int hleft = hour, mleft = min, hright = hour, mright = min;

        boolean first = true, move = false;
        while(hour < 22) {
            chance = person.find(hour, min);
            if (chance > ch - 0.05 && chance < ch + 0.05) {
                if (first) {
                    prevchance = chance;
                    first = false;
                }
                //формируем интервалы

                if (chance == prevchance) {
                    hright = hour;
                    mright = min;
                    move = false;
                }
                else {
                    if (prevchance > ch - 0.05 && prevchance < ch + 0.05) {
                        createInterval(intervals, hleft, mleft, hright, mright, prevchance);
                    }
                    prevchance = chance;
                    move = true;
                }
            }
            else
            {
                move = true;
                if (prevchance > ch - 0.05 && prevchance < ch + 0.05){
                    createInterval(intervals, hleft, mleft, hright, mright, prevchance);
                    prevchance = chance;
                }
            }

            min++;
            if (min == 60) {
                hour++;
                min = 0;
            }

            if (move)
            {
                hleft = hour;
                mleft = min;
            }

        }

        if (hleft != 22 && mleft != 0)
        {
            createInterval(intervals, hleft, mleft, 21, 59, prevchance);
        }

        return intervals;
    }

    private static void createInterval(ArrayList<AssocInterval> intervals, int hleft, int mleft, int hright, int mright, double chance)
    {
        Interval inter = new Interval(hleft, mleft, hright, mright);
        AssocInterval assInt = new AssocInterval(inter, chance);
        intervals.add(assInt);
    }
}
