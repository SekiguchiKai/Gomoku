package jp.co.topgate.kai.sekiguchi.ox.util;

/**
 * 打ち手の回数をカウントするためのクラス
 * Created by sekiguchikai on 2017/01/12.
 */
public class Counter {
    private static int count = 1;

    public static void upCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
