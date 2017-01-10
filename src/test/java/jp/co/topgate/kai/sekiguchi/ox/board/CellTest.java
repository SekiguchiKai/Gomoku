package jp.co.topgate.kai.sekiguchi.ox.board;

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

    @Test
    public void getBestScore() {
        this.cell.setBestScore(200);
        assertThat(this.cell.getBestScore(), is(200));
    }

    @Test
    public void getCellRow() {

    }

    @Test
    public void getCellColumn() {

    }

    @Test
    public void setMoves() {

    }

    @Test
    public void getMoves() {

    }

}