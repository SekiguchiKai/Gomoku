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
    Board ticTacToeBoard = new GomokuBoard(3, 3);

    /**
     * initGameBoardメソッドテストするためのメソッド
     */
    @Test
    public void initGameBoard() {
        final int row = 1;
        final int column = 1;

        ticTacToeBoard.putMoves(row, column, Moves.CPU_MOVE);
        Moves actual = ticTacToeBoard.getCellState(row, column);

        Moves expected = Moves.CPU_MOVE;
        assertThat(actual, is(expected));


        ticTacToeBoard.initGameBoard();
        Moves actual2 = ticTacToeBoard.getCellState(row, column);
        Moves expected2 = Moves.NO_MOVE;
        assertThat(actual2, is(expected2));
    }


    /**
     * putMovesメソッドをテストするためのメソッド
     */
    @Test
    public void putMoves() {

        int rowSize = ticTacToeBoard.getRowSize();
        int columnSize = ticTacToeBoard.getColumnSize();

        // 全てMoves.CPU_MOVE
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> ticTacToeBoard.putMoves(row, column, Moves.CPU_MOVE)));
        Moves[][] gameBoardState = ticTacToeBoard.getGameBoardState();
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> this.getCellState(gameBoardState[row][column], Moves.CPU_MOVE)));


        // 全てMoves.USER_MOVE
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> ticTacToeBoard.putMoves(row, column, Moves.USER_MOVE)));
        Moves[][] gameBoardState2 = ticTacToeBoard.getGameBoardState();
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> this.getCellState(gameBoardState2[row][column], Moves.USER_MOVE)));


    }


    /**
     * getCellStateメソッドをテストし、putMovesメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param actual   実際の値
     * @param expected 期待する値
     */
    private void getCellState(Moves actual, Moves expected) {

        assertThat(actual, is(expected));
    }


    /**
     * getGameBoardStateメソッドをテストするためのメソッド
     */
    @Test
    public void getGameBoardState() {

        this.getGameBoardStateHelper(Moves.CPU_MOVE, Moves.CPU_MOVE);
        this.getGameBoardStateHelper(Moves.USER_MOVE, Moves.USER_MOVE);
        this.getGameBoardStateHelper(Moves.NO_MOVE, Moves.NO_MOVE);
    }


    /**
     * getGameBoardStateメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param data     テストに用いるためのデータ
     * @param expected 期待する値
     */
    private void getGameBoardStateHelper(Moves data, Moves expected) {

        int rowSize = ticTacToeBoard.getRowSize();
        int columnSize = ticTacToeBoard.getColumnSize();

        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> this.ticTacToeBoard.putMoves(row, column, data)));

        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> assertThat(this.ticTacToeBoard.getGameBoardState()[row][column], is(expected))));
    }

    /**
     * getRowSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getRowSize() {
        int actual = this.ticTacToeBoard.getRowSize();
        assertThat(actual, is(3));
    }

    /**
     * getColumnSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getColumnSize() {
        int actual = this.ticTacToeBoard.getColumnSize();
        assertThat(actual, is(3));
    }

}