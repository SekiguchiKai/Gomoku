package jp.co.topgate.kai.sekiguchi.ox.minimax;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.Cell;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.GomokuScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.TicTacToeScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
        this.CalcMinMaxTicTacToeTest(Moves.CPU_MOVE);
        this.CalcMinMaxTicTacToeTest(Moves.USER_MOVE);

        this.CalcMinMaxGomokuTest(Moves.CPU_MOVE);
        this.CalcMinMaxGomokuTest(Moves.USER_MOVE);
    }


    /**
     * ゲーム盤上に擬似的な状況を派生させ、AIが適切な場所に打ち手を打つか確認するメソッド
     *
     * @param moves プレーヤーの打ち手
     */
    private void CalcMinMaxTicTacToeTest(Moves moves) {

        ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();
        final int row = 3;
        final int column = 3;
        Board ticTacToeBoard = new TicTacToeBoard(row, column);


        // ユーザーが四隅においた際
        List<int[]> cornerList = Arrays.asList(new int[]{0, 0}, new int[]{0, 2}, new int[]{2, 0}, new int[]{2, 2});

        final int expectedRow = 1;
        final int expectedColumn = 1;

        cornerList.forEach(corner ->
        {
            ticTacToeBoard.putMoves(corner[0], corner[1], Moves.USER_MOVE);
            this.assertMinMaxLogic(ticTacToeBoard, ticTacToeScoreCalculator, expectedRow, expectedColumn);
            initGameBoard(ticTacToeBoard);
        });


        // 一列
        ticTacToeBoard.putMoves(0, 0, moves);
        ticTacToeBoard.putMoves(0, 1, moves);
        this.assertMinMaxLogic(ticTacToeBoard, ticTacToeScoreCalculator, 0, 2);

        initGameBoard(ticTacToeBoard);

        ticTacToeBoard.putMoves(0, 0, moves);
        ticTacToeBoard.putMoves(1, 1, moves);
        this.assertMinMaxLogic(ticTacToeBoard, ticTacToeScoreCalculator, 2, 2);

        this.initGameBoard(ticTacToeBoard);


        ticTacToeBoard.putMoves(0, 0, moves);
        ticTacToeBoard.putMoves(1, 0, moves);
        this.assertMinMaxLogic(ticTacToeBoard, ticTacToeScoreCalculator, 2, 0);

        this.initGameBoard(ticTacToeBoard);
    }


    /**
     * ゲーム盤上に擬似的な状況を派生させ、AIが適切な場所に打ち手を打つか確認するメソッド
     *
     * @param moves プレーヤーの打ち手
     */
    private void CalcMinMaxGomokuTest(Moves moves) {

        ScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();


        final int row = 9;
        final int column = 9;
        Board gomokuGameBoard = new GomokuGameBoard(row, column);


        this.initGameBoard(gomokuGameBoard);

        // 勝つ時の一手
        int maxLength = 4;

        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(0, i, moves));
        this.assertMinMaxLogic(gomokuGameBoard, gomokuScoreCalculator, 0, 4);

        this.initGameBoard(gomokuGameBoard);


        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(i, i, moves));
        this.assertMinMaxLogic(gomokuGameBoard, gomokuScoreCalculator, 4, 4);
        this.initGameBoard(gomokuGameBoard);

        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(i, 0, moves));
        this.assertMinMaxLogic(gomokuGameBoard, gomokuScoreCalculator, 4, 0);
        this.initGameBoard(gomokuGameBoard);

    }


    /**
     * Boardクラスのインスタンスを初期化するためのメソッド
     */
    private void initGameBoard(Board board) {
        final int rowSize = board.getRowSize();
        final int columnSize = board.getColumnSize();

        IntStream.range(0, rowSize).forEach(y -> IntStream.range(0, columnSize).forEach(x -> board.putMoves(y, x, Moves.NO_MOVE)));
    }

    /**
     * doMoveメソッドが適切に実行されているかテストするためのメソッド
     */
    private void assertMinMaxLogic(Board board, ScoreCalculator scoreCalculator, int expectedRow, int expectedColumn) {
        final int depth = 2;
        final Moves playerMove = Moves.CPU_MOVE;
        final int alpha = Integer.MIN_VALUE;
        final int beta = Integer.MAX_VALUE;

        MiniMax minMax = new MiniMax(scoreCalculator);

        Cell calcResult = minMax.calcMinMax(depth, board, playerMove, alpha, beta);

        int actualRow = calcResult.getCellRow();
        int actualColumn = calcResult.getCellColumn();

        assertThat(actualRow, is(expectedRow));
        assertThat(actualColumn, is(expectedColumn));

    }


}