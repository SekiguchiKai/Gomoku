package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.stream.IntStream;

/**
 * GameBoardクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class TicTacToeBoardTest {
    private TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();


//    /**
//     * putMovesメソッドをテストするためのメソッド
//     */
//    @Test
//    public void putMoves() {
//        this.putMovesHelper(Moves.CPU_MOVE);
//        this.putMovesHelper(Moves.USER_MOVE);
//        this.putMovesHelper(Moves.NO_MOVE);
//    }
//
//
//    void putMovesHelper(Moves moves) {
//        IntStream.range(0, 9).forEach(y -> IntStream.range(0, 9).forEach(x -> ticTacToeBoard.putMoves(y, x, moves)));
//        IntStream.range(0, 9).forEach(y -> IntStream.range(0, 9).forEach(x -> assertThat(ticTacToeBoard.getCellState(y, x), is(moves))));
//    }


}