package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Cellクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/10.
 */
public class CellTest {

    Cell cell = new Cell(3, 3);

    /**
     * setBestScoreメソッドをテストするためのメソッド
     */
    @Test
    public void setBestScore() {
        this.cell.setBestScore(100);
        assertThat(this.cell.getBestScore(), is(100));
    }

    /**
     * getBestScoreメソッドをテストするためのメソッド
     */
    @Test
    public void getBestScore() {
        this.cell.setBestScore(200);
        assertThat(this.cell.getBestScore(), is(200));
    }

    /**
     * getCellRowメソッドをテストするためのメソッド
     */
    @Test
    public void getCellRow() {
        assertThat(this.cell.getCellRow(), is(3));
    }

    /**
     * getCellColumnメソッドをテストするためのメソッド
     */
    @Test
    public void getCellColumn() {
        assertThat(this.cell.getCellColumn(), is(3));
    }

    /**
     * setMovesメソッドをテストするためのメソッド
     */
    @Test
    public void setMoves() {
        this.getMoves(Moves.CPU_MOVE, Moves.CPU_MOVE);
        this.getMoves(Moves.USER_MOVE, Moves.USER_MOVE);
    }


    /**
     * getMovesメソッドをテストし、setMovesメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param data     テストに用いるためのデータ
     * @param expected 期待する値
     */
    private void getMoves(Moves data, Moves expected) {
        this.cell.setMoves(data);
        Moves actual = this.cell.getMoves();
        assertThat(actual, is(expected));

    }

}