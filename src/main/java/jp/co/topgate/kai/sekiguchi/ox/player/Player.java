package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;

import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;


/**
 * 各プレーヤーの打ち手を表す抽象クラス
 * Created by sekiguchikai on 2016/12/20.
 */
public abstract class Player {

    /**
     * ゲーム盤
     */

    Board board;


    /**
     * ミニマックスアルゴリズム
     */
    MinMaxCalculator minMaxCalculator;

    CommandLineIO commandLineIO;


    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param ticTacToeBoard         Boardクラスのインスタンス
     * @param minMaxCalculator       MinMaxCalculatorクラスのインスタンス
     * @param ticTacToeCommandLineIO CommandLineIOクラスのインスタンス
     */
    Player(Board board, MinMaxCalculator minMaxCalculator, CommandLineIO commandLineIO) {
        this.board = board;
        this.minMaxCalculator = minMaxCalculator;
        this.commandLineIO = commandLineIO;
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    public abstract void doMove(int depth);


}
