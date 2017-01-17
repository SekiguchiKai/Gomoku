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
     * @param row    行
     * @param column 列
     */
    public TicTacToeBoard(final int row, final int column) {
        super(row, column);
        super.initGameBoard();
    }


}