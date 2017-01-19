package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.minimax.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Cellクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/10.
 */
public class CellTest {
    Cell cell;

    @Before
    public void createCell() {
        this.cell = new Cell();
    }


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
     * getCellRowメソッドgetCellRowメソッドをテストするためのメソッド
     */
    @Test
    public void setAndGetCellRow() {
        final int row = 3;
        this.cell.setCellRow(row);
        assertThat(this.cell.getCellRow(), is(row));
    }

    /**
     * setCellColumnメソッドとgetCellColumnメソッドをテストするためのメソッド
     */
    @Test
    public void setAndGetCellColumn() {
        final int column = 3;
        this.cell.setCellColumn(column);
        assertThat(this.cell.getCellColumn(), is(column));
    }

    /**
     * setMovesメソッドをテストするためのメソッド
     */
    @Test
    public void setMoves() {
        this.getMoves(Moves.CROSS, Moves.CROSS);
        this.getMoves(Moves.CIRCLE, Moves.CIRCLE);
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