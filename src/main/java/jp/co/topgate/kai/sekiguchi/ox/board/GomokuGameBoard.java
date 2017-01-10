package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * 五目並べのゲーム盤
 * Created by sekiguchikai on 2017/01/05.
 */
public class GomokuGameBoard extends Board {
    /**
     * コンストラクタ
     * ゲーム盤のマス数を設定する
     * @param rowSize ゲーム盤の行のサイズ
     * @param columnSize ゲーム盤の列のサイズ
     */
    public GomokuGameBoard(final int rowSize, final int columnSize) {
        super(rowSize, columnSize);
        IntStream.range(0, getRowLength()).forEach(y -> IntStream.range(0, super.getColumnLength()).forEach(x -> super.putMoves(y, x, Moves.NO_MOVE)));
    }
}
