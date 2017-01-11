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

    Board board = new GomokuBoard(9, 9);


    /**
     * putMovesメソッドをテストするためのメソッド
     */
    @Test
    public void putMoves() {

        Moves[] movesArray = new Moves[9];
        IntStream.range(0, 9).forEach(i -> movesArray[i] = Moves.CPU_MOVE);
        IntStream.range(0, 9).forEach(i -> this.getCellState(i, i, Moves.CPU_MOVE, Moves.CPU_MOVE));

        IntStream.range(0, 9).forEach(i -> movesArray[i] = Moves.USER_MOVE);
        IntStream.range(0, 9).forEach(i -> this.getCellState(i, i, Moves.CPU_MOVE, Moves.CPU_MOVE));

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
        IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> this.board.putMoves(row, column, data)));

        IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> assertThat(this.board.getGameBoardState()[row][column], is(expected))));
    }

    /**
     * getRowSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getRowSize() {
        int actual = this.board.getRowSize();
        assertThat(actual, is(9));
    }

    /**
     * getColumnSizeメソッドをテストするためのメソッド
     */
    @Test
    public void getColumnSize() {
        int actual = this.board.getColumnSize();
        assertThat(actual, is(9));
    }


}