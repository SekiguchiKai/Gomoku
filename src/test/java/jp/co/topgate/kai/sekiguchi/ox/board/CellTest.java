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
    public void setUp() {
        final int row = 3;
        final int column = 3;
        this.cell = new Cell(row, column);
    }


    /**
     * setBestScoreメソッドをテストするためのメソッド
     */
    @Test
    public void cellに対してbestScore100を設定するとcellのbestScoreの値が100になる() {
        this.cell.setBestScore(100);
        assertThat(this.cell.getBestScore(), is(100));
    }

    /**
     * getBestScoreメソッドをテストするためのメソッド
     */
    @Test
    public void cellのbestScoreフィールドに200が設定されているときその値を取得できる() {
        this.cell.setBestScore(200);
        assertThat(this.cell.getBestScore(), is(200));
    }

    /**
     * getCellRowメソッドgetCellRowメソッドをテストするためのメソッド
     */
    @Test
    public void cellのrowに3を設定することが出来る() {
        final int row = 3;
        this.cell.setCellRow(row);
        assertThat(this.cell.getCellRow(), is(row));
    }

    /**
     * setCellColumnメソッドとgetCellColumnメソッドをテストするためのメソッド
     */
    @Test
    public void cellのcolumnに3を設定することが出来る() {
        final int column = 3;
        this.cell.setCellColumn(column);
        assertThat(this.cell.getCellColumn(), is(column));
    }

    /**
     * setMovesメソッドをテストするためのメソッド
     */
    @Test
    public void cellに打ち手を設定することが出来る() {
        this.cellに設定した打ち手を取得する(Moves.CROSS, Moves.CROSS);
        this.cellに設定した打ち手を取得する(Moves.CIRCLE, Moves.CIRCLE);
    }


    /**
     * getMovesメソッドをテストし、setMovesメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param data     テストに用いるためのデータ
     * @param expected 期待する値
     */
    private void cellに設定した打ち手を取得する(Moves data, Moves expected) {
        this.cell.setMoves(data);
        Moves actual = this.cell.getMoves();
        assertThat(actual, is(expected));

    }

}