package logic;

/**
 * Created by Егор on 31.03.2018.
 */
public class Interval {
    //час входа
    public int hin;

    //минута входа
    public int min;

    //час выхода
    public int hout;

    //минута выхода
    public int mout;


    public Interval(int hourin, int minin, int hourout, int minout)
    {
        hin = hourin;
        min = minin;
        hout = hourout;
        mout = minout;
    }
}
