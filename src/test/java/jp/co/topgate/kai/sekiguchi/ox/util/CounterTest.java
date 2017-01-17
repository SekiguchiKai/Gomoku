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
    public void upCount() {
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
    public void getCount() {
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
    public void resetCount() {
        Counter.upCount();
        Counter.resetCount();

        int count = Counter.getCount();
        final int expected = 0;

        assertThat(count, is(expected));
    }

}