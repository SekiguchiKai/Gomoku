package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;

import java.io.IOException;


/**
 * コマンドラインの入出力を扱うインターフェース
 * Created by sekiguchikai on 2017/01/04.
 */
interface CommandLineIO {

    /**
     * コマンドライン上にゲーム盤を描くためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     */
    void drawBoard(TicTacToeBoard ticTacToeBoard);


    /**
     * 勝敗結果をコマンドライン上に描くためのメソッド
     *
     * @param result 勝敗結果
     */
    void drawResult(Result result);

    /**
     * コマンドラインからの入力を受け取り、受け取った入力を加工してプログラム上のゲーム盤の位置を返すメソッド
     *
     * @return 盤の場所（ユーザーからの入力がすでに石が置いてある場合場所だった場合:MAX_VALUE、ユーザーからの入力が不適切な数字だった場合 : MIN_VALUEを返す)
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    int receiveCommand(Moves[] gameBoard) throws IOException;


}
