package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * ScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class TicTacToeScoreCalculatorTest {
    private TicTacToeScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();

//
//    /**
//     * calcScoreメソッドをテストするためのメソッド
//     */
//    @Test
//    public void calcScore() {
//        this.helper(Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 90);
//        this.helper(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, -90);
//        this.helper(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, 0);
//        this.helper(Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 10);
//        this.helper(Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, -10);
//        this.helper(Moves.NO_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, 0);
//        this.helper(Moves.NO_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, -20);
//        this.helper(Moves.NO_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 20);
//        this.helper(Moves.NO_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 20);
//
//    }
//
//
//    /**
//     * calcLineScoreメソッドをテストするためのメソッド
//     */
//    @Test
//    public void calcLineScore() {
//        this.helper(Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 90);
//        this.helper(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, -90);
//        this.helper(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, 0);
//        this.helper(Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 10);
//        this.helper(Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, -10);
//        this.helper(Moves.NO_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, 0);
//        this.helper(Moves.NO_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, -20);
//        this.helper(Moves.NO_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 20);
//
//    }
//
//    /**
//     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
//     *
//     * @param data1    テストで使用するMOVES型のデータ
//     * @param data2    テストで使用するMOVES型のデータ
//     * @param data3    テストで使用するMOVES型のデータ
//     * @param expected 期待する値
//     */
//    private void helper(Moves data1, Moves data2, Moves data3, int expected) {
//        assertThat(ticTacToeScoreCalculator.calcLineScore(data1, data2, data3), is(expected));
//    }

}