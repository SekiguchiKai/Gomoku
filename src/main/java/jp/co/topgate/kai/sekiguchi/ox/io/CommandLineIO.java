package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;


/**
 * コマンドラインの入出力を扱うインターフェース
 * Created by sekiguchikai on 2017/01/04.
 */
public abstract class CommandLineIO {

    /**
     * コマンドライン上にゲーム盤を描くためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     */
    public abstract void drawUI(TicTacToeBoard ticTacToeBoard);

}
