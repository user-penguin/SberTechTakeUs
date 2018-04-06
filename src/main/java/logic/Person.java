package logic;

import logic.Interval;

import java.util.ArrayList;

/**
 * Created by Егор on 31.03.2018.
 */
public class Person {
    public int id;
    public ArrayList<ArrayList<Interval>> mass_data = new ArrayList<ArrayList<Interval>>();

    public Person(int person)
    {
        id = person;
    }

    //добавление интервала
    public void addInterval(Interval inter, int date)
    {
        //если добавляем интервал по следующей дате
        if(mass_data.size() == 0 || mass_data.size() == date) {
            ArrayList<Interval> f = new ArrayList<Interval>();
            f.add(inter);
            mass_data.add(f);
        }
        //если добавляем по ранее определенной дате
        else
        {
            mass_data.get(date).add(inter);
        }
    }

    public double find(int hour, int minute)
    {
        int k = 0;
        for (int i = 0; i < mass_data.size(); i++) {
            for (int j = 0; j < mass_data.get(i).size(); j++) {
                if (inInterval(mass_data.get(i).get(j), hour, minute)) {
                    k++;
                    break;
                }
            }
        }
        double chance = (double)k / mass_data.size();
        return chance;
    }

    private static boolean inInterval(Interval inter, int hour, int minute)
    {
        if (hour < inter.hin)
            return false;
        if (hour > inter.hout)
            return false;
        if (hour == inter.hin && minute < inter.min)
            return false;
        if (hour == inter.hout && minute > inter.mout)
            return false;
        return true;
    }
}
