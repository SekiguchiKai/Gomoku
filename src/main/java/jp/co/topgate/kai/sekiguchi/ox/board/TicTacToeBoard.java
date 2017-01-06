package jp.co.topgate.kai.sekiguchi.ox.board;


import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * ゲーム盤を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class TicTacToeBoard extends Board {


    /**
     * ゲーム盤のX軸を表す
     */
    private final int X = 3;
    /**
     * ゲーム盤のY軸を表す
     */
    private final int Y = 3;

    /**
     * ゲーム盤を表す2次元配列
     */
    private Moves[][] gameBoard = new Moves[Y][X];

    /**
     * コンストラクタ
     * ゲーム盤のマス数を設定する
     */
    public TicTacToeBoard() {
        IntStream.range(0, gameBoard.length).forEach(y -> IntStream.range(0, gameBoard[y].length).forEach(x -> gameBoard[y][x] = Moves.NO_MOVE));
    }
}
