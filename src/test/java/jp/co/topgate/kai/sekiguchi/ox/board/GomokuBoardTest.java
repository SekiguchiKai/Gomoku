package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
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

        // 全てMoves.CPU_MOVE
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> gomokuBoard.putMoves(row, column, Moves.CPU_MOVE)));
        Moves[][] gameBoardState = gomokuBoard.getGameBoardState();
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> this.getCellState(gameBoardState[row][column], Moves.CPU_MOVE)));


        // 全てMoves.USER_MOVE
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> gomokuBoard.putMoves(row, column, Moves.USER_MOVE)));
        Moves[][] gameBoardState2 = gomokuBoard.getGameBoardState();
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
        IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> this.gomokuBoard.putMoves(row, column, data)));

        IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> assertThat(this.gomokuBoard.getGameBoardState()[row][column], is(expected))));
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