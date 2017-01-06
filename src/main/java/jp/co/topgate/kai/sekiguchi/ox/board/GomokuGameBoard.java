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
     */
    public GomokuGameBoard() {
        super(9, 9);
        IntStream.range(0, super.getYLength()).forEach(y -> IntStream.range(0, super.getXLength()).forEach(x -> super.putMoves(y, x, Moves.NO_MOVE)));
    }
}
