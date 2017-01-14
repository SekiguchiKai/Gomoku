package jp.co.topgate.kai.sekiguchi.ox.minimax;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.Cell;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuBoard;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.GomokuScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.TicTacToeScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.is;

/**
 * MiniMaxクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/11.
 */
public class MiniMaxTest {

//    /**
//     * calcMinMaxメソッドをテストするためのメソッド
//     */
//    @Test
//    public void calcMinMax() {
//
//        Board ticTacToeBoard = new TicTacToeBoard(3, 3);
//        ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();
//
//        MiniMax miniMax = new MiniMax(ticTacToeScoreCalculator);
//
//
//        // 勝つ時の一手
//        ticTacToeBoard.putMoves(0, 0, Moves.CPU_MOVE);
//        ticTacToeBoard.putMoves(0, 1, Moves.CPU_MOVE);
//
//        Cell calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        int actualRow = calcResult.getCellRow();
//        int actualColumn = calcResult.getCellColumn();
//
//        assertThat(actualRow, is(0));
//        assertThat(actualColumn, is(2));
//
//
//        BoardInitializer.initGameBoard(ticTacToeBoard);
//
//        ticTacToeBoard.putMoves(0, 0, Moves.CPU_MOVE);
//        ticTacToeBoard.putMoves(1, 0, Moves.CPU_MOVE);
//
//        calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        actualRow = calcResult.getCellRow();
//        actualColumn = calcResult.getCellColumn();
//
//        assertThat(actualRow, is(2));
//        assertThat(actualColumn, is(0));
//
//
//        BoardInitializer.initGameBoard(ticTacToeBoard);
//
//
//        ticTacToeBoard.putMoves(0, 0, Moves.CPU_MOVE);
//        ticTacToeBoard.putMoves(1, 1, Moves.CPU_MOVE);
//
//        calcResult = miniMax.calcMinMax(2, ticTacToeBoard, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        actualRow = calcResult.getCellRow();
//        actualColumn = calcResult.getCellColumn();
//
//        assertThat(actualRow, is(2));
//        assertThat(actualColumn, is(2));
//
//
//        BoardInitializer.initGameBoard(ticTacToeBoard);
//
//        ///////
//
//        ScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();
//
//
//        final int row = 9;
//        final int column = 9;
//        Board gomokuGameBoard = new GomokuBoard(row, column);
//
//
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//        // 勝つ時の一手
//        int maxLength = 4;
//
//        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(0, i, Moves.CPU_MOVE));
//        calcResult = miniMax.calcMinMax(3, gomokuGameBoard, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        actualRow = calcResult.getCellRow();
//        actualColumn = calcResult.getCellColumn();
//
//        assertThat(actualRow, is(0));
//        assertThat(actualColumn, is(4));
//
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//
//        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(i, i, Moves.CPU_MOVE));
//        calcResult = miniMax.calcMinMax(3, gomokuGameBoard, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        actualRow = calcResult.getCellRow();
//        actualColumn = calcResult.getCellColumn();
//
//        assertThat(actualRow, is(4)); //
//        assertThat(actualColumn, is(4));
//
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(i, 0, Moves.CPU_MOVE));
//        calcResult = miniMax.calcMinMax(3, gomokuGameBoard, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        actualRow = calcResult.getCellRow();
//        actualColumn = calcResult.getCellColumn();
//
//        assertThat(actualRow, is(0));
//        assertThat(actualColumn, is(1)); //
//
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//
//    }


//    /**
//     * calcMinMaxメソッドをテストするためのメソッド
//     */
//    @Test
//    public void calcMinMax() {
//        this.CalcMinMaxTicTacToeTest(Moves.CPU_MOVE);
////        this.CalcMinMaxTicTacToeTest(Moves.USER_MOVE);
//
//
//        this.CalcMinMaxGomokuTest(Moves.CPU_MOVE);
////        this.CalcMinMaxGomokuTest(Moves.USER_MOVE);
//    }

