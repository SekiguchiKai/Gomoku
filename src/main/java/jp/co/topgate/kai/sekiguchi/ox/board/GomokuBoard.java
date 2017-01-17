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
     * @param row    行
     * @param column 列
     */
    public GomokuBoard(final int row, final int column) {
        super(row, column);

        IntStream.range(0, super.getRowSize()).forEach(y -> IntStream.range(0, super.getColumnSize()).forEach(x -> super.putMoves(y, x, Moves.NO_MOVE)));
    }
}