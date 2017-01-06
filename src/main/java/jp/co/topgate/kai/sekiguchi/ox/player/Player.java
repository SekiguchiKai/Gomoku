package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;

import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;


/**
 * 各プレーヤーの打ち手を表す抽象クラス
 * Created by sekiguchikai on 2016/12/20.
 */
public abstract class Player {

    /**
     * プレーヤーの名前
     */
    String name;

    /**
     * Boardクラスのインスタンス
     */
    Board board;


    /**
     * MiniMaxクラスのインスタンス
     */
    MiniMax miniMax;

    /**
     * CommandLineIOクラスのインスタンス
     */
    CommandLineIO commandLineIO;


    /**
     * コンストラクタ
     * フィールドを初期化する
     *
     * @param board         Boardクラスのインスタンス
     * @param miniMax       MinMaxクラスのインスタンス
     * @param commandLineIO CommandLineIO クラスのインスタンス
     */
    Player(Board board, MiniMax miniMax, CommandLineIO commandLineIO, String name) {
        this.board = board;
        this.miniMax = miniMax;
        this.commandLineIO = commandLineIO;
        this.name = name;
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    public abstract void doMove(int depth);

    /**
     * プレーヤーに設定されている名前を返す
     *
     * @return プレーヤーの名前
     */
    public String getName() {
        return this.name;
    }


}
