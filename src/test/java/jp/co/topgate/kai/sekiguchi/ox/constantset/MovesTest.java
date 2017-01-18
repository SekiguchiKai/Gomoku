package jp.co.topgate.kai.sekiguchi.ox.constantset;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 列挙型SIGNALをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class MovesTest {
    /**
     * getSignalメソッドをテストするためのメソッド
     */
    @Test
    public void getMoves() {
        this.helper(Moves.CIRCLE, "○");
        this.helper(Moves.CROSS, "×");
        this.helper(Moves.NO_MOVE, "|");
    }

    /**
     * getSignalメソッドをテストするためのメソッドの補助メソッド
     */
    private void helper(Moves data, String expected) {

        String actual = data.getMoves();

        assertThat(actual, is(expected));
    }

}