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

    /**
     * judgeResultメソッドをテストするためのメソッド
     */
    @Test
    public void judgeResult() {
        this.isWin();
        this.isLose();


    }


    /**
     * 現在のゲーム盤において、ユーザーが勝利しているかをテストするためのメソッド
     */
    private void isWin() {
        this.judgeRow(Moves.USER_MOVE, Result.WIN);
        this.judgeColumn(Moves.USER_MOVE, Result.WIN);
        this.judgeLeftSlanting(Moves.USER_MOVE, Result.WIN);
        this.judgeRightSlanting(Moves.USER_MOVE, Result.WIN);
    }

    /**
     * 現在のゲーム盤において、ユーザーが敗北しているかをテストするためのメソッド
     */
    private void isLose() {
        this.judgeRow(Moves.CPU_MOVE, Result.LOSE);
        this.judgeColumn(Moves.CPU_MOVE, Result.LOSE);
        this.judgeLeftSlanting(Moves.CPU_MOVE, Result.LOSE);
        this.judgeRightSlanting(Moves.CPU_MOVE, Result.LOSE);
    }

    /**
     * 現在のゲーム盤において、row(横のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param moves    プレーヤーの打ち手
     * @param expected 期待する値
     */
    private void judgeRow(Moves moves, Result expected) {
        int columnEndNum = 5;
        for (int columnStartNum = 0; columnStartNum < 4; columnStartNum++) {
            this.judgeEachRow(columnStartNum, columnEndNum, moves, expected);

            columnEndNum++;
        }

    }

    /**
     * 現在のゲーム盤において、指定された各row(横のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param columnStartNum columnの走査開始値
     * @param columnEndNum   columnの走査終了値
     * @param moves          プレーヤーの打ち手
     * @param expected       期待値
     */
    private void judgeEachRow(final int columnStartNum, int columnEndNum, Moves moves, Result expected) {
        final int rowEndNum = 9;
        IntStream.range(0, rowEndNum).forEach(y -> IntStream.range(columnStartNum, columnEndNum).forEach(x -> gomokuBoard.putMoves(y, x, moves)));
        assertThat(this.gomokuJudge.judgeResult(this.gomokuBoard), is(expected));

        BoardInitializer.initGameBoard(this.gomokuBoard);
    }


    /**
     * 現在のゲーム盤において、column(縦のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param moves    プレーヤーの打ち手
     * @param expected 期待する値
     */
    private void judgeColumn(Moves moves, Result expected) {
        int rowEndNum = 5;
        for (int rowStartNum = 0; rowStartNum < 4; rowStartNum++) {
            this.judgeEachColumn(rowStartNum, rowEndNum, moves, expected);

            rowEndNum++;
        }

    }

    /**
     * 現在のゲーム盤において、指定された各column(縦のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param rowStartNum rowの走査開始値
     * @param rowEndNum   rowの走査終了値
     * @param moves       プレーヤーの打ち手
     * @param expected    期待値
     */
    private void judgeEachColumn(final int rowStartNum, int rowEndNum, Moves moves, Result expected) {
        final int columnEndNum = 9;
        IntStream.range(0, rowEndNum).forEach(x -> IntStream.range(rowStartNum, rowEndNum).forEach(y -> gomokuBoard.putMoves(y, x, moves)));
        assertThat(this.gomokuJudge.judgeResult(this.gomokuBoard), is(expected));

        BoardInitializer.initGameBoard(this.gomokuBoard);
    }


    /**
     * 現在のゲーム盤において、左斜めのラインについて勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param moves    プレーヤーの打ち手
     * @param expected 期待する値
     */
    private void judgeLeftSlanting(Moves moves, Result expected) {
        int endIndexNum = 5;

        for (int startIndexNum = 0; startIndexNum < 5; startIndexNum++) {
            this.judgeEachLeftSlanting(moves, expected, startIndexNum, endIndexNum);

            endIndexNum++;
        }

    }

    /**
     * 現在のゲーム盤において、指定された各column(縦のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param startIndexNum rowとcolumnの走査開始値
     * @param endIndexNum   rowとcolumnの走査終了値
     * @param moves         プレーヤーの打ち手
     * @param expected      期待値
     */
    private void judgeEachLeftSlanting(Moves moves, Result expected, int startIndexNum, int endIndexNum) {
        IntStream.range(startIndexNum, endIndexNum).forEach(i -> gomokuBoard.putMoves(i, i, moves));
        assertThat(this.gomokuJudge.judgeResult(this.gomokuBoard), is(expected));

        BoardInitializer.initGameBoard(this.gomokuBoard);

    }

    /**
     * 現在のゲーム盤において、左斜めのラインについて勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param moves    プレーヤーの打ち手
     * @param expected 期待する値
     */
    private void judgeRightSlanting(Moves moves, Result expected) {

        int column = 8;

        // for文1回で、1つの連を表す
        for (int row = 0; row < 5; row++) {
            gomokuBoard.putMoves(row, column, moves);
            gomokuBoard.putMoves(row + 1, column - 1, moves);
            gomokuBoard.putMoves(row + 2, column - 2, moves);
            gomokuBoard.putMoves(row + 3, column - 3, moves);
            gomokuBoard.putMoves(row + 4, column - 4, moves);

            Result result = gomokuJudge.judgeResult(gomokuBoard);

            assertThat(result, is(expected));

            column--;
        }


    }



}