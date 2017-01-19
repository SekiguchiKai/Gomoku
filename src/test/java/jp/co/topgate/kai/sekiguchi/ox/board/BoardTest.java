package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * GomokuGameBoardクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/10.
 */
public class BoardTest {
    final int row = 9;
    final int column = 9;
    Board board;

    @Before
    public void createGomokuBoard() {
        board = new Board(row, column);
    }

    /**
     * putMovesメソッドをテストするためのメソッド
     */
    @Test
    public void gomokuBoardPutMoves() {
        int rowSize = board.getRowSize();
        int columnSize = board.getColumnSize();

        // 全てMoves.CROSS
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> board.putMoves(row, column, Moves.CROSS)));
        Moves[][] gameBoardState = board.getGameBoardState();
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> this.getCellState(gameBoardState[row][column], Moves.CROSS)));


        // 全てMoves.CIRCLE
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> board.putMoves(row, column, Moves.CIRCLE)));
        Moves[][] gameBoardState2 = board.getGameBoardState();
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> this.getCellState(gameBoardState2[row][column], Moves.CIRCLE)));
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
        this.getGameBoardStateHelper(Moves.CROSS, Moves.CROSS);
        this.getGameBoardStateHelper(Moves.CIRCLE, Moves.CIRCLE);
        this.getGameBoardStateHelper(Moves.EMPTY, Moves.EMPTY);
    }


    /**
     * getGameBoardStateメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param data     テストに用いるためのデータ
     * @param expected 期待する値
     */
    private void getGameBoardStateHelper(Moves data, Moves expected) {
        IntStream.range(0, board.getRowSize()).forEach(row -> IntStream.range(0, board.getColumnSize()).forEach(column -> board.putMoves(row, column, data)));

        IntStream.range(0, board.getRowSize()).forEach(row -> IntStream.range(0, board.getColumnSize()).forEach(column -> assertThat(board.getGameBoardState()[row][column], is(expected))));
    }



    /**
     * getRowSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getRowSize() {
        int actual = this.board.getRowSize();
        assertThat(actual, is(row));
    }

    /**
     * getColumnSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getColumnSize() {
        int actual = this.board.getColumnSize();
        assertThat(actual, is(column));
    }


}