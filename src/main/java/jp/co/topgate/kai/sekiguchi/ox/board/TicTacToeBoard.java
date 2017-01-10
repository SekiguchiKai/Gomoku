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
     * @param rowSize    ゲーム盤の行のサイズ
     * @param columnSize ゲーム盤の列のサイズ
     */
    public TicTacToeBoard(final int rowSize, final int columnSize) {
        super(rowSize, columnSize);
        IntStream.range(0, super.getColumnLength()).forEach(y -> IntStream.range(0, super.getRowLength()).forEach(x -> super.putMoves(y, x, Moves.NO_MOVE)));
    }


}
