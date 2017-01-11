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
//        this.helper(Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Integer.MAX_VALUE);
//        this.helper(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Integer.MIN_VALUE);
//        this.helper(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, 0);
//        this.helper(Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 20);
//        this.helper(Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, -20);
//        this.helper(Moves.NO_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, 10);
//        this.helper(Moves.NO_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, -50);
//        this.helper(Moves.NO_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 50);
//        this.helper(Moves.NO_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 50);
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