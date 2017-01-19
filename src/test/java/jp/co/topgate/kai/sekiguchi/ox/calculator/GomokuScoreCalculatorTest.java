package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * GomokuScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/10.
 */
public class GomokuScoreCalculatorTest {


    /**
     * calcScoreメソッドをテストするためのメソッド
     */
    @Test
    public void calcScore() {

        this.row1Checker(Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 99620);
        this.row1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, -99720);
        this.row1Checker(Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, 0);
        this.row1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, -130);
        this.row1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, -10);
        this.row1Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, 90);
        this.row1Checker(Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 210);


        this.row4Checker(Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 99720);
        this.row4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, -99720);
        this.row4Checker(Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, Moves.EMPTY, 0);
        this.row4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, -130);
        this.row4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, -10);
        this.row4Checker(Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, 90);
        this.row4Checker(Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 210);

    }


    /**
     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param moves1   テストで使用するMOVES型のデータ
     * @param moves2   テストで使用するMOVES型のデータ
     * @param moves3   テストで使用するMOVES型のデータ
     * @param expected 期待する値
     */
    private void row1Checker(Moves moves1, Moves moves2, Moves moves3, Moves moves4, Moves moves5, int expected) {

        GomokuScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();
        final int rowSize = 9;
        final int columnSize = 9;
        final Board board = new Board(rowSize, columnSize);


        Moves[] movesArray = {moves1, moves2, moves3, moves4, moves5};
        // row0の場合しかやっていない
        IntStream.range(0, movesArray.length).forEach(i -> board.putMoves(1, i, movesArray[i]));


        Moves[][] gameBoardState = board.getGameBoardState();
        assertThat(gomokuScoreCalculator.calcScore(gameBoardState), is(expected));

        BoardInitializer.initGameBoard(board);
    }

    /**
     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param moves1   テストで使用するMOVES型のデータ
     * @param moves2   テストで使用するMOVES型のデータ
     * @param moves3   テストで使用するMOVES型のデータ
     * @param expected 期待する値
     */
    private void row4Checker(Moves moves1, Moves moves2, Moves moves3, Moves moves4, Moves moves5, int expected) {

        GomokuScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();
        final int rowSize = 9;
        final int columnSize = 9;
        final Board board = new Board(rowSize, columnSize);


        Moves[] movesArray = {moves1, moves2, moves3, moves4, moves5};
        // row0の場合しかやっていない
        IntStream.range(0, movesArray.length).forEach(i -> board.putMoves(1, i, movesArray[i]));


        Moves[][] gameBoardState = board.getGameBoardState();
        assertThat(gomokuScoreCalculator.calcScore(gameBoardState), is(expected));

        BoardInitializer.initGameBoard(board);
    }


}