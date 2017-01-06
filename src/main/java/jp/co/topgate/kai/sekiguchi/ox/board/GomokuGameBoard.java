package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * 五目並べのゲーム盤
 * Created by sekiguchikai on 2017/01/05.
 */
public class GomokuGameBoard extends Board {

    /**
     * ゲーム盤のX軸を表す
     */
    public static final int X = 9;
    /**
     * ゲーム盤のY軸を表す
     */
    public static final int Y = 9;

    /**
     * ゲーム盤を表す2次元配列
     */
    private Moves[][] gameBoard = new Moves[Y][X];

    /**
     * コンストラクタ
     * ゲーム盤のマス数を設定する
     *
     * @param y y軸の長さ
     * @param x x軸の長さ
     */
    public GomokuGameBoard() {
        IntStream.range(0, gameBoard.length).forEach(y -> IntStream.range(0, gameBoard[y].length).forEach(x -> gameBoard[y][x] = Moves.NO_MOVE));
    }
}
