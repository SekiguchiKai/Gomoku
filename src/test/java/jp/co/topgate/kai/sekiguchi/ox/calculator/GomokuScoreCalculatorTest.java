package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.BoardInitializer;
import jp.co.topgate.kai.sekiguchi.ox.util.Counter;
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

        this.row1Checker(Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 99620);
        this.row1Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, -99720);
        this.row1Checker(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, 0);
        this.row1Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, -130);
        this.row1Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, -10);
        this.row1Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 90);
        this.row1Checker(Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 210);



        this.row4Checker(Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 99720);
        this.row4Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, -99720);
        this.row4Checker(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, 0);
        this.row4Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, -130);
        this.row4Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, -10);
        this.row4Checker(Moves.USER_MOVE, Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 90);
        this.row4Checker(Moves.USER_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, Moves.CPU_MOVE, 210);

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
        final Board gomokuGameBoard = new GomokuBoard(rowSize, columnSize);


        Moves[] movesArray = {moves1, moves2, moves3, moves4, moves5};
        // row0の場合しかやっていない
        IntStream.range(0, movesArray.length).forEach(i -> gomokuGameBoard.putMoves(1, i, movesArray[i]));


        Moves[][] gameBoardState = gomokuGameBoard.getGameBoardState();
        assertThat(gomokuScoreCalculator.calcScore(gameBoardState), is(expected));

        BoardInitializer.initGameBoard(gomokuGameBoard);
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
        final Board gomokuGameBoard = new GomokuBoard(rowSize, columnSize);


        Moves[] movesArray = {moves1, moves2, moves3, moves4, moves5};
        // row0の場合しかやっていない
        IntStream.range(0, movesArray.length).forEach(i -> gomokuGameBoard.putMoves(1, i, movesArray[i]));


        Moves[][] gameBoardState = gomokuGameBoard.getGameBoardState();
        assertThat(gomokuScoreCalculator.calcScore(gameBoardState), is(expected));

        BoardInitializer.initGameBoard(gomokuGameBoard);
    }


}