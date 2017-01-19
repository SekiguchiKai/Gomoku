package jp.co.topgate.kai.sekiguchi.ox.minimax;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.is;

/**
 * MiniMaxクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/11.
 */
public class MiniMaxTest {

    /**
     * Boardクラスのインスタンスを初期化するためのメソッド
     */
    public void initGameBoard(Board board) {
        final int rowSize = board.getRowSize();
        final int columnSize = board.getColumnSize();

        IntStream.range(0, rowSize).forEach(y -> IntStream.range(0, columnSize).forEach(x -> board.putMoves(y, x, Moves.EMPTY)));
    }

    /**
     * calcMinMaxメソッドをテストするためのメソッド
     */
    @Test
    public void calcMinMax() {
        final int rowSize = 3;
        final int columnSize = 3;
        final int judgeCriteriaSequence = 3;
        final int maxPoint = 30;
        final int minPoint = -30;


        Board ticTacToeBoard = new Board(3, 3);

        ScoreCalculator ticTacToeScoreCalculator = new ScoreCalculator(rowSize, columnSize, judgeCriteriaSequence, maxPoint, minPoint);

        MiniMax miniMax = new MiniMax(ticTacToeScoreCalculator);


        // 勝つ時の一手
        ticTacToeBoard.putMoves(0, 0, Moves.CROSS);
        ticTacToeBoard.putMoves(0, 1, Moves.CROSS);

        Cell calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CROSS, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int actualRow = calcResult.getCellRow();
        int actualColumn = calcResult.getCellColumn();

        assertThat(actualRow, is(0));
        assertThat(actualColumn, is(2));


        this.initGameBoard(ticTacToeBoard);

        ticTacToeBoard.putMoves(0, 0, Moves.CROSS);
        ticTacToeBoard.putMoves(1, 0, Moves.CROSS);

        calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CROSS, Integer.MIN_VALUE, Integer.MAX_VALUE);
        actualRow = calcResult.getCellRow();
        actualColumn = calcResult.getCellColumn();

        assertThat(actualRow, is(2));
        assertThat(actualColumn, is(0));


        this.initGameBoard(ticTacToeBoard);


        ticTacToeBoard.putMoves(0, 0, Moves.CROSS);
        ticTacToeBoard.putMoves(1, 1, Moves.CROSS);

        calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CROSS, Integer.MIN_VALUE, Integer.MAX_VALUE);
        actualRow = calcResult.getCellRow();
        actualColumn = calcResult.getCellColumn();

        assertThat(actualRow, is(2));
        assertThat(actualColumn, is(2));


        this.initGameBoard(ticTacToeBoard);

    }


}