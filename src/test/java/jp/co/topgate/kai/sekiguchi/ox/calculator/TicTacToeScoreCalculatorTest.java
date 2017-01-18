package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;


import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * ScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class TicTacToeScoreCalculatorTest {

//
//    /**
//     * calcScoreメソッドをテストするためのメソッド
//     */
//    @Test
//    public void calcScore() {
//
//        this.helper(Moves.CROSS, Moves.CROSS, Moves.CROSS, 999950950);
//        this.helper(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, -999950150);
//        this.helper(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, 0);
//        this.helper(Moves.CIRCLE, Moves.CROSS, Moves.CROSS, 20);
//        this.helper(Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, -20);
//        this.helper(Moves.NO_MOVE, Moves.CIRCLE, Moves.CROSS, 10);
//        this.helper(Moves.NO_MOVE, Moves.CIRCLE, Moves.CIRCLE, -50);
//        this.helper(Moves.NO_MOVE, Moves.CROSS, Moves.CROSS, 50);
//        this.helper(Moves.NO_MOVE, Moves.CROSS, Moves.CROSS, 50);
//
//    }
//
//
//    /**
//     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
//     *
//     * @param moves1   テストで使用するMOVES型のデータ
//     * @param moves2   テストで使用するMOVES型のデータ
//     * @param moves3   テストで使用するMOVES型のデータ
//     * @param expected 期待する値
//     */
//    private void helper(Moves moves1, Moves moves2, Moves moves3, int expected) {
//
//        TicTacToeScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();
//        final int rowSize = 3;
//        final int columnSize = 3;
//        final Board ticTacToeBoard = new TicTacToeBoard(rowSize, columnSize);
//
//        Moves[] movesArray = {moves1, moves2, moves3};
//        IntStream.range(0, rowSize).forEach(i -> ticTacToeBoard.putMoves(0, i, movesArray[i]));
//
//
//        Moves[][] gameBoardState = ticTacToeBoard.getGameBoardState();
//        assertThat(ticTacToeScoreCalculator.calcScore(gameBoardState), is(expected));
//    }

}