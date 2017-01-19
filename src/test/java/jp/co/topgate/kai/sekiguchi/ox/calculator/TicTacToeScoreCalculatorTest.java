package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;


import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * ScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class TicTacToeScoreCalculatorTest {
    private final int rowSize = 3;
    private final int columnSize = 3;
    private Board ticTacToeBoard;
    private ScoreCalculator ticTacToeScoreCalculator;

    @Before
    public void createInstances() {
        ticTacToeBoard = new Board(rowSize, columnSize);
        ticTacToeScoreCalculator = new TicTacToeScoreCalculator();
    }


    /**
     * calcScoreメソッドをテストするためのメソッド
     */
    @Test
    public void calcScore() {
        this.checkRow1(Moves.CROSS, 100050);
        this.checkRow1(Moves.CIRCLE, -100050);

        this.checkRow2(Moves.CROSS, 99950);
        this.checkRow2(Moves.CIRCLE, -99950);

        this.checkRow3(Moves.CROSS, 99850);
        this.checkRow3(Moves.CIRCLE, -99850);

        this.checkColumn1(Moves.CROSS, 99750);
        this.checkColumn1(Moves.CIRCLE, -99750);

        this.checkColumn2(Moves.CROSS, 99650);
        this.checkColumn2(Moves.CIRCLE, -99650);

        this.checkColumn3(Moves.CROSS, 99550);
        this.checkColumn3(Moves.CIRCLE, -99550);

        this.checkLeftSlanting(Moves.CROSS, 99470);
        this.checkLeftSlanting(Moves.CIRCLE, -99470);

        this.checkRightSlanting(Moves.CROSS, 99370);
        this.checkRightSlanting(Moves.CIRCLE, -99370);


    }


    /**
     * 1行目のrowをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkRow1(Moves moves, int expected) {

        for (int column = 0; column < 3; column++) {
            ticTacToeBoard.putMoves(0, column, moves);
        }

        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);

        assertThat(actual, is(expected));

        BoardInitializer.initGameBoard(ticTacToeBoard);
    }


    /**
     * 行目のrowをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkRow2(Moves moves, int expected) {
        for (int column = 0; column < 3; column++) {
            ticTacToeBoard.putMoves(1, column, moves);
        }


        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);


        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);
    }

    /**
     * 3行目のrowをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkRow3(Moves moves, int expected) {
        for (int column = 0; column < 3; column++) {
            ticTacToeBoard.putMoves(2, column, moves);
        }

        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);


        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);
    }

    /**
     * 1列目のcolumnをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkColumn1(Moves moves, int expected) {

        for (int row = 0; row < 3; row++) {
            ticTacToeBoard.putMoves(row, 0, moves);
        }

        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);

        assertThat(actual, is(expected));

        BoardInitializer.initGameBoard(ticTacToeBoard);
    }

    /**
     * 2列目のcolumnをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkColumn2(Moves moves, int expected) {
        for (int row = 0; row < 3; row++) {
            ticTacToeBoard.putMoves(row, 1, moves);
        }


        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);


        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);
    }

    /**
     * 3列目のcolumnをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkColumn3(Moves moves, int expected) {
        for (int row = 0; row < 3; row++) {
            ticTacToeBoard.putMoves(row, 2, moves);
        }

        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);


        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);
    }

    /**
     * 左斜めのラインをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkLeftSlanting(Moves moves, int expected) {
        for (int index = 0; index < 3; index++) {
            ticTacToeBoard.putMoves(index, index, moves);
        }

        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);


        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);
    }

    /**
     * 右斜めのラインをテストするためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する値
     */
    private void checkRightSlanting(Moves moves, int expected) {

        int column = 2;

        for (int row = 0; row < 3; row++) {
            ticTacToeBoard.putMoves(row, column, moves);
            column--;

        }

        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
        int actual = ticTacToeScoreCalculator.calcScore(gameBoard);


        assertThat(actual, is(expected));
        BoardInitializer.initGameBoard(ticTacToeBoard);
    }


}

