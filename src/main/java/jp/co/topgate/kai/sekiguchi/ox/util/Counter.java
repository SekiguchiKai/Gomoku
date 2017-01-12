package jp.co.topgate.kai.sekiguchi.ox.util;

/**
 * 打ち手の回数をカウントするためのクラス
 * Created by sekiguchikai on 2017/01/12.
 */
public class Counter {
    /**
     * カウンター
     */
    private static int count = 1;

    /**
     * カウンターの値を1つ上げる
     */
    public static void upCount() {
        count++;
    }

    /**
     * カウンターの値を返すためのメソッド
     *
     * @return カウンターの値を返す
     */
    public static int getCount() {
        return count;
    }
}
