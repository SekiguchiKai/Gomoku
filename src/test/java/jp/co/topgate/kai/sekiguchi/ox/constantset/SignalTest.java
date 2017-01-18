package jp.co.topgate.kai.sekiguchi.ox.constantset;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 列挙型SIGNALをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class SignalTest {
    /**
     * getSignalメソッドをテストするためのメソッド
     */
    @Test
    public void getSignal() {
        this.helper(Signal.CIRCLE, "○");
        this.helper(Signal.CROSS, "×");
        this.helper(Signal.EMPTY, " ");
    }

    /**
     * getSignalメソッドをテストするためのメソッドの補助メソッド
     */
    private void helper(Signal data, String expected) {
        assertThat(data.getSignal(), is(expected));
    }

}