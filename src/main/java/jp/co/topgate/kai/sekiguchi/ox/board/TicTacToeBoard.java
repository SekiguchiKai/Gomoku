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
     */
    public TicTacToeBoard() {
        super(3, 3);
        IntStream.range(0, super.getColumnSize()).forEach(y -> IntStream.range(0, super.getRowSize()).forEach(x -> super.putMoves(y, x, Moves.NO_MOVE)));
    }


}
