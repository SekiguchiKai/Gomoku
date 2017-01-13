package jp.co.topgate.kai.sekiguchi.ox.util;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * Boardクラスのゲーム盤を初期化するためのクラス
 * Created by sekiguchikai on 2017/01/12.
 */
public class BoardInitializer {
    /**
     * Boardクラスのインスタンスを初期化するためのメソッド
     */
    public static void initGameBoard(Board board) {
        final int rowSize = board.getRowSize();
        final int columnSize = board.getColumnSize();

        IntStream.range(0, rowSize).forEach(y -> IntStream.range(0, columnSize).forEach(x -> board.putMoves(y, x, Moves.NO_MOVE)));
    }
}
