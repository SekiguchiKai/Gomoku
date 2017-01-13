package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * GomokuJudgeクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/13.
 */
public class GomokuJudgeTest {

    final int row = 9;
    final int column = 9;
    Board gomokuBoard = new GomokuBoard(row, column);
    Judge gomokuJudge = new GomokuJudge();

    @Test
    public void judgeResult() {
        // row
        final int maxLength = 9;
        IntStream.range(0, maxLength).forEach(row -> IntStream.range(0, 5).forEach(column -> gomokuBoard.putMoves(row, column, Moves.CPU_MOVE)));
        assertThat(gomokuJudge.judgeResult(gomokuBoard), is(Result.LOSE));
        BoardInitializer.initGameBoard(gomokuBoard);


        // column
        IntStream.range(0, maxLength).forEach(column -> IntStream.range(0, 5).forEach(row -> gomokuBoard.putMoves(row, column, Moves.CPU_MOVE)));
        assertThat(gomokuJudge.judgeResult(gomokuBoard), is(Result.LOSE));
        BoardInitializer.initGameBoard(gomokuBoard);


        IntStream.range(0, maxLength).forEach(row -> IntStream.range(0, 5).forEach(column -> gomokuBoard.putMoves(row, column, Moves.USER_MOVE)));
        assertThat(gomokuJudge.judgeResult(gomokuBoard), is(Result.WIN));
        BoardInitializer.initGameBoard(gomokuBoard);

        // column
        IntStream.range(0, maxLength).forEach(column -> IntStream.range(0, 5).forEach(row -> gomokuBoard.putMoves(row, column, Moves.USER_MOVE)));
        assertThat(gomokuJudge.judgeResult(gomokuBoard), is(Result.WIN));
        BoardInitializer.initGameBoard(gomokuBoard);


        // 実験
        IntStream.range(0, maxLength).forEach(row -> IntStream.range(0, 5).forEach(column -> gomokuBoard.putMoves(row, column, Moves.NO_MOVE)));
        assertThat(gomokuJudge.judgeResult(gomokuBoard), is(Result.PENDING));
        BoardInitializer.initGameBoard(gomokuBoard);

        // column
        IntStream.range(0, maxLength).forEach(column -> IntStream.range(0, 5).forEach(row -> gomokuBoard.putMoves(row, column, Moves.NO_MOVE)));
        assertThat(gomokuJudge.judgeResult(gomokuBoard), is(Result.PENDING));
        BoardInitializer.initGameBoard(gomokuBoard);


    }

    private void judgeResultHelper() {

    }

    private void assertjudgeResult() {

    }


    @Test
    public void judgeWinLose() {

    }

    @Test
    public void judgeDraw() {

    }

}