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
public class GomokuBoardTest {

    Board gomokuBoard = new GomokuBoard(9, 9);
    


    /**
     * putMovesメソッドをテストするためのメソッド
     */
    @Test
    public void putMoves() {
        int rowSize = gomokuBoard.getRowSize();
        int columnSize = gomokuBoard.getColumnSize();

        // 全てMoves.CROSS
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> gomokuBoard.putMoves(row, column, Moves.CROSS)));
        Moves[][] gameBoardState = gomokuBoard.getGameBoardState();
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> this.getCellState(gameBoardState[row][column], Moves.CROSS)));


        // 全てMoves.CIRCLE
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> gomokuBoard.putMoves(row, column, Moves.CIRCLE)));
        Moves[][] gameBoardState2 = gomokuBoard.getGameBoardState();
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
        IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> this.gomokuBoard.putMoves(row, column, data)));

        IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> assertThat(this.gomokuBoard.getGameBoardState()[row][column], is(expected))));
    }

    /**
     * initGameBoardメソッドテストするためのメソッド
     */
    @Test
    public void initGameBoard() {
        final int row = 1;
        final int column = 1;

        gomokuBoard.putMoves(row, column, Moves.CROSS);
        Moves actual = gomokuBoard.getCellState(row, column);

        Moves expected = Moves.CROSS;
        assertThat(actual, is(expected));


        gomokuBoard.initGameBoard();
        Moves actual2 = gomokuBoard.getCellState(row, column);
        Moves expected2 = Moves.EMPTY;
        assertThat(actual2, is(expected2));
    }

    /**
     * getRowSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getRowSize() {
        int actual = this.gomokuBoard.getRowSize();
        assertThat(actual, is(9));
    }

    /**
     * getColumnSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getColumnSize() {
        int actual = this.gomokuBoard.getColumnSize();
        assertThat(actual, is(9));
    }


}