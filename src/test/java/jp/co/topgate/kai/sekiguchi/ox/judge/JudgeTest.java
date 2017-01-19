package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;


import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Judgeクラスをテストするためのメソッド
 * Created by sekiguchikai on 2017/01/18.
 */
public class JudgeTest {


    /**
     * Boardクラスのインスタンスを初期化するためのメソッド
     */
    public void initGameBoard(Board board) {
        IntStream.range(0, board.getRowSize()).forEach(y -> IntStream.range(0, board.getColumnSize()).forEach(x -> board.putMoves(y, x, Moves.EMPTY)));
    }


    /**
     * judgeResultメソッドをテストするためんおメソッド
     */
    @Test
    public void judgeResult() {
        this.ticTacToeJudgeResult();
        this.gomokuJudgeResult();
    }

    /**
     * ticTacToeゲームについてjudgeResultメソッドをテストするメソッド
     */
    private void ticTacToeJudgeResult() {
        final int row = 3;
        final int column = 3;
        Board ticTacToeBoard = new Board(row, column);

        this.ticTacToeIsWin(ticTacToeBoard);
        this.ticTacToeIsLose(ticTacToeBoard);
    }

    /**
     * 現在のゲーム盤において、ユーザーが勝利しているかをテストするためのメソッド
     */
    private void ticTacToeIsWin(Board ticTacToeBoard) {
        this.checkRow(ticTacToeBoard, Moves.CIRCLE, Result.WIN);
        this.checkColumn(ticTacToeBoard, Moves.CIRCLE, Result.WIN);
        this.checkLeftSlanting(ticTacToeBoard, Moves.CIRCLE, Result.WIN);
        this.checkRightSlanting(ticTacToeBoard, Moves.CIRCLE, Result.WIN);
    }

    /**
     * 現在のゲーム盤において、ユーザーが敗北しているかをテストするためのメソッド
     */
    private void ticTacToeIsLose(Board ticTacToeBoard) {
        this.checkRow(ticTacToeBoard, Moves.CROSS, Result.LOSE);
        this.checkColumn(ticTacToeBoard, Moves.CROSS, Result.LOSE);
        this.checkLeftSlanting(ticTacToeBoard, Moves.CROSS, Result.LOSE);
        this.checkRightSlanting(ticTacToeBoard, Moves.CROSS, Result.LOSE);
    }


    /**
     * rowについてした下準備をし、assertするためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     * @param moves          打ち手
     * @param expected       期待する値
     */
    private void checkRow(Board ticTacToeBoard, Moves moves, Result expected) {
        final int rowSize = ticTacToeBoard.getRowSize();
        final int columnSize = ticTacToeBoard.getColumnSize();

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ticTacToeBoard.putMoves(row, column, moves);
            }

