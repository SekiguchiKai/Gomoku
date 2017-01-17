package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * TicTacToeJudgeクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/17.
 */
public class TicTacToeJudgeTest {

    final int rowSize = 3;
    final int columnSize = 3;

    Board ticTacToeBoard = new TicTacToeBoard(rowSize, columnSize);
    Judge ticTacToeJudge = new TicTacToeJudge();

    /**
     * judgeResultメソッドをテストするためのメソッド
     */
    @Test
    public void judgeResult() {
        this.checkRow(Moves.USER_MOVE, Result.WIN);
        this.checkRow(Moves.CPU_MOVE, Result.LOSE);

        this.checkColumn(Moves.USER_MOVE, Result.WIN);
        this.checkColumn(Moves.CPU_MOVE, Result.LOSE);

        this.checkLeftSlanting(Moves.USER_MOVE, Result.WIN);
        this.checkLeftSlanting(Moves.CPU_MOVE, Result.LOSE);

        this.checkRightSlanting(Moves.USER_MOVE, Result.WIN);
        this.checkRightSlanting(Moves.CPU_MOVE, Result.LOSE);
    }

    /**
     * rowについてした下準備をし、assertするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkRow(Moves moves, Result expected) {

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ticTacToeBoard.putMoves(row, column, moves);
            }
            Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);
            assertThat(actual, is(expected));
            BoardInitializer.initGameBoard(ticTacToeBoard);
        }
    }

    /**
     * rowについて下準備をし、assertするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkColumn(Moves moves, Result expected) {

        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                ticTacToeBoard.putMoves(row, column, moves);
            }
            Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);
            assertThat(actual, is(expected));
            BoardInitializer.initGameBoard(ticTacToeBoard);
        }
    }

    /**
     * 左斜めのラインについて下準備をし、assertするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkLeftSlanting(Moves moves, Result expected) {
        final int indexSize = 3;

        for (int index = 0; index < indexSize; index++) {
            ticTacToeBoard.putMoves(index, index, moves);
        }
        Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);
        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);

    }

    /**
     * 右斜めのラインについて下準備をし、assertするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkRightSlanting(Moves moves, Result expected) {

        int column = 2;

        for (int row = 0; row < rowSize; row++) {
            ticTacToeBoard.putMoves(row, column, moves);
            column--;
        }
        Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);
        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);

    }


}