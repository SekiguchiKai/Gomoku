package jp.co.topgate.kai.sekiguchi.ox.minimax;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.TicTacToeScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import org.junit.Test;

import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.is;

/**
 * MiniMaxクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/11.
 */
public class MiniMaxTest {

    /**
     * calcMinMaxメソッドをテストするためのメソッド
     */
    @Test
    public void calcMinMax() {

        Board ticTacToeBoard = new Board(3, 3);
        ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();

        MiniMax miniMax = new MiniMax(ticTacToeScoreCalculator);


        // 勝つ時の一手
        ticTacToeBoard.putMoves(0, 0, Moves.CROSS);
        ticTacToeBoard.putMoves(0, 1, Moves.CROSS);

        Cell calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CROSS, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int actualRow = calcResult.getCellRow();
        int actualColumn = calcResult.getCellColumn();

        assertThat(actualRow, is(0));
        assertThat(actualColumn, is(2));


        BoardInitializer.initGameBoard(ticTacToeBoard);

        ticTacToeBoard.putMoves(0, 0, Moves.CROSS);
        ticTacToeBoard.putMoves(1, 0, Moves.CROSS);

        calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CROSS, Integer.MIN_VALUE, Integer.MAX_VALUE);
        actualRow = calcResult.getCellRow();
        actualColumn = calcResult.getCellColumn();

        assertThat(actualRow, is(2));
        assertThat(actualColumn, is(0));


        BoardInitializer.initGameBoard(ticTacToeBoard);


        ticTacToeBoard.putMoves(0, 0, Moves.CROSS);
        ticTacToeBoard.putMoves(1, 1, Moves.CROSS);

        calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CROSS, Integer.MIN_VALUE, Integer.MAX_VALUE);
        actualRow = calcResult.getCellRow();
        actualColumn = calcResult.getCellColumn();

        assertThat(actualRow, is(2));
        assertThat(actualColumn, is(2));


        BoardInitializer.initGameBoard(ticTacToeBoard);

    }


}