            Judge ticTacToeJudge = this.ticTacToeCreateJudgeInstance();
            Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);

            assertThat(actual, is(expected));
            this.initGameBoard(ticTacToeBoard);
        }
    }

    /**
     * rowについて下準備をし、assertするためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     * @param moves          打ち手
     * @param expected       期待する値
     */
    private void checkColumn(Board ticTacToeBoard, Moves moves, Result expected) {
        final int rowSize = ticTacToeBoard.getRowSize();
        final int columnSize = ticTacToeBoard.getColumnSize();

        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                ticTacToeBoard.putMoves(row, column, moves);
            }

            Judge ticTacToeJudge = this.ticTacToeCreateJudgeInstance();
            Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);

            assertThat(actual, is(expected));
            this.initGameBoard(ticTacToeBoard);
        }
    }

    /**
     * 左斜めのラインについて下準備をし、assertするためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     * @param moves          打ち手
     * @param expected       期待する値
     */
    private void checkLeftSlanting(Board ticTacToeBoard, Moves moves, Result expected) {
        final int indexSize = 3;

        for (int index = 0; index < indexSize; index++) {
            ticTacToeBoard.putMoves(index, index, moves);
        }

        Judge ticTacToeJudge = this.ticTacToeCreateJudgeInstance();
        Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);

        assertThat(actual, is(expected));
        this.initGameBoard(ticTacToeBoard);

    }

    /**
     * 右斜めのラインについて下準備をし、assertするためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     * @param moves          打ち手
     * @param expected       期待する値
     */
    private void checkRightSlanting(Board ticTacToeBoard, Moves moves, Result expected) {
        final int rowSize = ticTacToeBoard.getRowSize();

        int column = 2;

        for (int row = 0; row < rowSize; row++) {
            ticTacToeBoard.putMoves(row, column, moves);
            column--;
        }

        Judge ticTacToeJudge = this.ticTacToeCreateJudgeInstance();
        Result actual = ticTacToeJudge.judgeResult(ticTacToeBoard);

        assertThat(actual, is(expected));
        this.initGameBoard(ticTacToeBoard);

    }


    /**
     * gomoku用のJudgeクラスをインスタンス化するためのメソッド
     *
     * @return Judgeクラスのインスタンス
     */
    private Judge ticTacToeCreateJudgeInstance() {
        final int rowSize = 3;
        final int columnSize = 3;
        final int judgeCriteriaSequence = 2;
        return new Judge(rowSize, columnSize, judgeCriteriaSequence);
    }


    /**
     * gomokuゲームについてjudgeResultメソッドをテストするメソッド
     */
    private void gomokuJudgeResult() {
        final int row = 9;
        final int column = 9;
        final int judgeCriteriaSequence = 5;


        Board gomokuBoard = new Board(row, column);
        Judge judge = new Judge(row, column, judgeCriteriaSequence);

        this.gomokuIsWin(gomokuBoard);
        this.gomokuIsLose(gomokuBoard);
    }


    /**
     * 現在のゲーム盤において、ユーザーが勝利しているかをテストするためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     */
    private void gomokuIsWin(Board gomokuBoard) {
        this.gomokuJudgeRow(gomokuBoard, Moves.CIRCLE, Result.WIN);
        this.gomokuJudgeColumn(gomokuBoard, Moves.CIRCLE, Result.WIN);
        this.gomokuJudgeLeftSlanting(gomokuBoard, Moves.CIRCLE, Result.WIN);
        this.gomokuJudgeRightSlanting(gomokuBoard, Moves.CIRCLE, Result.WIN);
    }

    /**
     * 現在のゲーム盤において、ユーザーが敗北しているかをテストするためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     */
    private void gomokuIsLose(Board gomokuBoard) {
        this.gomokuJudgeRow(gomokuBoard, Moves.CROSS, Result.LOSE);
        this.gomokuJudgeColumn(gomokuBoard, Moves.CROSS, Result.LOSE);
        this.gomokuJudgeLeftSlanting(gomokuBoard, Moves.CROSS, Result.LOSE);
        this.gomokuJudgeRightSlanting(gomokuBoard, Moves.CROSS, Result.LOSE);
    }

    /**
     * 現在のゲーム盤において、row(横のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     * @param moves       プレーヤーの打ち手
     * @param expected    期待する値
     */
    private void gomokuJudgeRow(Board gomokuBoard, Moves moves, Result expected) {
        int columnEndNum = 5;
        for (int columnStartNum = 0; columnStartNum < 4; columnStartNum++) {
            this.gomokuJudgeEachRow(gomokuBoard, columnStartNum, columnEndNum, moves, expected);

            columnEndNum++;
        }

    }

    /**
     * 現在のゲーム盤において、指定された各row(横のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param gomokuBoard    Boardクラスのインスタンス
     * @param columnStartNum columnの走査開始値
     * @param columnEndNum   columnの走査終了値
     * @param moves          プレーヤーの打ち手
     * @param expected       期待値
     */
    private void gomokuJudgeEachRow(Board gomokuBoard, final int columnStartNum, int columnEndNum, Moves moves, Result expected) {
        Judge judge = gomokuCreateJudgeInstance();
        final int rowSize = gomokuBoard.getRowSize();

        IntStream.range(0, rowSize).forEach(y -> IntStream.range(columnStartNum, columnEndNum).forEach(x -> gomokuBoard.putMoves(y, x, moves)));
        assertThat(judge.judgeResult(gomokuBoard), is(expected));

        this.initGameBoard(gomokuBoard);
    }


    /**
     * 現在のゲーム盤において、column(縦のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     * @param moves       プレーヤーの打ち手
     * @param expected    期待する値
     */
    private void gomokuJudgeColumn(Board gomokuBoard, Moves moves, Result expected) {
        int rowEndNum = 5;
        for (int rowStartNum = 0; rowStartNum < 4; rowStartNum++) {
            this.gomokuJudgeEachColumn(gomokuBoard, rowStartNum, rowEndNum, moves, expected);

            rowEndNum++;
        }

    }

    /**
     * 現在のゲーム盤において、指定された各column(縦のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     * @param rowStartNum rowの走査開始値
     * @param rowEndNum   rowの走査終了値
     * @param moves       プレーヤーの打ち手
     * @param expected    期待値
     */
    private void gomokuJudgeEachColumn(Board gomokuBoard, final int rowStartNum, int rowEndNum, Moves moves, Result expected) {
        Judge judge = gomokuCreateJudgeInstance();

        IntStream.range(0, rowEndNum).forEach(x -> IntStream.range(rowStartNum, rowEndNum).forEach(y -> gomokuBoard.putMoves(y, x, moves)));
        assertThat(judge.judgeResult(gomokuBoard), is(expected));

        this.initGameBoard(gomokuBoard);
    }


    /**
     * 現在のゲーム盤において、左斜めのラインについて勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     * @param moves       プレーヤーの打ち手
     * @param expected    期待する値
     */
    private void gomokuJudgeLeftSlanting(Board gomokuBoard, Moves moves, Result expected) {
        int endIndexNum = 5;

        for (int startIndexNum = 0; startIndexNum < 5; startIndexNum++) {
            this.gomokuJudgeEachLeftSlanting(gomokuBoard, moves, expected, startIndexNum, endIndexNum);

            endIndexNum++;
        }

    }

    /**
     * 現在のゲーム盤において、指定された各column(縦のライン)について勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param gomokuBoard   Boardクラスのインスタンス
     * @param startIndexNum rowとcolumnの走査開始値
     * @param endIndexNum   rowとcolumnの走査終了値
     * @param moves         プレーヤーの打ち手
     * @param expected      期待値
     */
    private void gomokuJudgeEachLeftSlanting(Board gomokuBoard, Moves moves, Result expected, int startIndexNum, int endIndexNum) {
        IntStream.range(startIndexNum, endIndexNum).forEach(i -> gomokuBoard.putMoves(i, i, moves));
        Judge judge = gomokuCreateJudgeInstance();


        assertThat(judge.judgeResult(gomokuBoard), is(expected));

        this.initGameBoard(gomokuBoard);

    }

    /**
     * 現在のゲーム盤において、左斜めのラインについて勝敗が決定しているかどうかをテストするためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     * @param moves       プレーヤーの打ち手
     * @param expected    期待する値
     */
    private void gomokuJudgeRightSlanting(Board gomokuBoard, Moves moves, Result expected) {

        int column = 8;

        // for文1回で、1つの連を表す
        for (int row = 0; row < 5; row++) {
            gomokuBoard.putMoves(row, column, moves);
            gomokuBoard.putMoves(row + 1, column - 1, moves);
            gomokuBoard.putMoves(row + 2, column - 2, moves);
            gomokuBoard.putMoves(row + 3, column - 3, moves);
            gomokuBoard.putMoves(row + 4, column - 4, moves);

            Judge judge = gomokuCreateJudgeInstance();

            Result actual = judge.judgeResult(gomokuBoard);

            assertThat(actual, is(expected));

            column--;
        }


    }

    /**
     * gomoku用のJudgeクラスをインスタンス化するためのメソッド
     *
     * @return Judgeクラスのインスタンス
     */
    private Judge gomokuCreateJudgeInstance() {
        final int rowSize = 9;
        final int columnSize = 9;
        final int judgeCriteriaSequence = 5;
        return new Judge(rowSize, columnSize, judgeCriteriaSequence);
    }


}