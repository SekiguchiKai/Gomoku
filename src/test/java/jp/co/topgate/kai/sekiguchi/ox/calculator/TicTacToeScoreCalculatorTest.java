package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import jp.co.topgate.kai.sekiguchi.ox.util.Counter;
import org.junit.Test;


import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * ScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class TicTacToeScoreCalculatorTest {

    private final int rowSize = 3;
    private final int columnSize = 3;
    private Board ticTacToeBoard = new TicTacToeBoard(rowSize, columnSize);
    ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();


    /**
     * calcScoreメソッドをテストするためのメソッド
     */
    @Test
    public void calcScore() {
        int rowNumber;


        Moves[] movesArray1 = this.helper(Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE);
        final int count = 3;

        final int cpuExpectedScore1 = 99750;
        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray1, Moves.CPU_MOVE, count, rowNum, cpuExpectedScore1));

        final int userExpectedScore1 = 100350;
        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray1, Moves.USER_MOVE, count, rowNum, userExpectedScore1));


        Moves[] movesArray2 = this.helper(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE);
        final int count2 = 3;

        final int cpuExpectedScore2 = -100350;
        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray2, Moves.CPU_MOVE, count2, rowNum, cpuExpectedScore2));

        final int userExpectedScore2 = -99750;
        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray2, Moves.USER_MOVE, count2, rowNum, userExpectedScore2));


        Moves[] movesArray3 = this.helper(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE);
        final int count3 = 0;

        final int cpuExpectedScore3 = 0;
        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray3, Moves.CPU_MOVE, count3, rowNum, cpuExpectedScore3));

        final int userExpectedScore3 = 0;
        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray3, Moves.USER_MOVE, count3, rowNum, userExpectedScore3));


        Moves[] movesArray4 = this.helper(Moves.CPU_MOVE, Moves.NO_MOVE, Moves.NO_MOVE);
        final int count4 = 1;


        final int cpuExpectedScore4 = 0;
        rowNumber = 0;
        this.checkRowScore(movesArray4, Moves.CPU_MOVE, count4, rowNumber, cpuExpectedScore4);
        rowNumber = 1;
        this.checkRowScore(movesArray4, Moves.CPU_MOVE, count4, rowNumber, cpuExpectedScore4);


//        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray3, Moves.CPU_MOVE, count3, rowNum, cpuExpectedScore3));
//
//        final int userExpectedScore3 = 0;
//        IntStream.range(0, 3).forEach(rowNum -> this.checkRowScore(movesArray3, Moves.USER_MOVE, count3, rowNum, userExpectedScore3));


    }


    /**
     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param moves1   テストで使用するMOVES型のデータ^
     * @param moves2   テストで使用するMOVES型のデータ
     * @param moves3   テストで使用するMOVES型のデータ
     * @param expected 期待する値
     */
    private Moves[] helper(Moves moves1, Moves moves2, Moves moves3) {
        return new Moves[]{moves1, moves2, moves3};
    }


    Moves[][] gameBoard;

    // 横
    private void checkRowScore(Moves[] movesArray, Moves player, int count, int rowNum, int expected) {

        IntStream.range(0, 3).forEach(column -> ticTacToeBoard.putMoves(rowNum, column, movesArray[column]));
        this.assertScore(ticTacToeBoard, player, count, expected);

    }


    private void assertScore(Board ticTacToeBoard, Moves player, int count, int expected) {
        IntStream.range(0, count).forEach(i -> Counter.upCount());
        Moves[][] gameBoard = ticTacToeBoard.getGameBoardState();
//        int score = ticTacToeScoreCalculator.calcScore(gameBoard, player);
//        assertThat(score, is(expected));
//        Counter.resetCount();
        BoardInitializer.initGameBoard(ticTacToeBoard);
    }


    // 縦
    private void checkColumnScore(Moves[] movesArray, int expected) {
        IntStream.range(0, 3).forEach(i -> ticTacToeBoard.putMoves(0, i, movesArray[i]));
    }


    // 左斜め
    private void checkLeftSlantingScore(Moves[] movesArray, int expected) {

    }

    // 右斜め
    private void checkRightSlantingScore(Moves[] movesArray, int expected) {

    }


}