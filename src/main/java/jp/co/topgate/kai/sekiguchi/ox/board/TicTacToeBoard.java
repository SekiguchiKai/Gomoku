package jp.co.topgate.kai.sekiguchi.ox.board;


import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * ゲーム盤を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class TicTacToeBoard extends Board {

    /**
     * コンストラクタ
     * ゲーム盤のマス数を設定する
     *
     * @param rowSize    rowのサイズ
     * @param columnSize 列のサイズ
     */
    public TicTacToeBoard(final int rowSize, final int columnSize) {
        super(rowSize, columnSize);
        super.initGameBoard();
    }


}