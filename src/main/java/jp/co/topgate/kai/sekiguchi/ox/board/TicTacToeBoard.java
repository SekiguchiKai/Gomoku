package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * ゲーム盤を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class TicTacToeBoard {
    /**
     * 打ち手を格納するための配列
     */
    private Moves[] gameBoard = new Moves[9];

    public static int gameBoardLength = 9;

    /**
     * コンストラクタ
     * gameBoardを初期化する
     */
    public TicTacToeBoard() {
        IntStream.range(0, gameBoardLength).forEach(i -> gameBoard[i] = Moves.NO_MOVE);
    }


    /**
     * ゲーム盤に打ち手を打つためのメソッド
     *
     * @param spot  ゲーム盤の場所
     * @param Moves 各プレーヤーの打ち手
     */
    public void putMoves(int spot, Moves Moves) {
        gameBoard[spot] = Moves;
    }


    /**
     * gameBoardの指定されたインデックスの要素を返す
     *
     * @param index gameBoardの要素を指定するためのインデックス
     * @return インデックスで指定されたcellに格納されている要素
     */
    public Moves getCellState(int index) {
        return this.gameBoard[index];
    }

    /**
     * ゲーム盤の現在の状態を取得するためのメソッド
     *
     * @return ゲーム盤
     */
    public Moves[] getGameBoardState() {
        Moves[] copyArray = new Moves[9];
        IntStream.range(0, TicTacToeBoard.gameBoardLength).forEach(i -> copyArray[i] = this.gameBoard[i]);
        return copyArray;
    }

}
