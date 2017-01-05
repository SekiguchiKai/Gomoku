package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;

/**
 * 各プレーヤーの打ち手を表す抽象クラス
 * Created by sekiguchikai on 2016/12/20.
 */
public abstract class Player {

    /**
     * ゲーム盤
     */
    TicTacToeBoard ticTacToeBoard;

    /**
     * ミニマックスアルゴリズム
     */
    MinMaxCalculator minMaxCalculator;

    TicTacToeCommandLineIO ticTacToeCommandLineIO;


    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     * @param minMaxCalculator MinMaxCalculatorクラスのインスタンス
     * @param ticTacToeCommandLineIO CommandLineIOクラスのインスタンス
     */
    Player(TicTacToeBoard ticTacToeBoard, MinMaxCalculator minMaxCalculator, TicTacToeCommandLineIO ticTacToeCommandLineIO) {
        this.ticTacToeBoard = ticTacToeBoard;
        this.minMaxCalculator = minMaxCalculator;
        this.ticTacToeCommandLineIO = ticTacToeCommandLineIO;
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    public abstract void doMove(int depth);


}
