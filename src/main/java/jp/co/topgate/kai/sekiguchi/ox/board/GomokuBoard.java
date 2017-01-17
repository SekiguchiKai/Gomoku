package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * 五目並べのゲーム盤
 * Created by sekiguchikai on 2017/01/05.
 */
public class GomokuBoard extends Board {

    /**
     * コンストラクタ
     * ゲーム盤のマス数を設定する
     *
     * @param rowSize    rowのサイズ
     * @param columnSize 列のサイズ
     */
    public GomokuBoard(final int rowSize, final int columnSize) {
        super(rowSize, columnSize);

        super.initGameBoard();
    }
}