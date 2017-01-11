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

    Board board = new GomokuBoard(3, 3);


    /**
     * putMovesメソッドをテストするためのメソッド
     */
    @Test
    public void putMoves() {

        Moves[] movesArray = new Moves[3];
        IntStream.range(0, 3).forEach(i -> movesArray[i] = Moves.USER_MOVE);
        IntStream.range(0, 3).forEach(i -> this.getCellState(i, i, Moves.USER_MOVE, Moves.USER_MOVE));


        IntStream.range(0, 3).forEach(i -> movesArray[i] = Moves.CPU_MOVE);
        IntStream.range(0, 3).forEach(i -> this.getCellState(i, i, Moves.CPU_MOVE, Moves.CPU_MOVE));

    }


    /**
     * getCellStateメソッドをテストし、putMovesメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param rowData    列のデータ
     * @param columnData 行のデータ
     * @param moveData   打ち手のデータ
     * @param expected   期待する値
     */
    private void getCellState(final int rowData, final int columnData, final Moves moveData, final Moves expected) {
        this.board.putMoves(rowData, columnData, moveData);
        Moves actual = this.board.getCellState(rowData, columnData);

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
        IntStream.range(0, 3).forEach(row -> IntStream.range(0, 3).forEach(column -> this.board.putMoves(row, column, data)));

        IntStream.range(0, 3).forEach(row -> IntStream.range(0, 3).forEach(column -> assertThat(this.board.getGameBoardState()[row][column], is(expected))));
    }

    /**
     * getRowSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getRowSize() {
        int actual = this.board.getRowSize();
        assertThat(actual, is(3));
    }

    /**
     * getColumnSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getColumnSize() {
        int actual = this.board.getColumnSize();
        assertThat(actual, is(3));
    }

}