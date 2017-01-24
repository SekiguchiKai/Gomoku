package jp.co.topgate.kai.sekiguchi.ox.util;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Counterクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/12.
 */
public class CounterTest {
    /**
     * upCountメソッドをテストするためのメソッド
     */
    @Test
    public void getCountメソッドを使用する度にcountが1増える() {
        Counter.resetCount();
        IntStream.range(0, 3).forEach(i -> Counter.upCount());

        int count = Counter.getCount();
        final int expected = 3;

        assertThat(count, is(expected));
    }

    /**
     * getCountメソッドをテストするためのメソッド
     */
    @Test
    public void countの値を取得することが出来る() {
        Counter.resetCount();
        IntStream.range(0, 5).forEach(i -> Counter.upCount());

        int count = Counter.getCount();
        final int expected = 5;

        assertThat(count, is(expected));

    }

    /**
     * resetCountメソッドをテストするためのメソッド
     */
    @Test
    public void countの値を0にすることが出来る() {
        Counter.upCount();
        Counter.resetCount();

        int count = Counter.getCount();
        final int expected = 0;

        assertThat(count, is(expected));
    }

}