package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * GomokuScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/10.
 */
public class GomokuScoreCalculatorTest {

//
//    /**
//     * calcScoreメソッドをテストするためのメソッド
//     */
//    @Test
//    public void calcScore() {
//
//        this.helper(Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 1000000060);
//        this.helper(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, -999993060);
//        this.helper(Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, Moves.NO_MOVE, 0);
//
//
//        this.helper(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, -90);
//        this.helper(Moves.CIRCLE, Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, 10);
//        this.helper(Moves.CIRCLE, Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, 90);
//        this.helper(Moves.CIRCLE, Moves.CROSS, Moves.CROSS, Moves.CROSS, Moves.CROSS, 150);
//
//    }
//
//
//    /**
//     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
//     *
//     * @param moves1   テストで使用するMOVES型のデータ
//     * @param moves2   テストで使用するMOVES型のデータ
//     * @param moves3   テストで使用するMOVES型のデータ
//     * @param expected 期待する値
//     */
//    private void helper(Moves moves1, Moves moves2, Moves moves3, Moves moves4, Moves moves5, int expected) {
//
//        GomokuScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();
//        final int rowSize = 9;
//        final int columnSize = 9;
//        final Board gomokuGameBoard = new GomokuBoard(rowSize, columnSize);
//
//
//        Moves[] movesArray = {moves1, moves2, moves3, moves4, moves5};
//        IntStream.range(0, movesArray.length).forEach(i -> gomokuGameBoard.putMoves(0, i, movesArray[i]));
//
//
//        Moves[][] gameBoardState = gomokuGameBoard.getGameBoardState();
//        assertThat(gomokuScoreCalculator.calcScore(gameBoardState), is(expected));
//    }


}