//
//    /**
//     * ゲーム盤上に擬似的な状況を派生させ、AIが適切な場所に打ち手を打つか確認するメソッド
//     *
//     * @param moves プレーヤーの打ち手
//     */
//    private void CalcMinMaxTicTacToeTest(Moves moves) {
//
//        ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();
//        final int row = 3;
//        final int column = 3;
//        Board ticTacToeBoard = new TicTacToeBoard(row, column);
//
//
//        // ユーザーが四隅においた際
//        List<int[]> cornerList = Arrays.asList(new int[]{0, 0}, new int[]{0, 2}, new int[]{2, 0}, new int[]{2, 2});
//
//        final int expectedRow = 1;
//        final int expectedColumn = 1;
//
//        cornerList.forEach(corner ->
//        {
//            ticTacToeBoard.putMoves(corner[0], corner[1], Moves.USER_MOVE);
//            this.assertMinMaxLogic(2, ticTacToeBoard, ticTacToeScoreCalculator, expectedRow, expectedColumn);
//            BoardInitializer.initGameBoard(ticTacToeBoard);
//        });
//
//        BoardInitializer.initGameBoard(ticTacToeBoard);
//
//        // 勝つ時の一手
//        ticTacToeBoard.putMoves(0, 0, moves);
//        ticTacToeBoard.putMoves(0, 1, moves);
//        this.assertMinMaxLogic(2, ticTacToeBoard, ticTacToeScoreCalculator, 0, 2);
//
//        BoardInitializer.initGameBoard(ticTacToeBoard);
//
//        ticTacToeBoard.putMoves(0, 0, moves);
//        ticTacToeBoard.putMoves(1, 1, moves);
//        this.assertMinMaxLogic(2, ticTacToeBoard, ticTacToeScoreCalculator, 2, 2);
//
//        BoardInitializer.initGameBoard(ticTacToeBoard);
//
//
//        ticTacToeBoard.putMoves(0, 0, moves);
//        ticTacToeBoard.putMoves(1, 0, moves);
//        this.assertMinMaxLogic(2, ticTacToeBoard, ticTacToeScoreCalculator, 2, 0);
//
//        BoardInitializer.initGameBoard(ticTacToeBoard);
//
//
//
//
//}
//
//
//    /**
//     * ゲーム盤上に擬似的な状況を派生させ、AIが適切な場所に打ち手を打つか確認するメソッド
//     *
//     * @param moves プレーヤーの打ち手
//     */
//    private void CalcMinMaxGomokuTest(Moves moves) {
//
//        ScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();
//
//
//        final int row = 9;
//        final int column = 9;
//        Board gomokuGameBoard = new GomokuBoard(row, column);
//
//
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//        // 勝つ時の一手
//        int maxLength = 4;
//
//        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(0, i, moves));
//        this.assertMinMaxLogic(3, gomokuGameBoard, gomokuScoreCalculator, 0, 4);
//
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//
//        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(i, i, moves));
//        this.assertMinMaxLogic(3, gomokuGameBoard, gomokuScoreCalculator, 4, 4);
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//        IntStream.range(0, maxLength).forEach(i -> gomokuGameBoard.putMoves(i, 0, moves));
//        this.assertMinMaxLogic(3, gomokuGameBoard, gomokuScoreCalculator, 4, 0);
//        BoardInitializer.initGameBoard(gomokuGameBoard);
//
//
//    }
//
//
//
//
//    /**
//     * doMoveメソッドが適切に実行されているかテストするためのメソッド
//     */
//    private void assertMinMaxLogic(int depth, Board board, ScoreCalculator scoreCalculator, int expectedRow, int expectedColumn) {
//        final Moves playerMove = Moves.CPU_MOVE;
//        final int alpha = Integer.MIN_VALUE;
//        final int beta = Integer.MAX_VALUE;
//
//        MiniMax minMax = new MiniMax(scoreCalculator);
//
//        Cell calcResult = minMax.calcMinMax(depth, board, playerMove, alpha, beta);
//
//        int actualRow = calcResult.getCellRow();
//        int actualColumn = calcResult.getCellColumn();
//
//        assertThat(actualRow, is(expectedRow));
//        assertThat(actualColumn, is(expectedColumn));
//
//    }

//    makeCapableMOveList


}