package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * GomokuScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/10.
 */
public class ScoreCalculatorTest {
    // ticTacToe
    private final int ticTacToeRowSize = 3;
    private final int ticTacToeColumnSize = 3;
    private final int ticTacToeJudgeCriteriaSequence = 3;
    private final int ticTacToeMaxPoint = 30;
    private final int ticTacToeMinPoint = -30;
    private Board ticTacToeBoard;
    private ScoreCalculator ticTacToeScoreCalculator;


    // gomoku
    private final int gomokuRowSize = 9;
    private final int gomokuColumnSize = 9;
    private final int gomokuJudgeCriteriaSequence = 5;
    private final int gomokuMaxPoint = 50;
    private final int gomokuMinPoint = -50;
    private Board gomokuBoard;
    private ScoreCalculator gomokuScoreCalculator;

    @Before
    public void setUp() {
        this.ticTacToeBoard = new Board(ticTacToeRowSize, ticTacToeColumnSize);
        this.gomokuBoard = new Board(gomokuRowSize, gomokuColumnSize);

        this.ticTacToeScoreCalculator = new ScoreCalculator(this.ticTacToeRowSize, this.ticTacToeColumnSize, this.ticTacToeJudgeCriteriaSequence, this.ticTacToeMaxPoint, this.ticTacToeMinPoint);
        this.gomokuScoreCalculator = new ScoreCalculator(this.gomokuRowSize, this.gomokuColumnSize, this.gomokuJudgeCriteriaSequence, this.gomokuMaxPoint, this.gomokuMinPoint);
    }


    /**
     * Boardクラスのインスタンスを初期化するためのメソッド
     */
    public void initGameBoard() {
        IntStream.range(0, this.ticTacToeRowSize).forEach(y -> IntStream.range(0, this.ticTacToeColumnSize).forEach(x -> this.ticTacToeBoard.putMoves(y, x, Moves.EMPTY)));
        IntStream.range(0, this.gomokuRowSize).forEach(y -> IntStream.range(0, this.gomokuColumnSize).forEach(x -> this.gomokuBoard.putMoves(y, x, Moves.EMPTY)));
    }


    /**
     * calcScoreメソッドをテストするためのメソッド
     */
    @Test
    public void ゲーム盤上の得点を計算することが出来る() {
        this.checkRow1(Moves.CROSS, 99950);
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

        this.initGameBoard();
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

        this.initGameBoard();
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

        this.initGameBoard();
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

        this.initGameBoard();
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

        this.initGameBoard();
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

        this.initGameBoard();
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

        this.initGameBoard();
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

        this.initGameBoard();
    }


    /**
     * calcScoreメソッドをテストするためのメソッド
     */
    @Test
    public void gomokuCalcScore() {

        this.gomokuRow1Checker(Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 99720);
        this.gomokuRow1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, -99720);
        this.gomokuRow1Checker(Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, 0);
        this.gomokuRow1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, -130);
        this.gomokuRow1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, -10);
        this.gomokuRow1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, 90);
        this.gomokuRow1Checker(Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 210);


        this.gomokuRow4Checker(Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 99720);
        this.gomokuRow4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, -99720);
        this.gomokuRow4Checker(Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, 0);
        this.gomokuRow4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, -130);
        this.gomokuRow4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, -10);
        this.gomokuRow4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, 90);
        this.gomokuRow4Checker(Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 210);

    }


    /**
     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param moves1   テストで使用するMOVES型のデータ
     * @param moves2   テストで使用するMOVES型のデータ
     * @param moves3   テストで使用するMOVES型のデータ
     * @param expected 期待する値
     */
    private void gomokuRow1Checker(Moves moves1, Moves moves2, Moves moves3, Moves moves4, Moves moves5, int expected) {
        Moves[] movesArray = {moves1, moves2, moves3, moves4, moves5};

        for (int i = 0; i < movesArray.length; i++) {
            this.gomokuBoard.putMoves(1, i, movesArray[i]);
        }

        Moves[][] gameBoardState = gomokuBoard.getGameBoardState();
        assertThat(this.gomokuScoreCalculator.calcScore(gameBoardState), is(expected));

        this.initGameBoard();
    }

    /**
     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param moves1   テストで使用するMOVES型のデータ
     * @param moves2   テストで使用するMOVES型のデータ
     * @param moves3   テストで使用するMOVES型のデータ
     * @param expected 期待する値
     */
    private void gomokuRow4Checker(Moves moves1, Moves moves2, Moves moves3, Moves moves4, Moves moves5, int expected) {
        Moves[] movesArray = {moves1, moves2, moves3, moves4, moves5};
        IntStream.range(0, movesArray.length).forEach(i -> this.gomokuBoard.putMoves(1, i, movesArray[i]));


        Moves[][] gameBoardState = this.gomokuBoard.getGameBoardState();
        assertThat(this.gomokuScoreCalculator.calcScore(gameBoardState), is(expected));

        this.initGameBoard();
    }

}