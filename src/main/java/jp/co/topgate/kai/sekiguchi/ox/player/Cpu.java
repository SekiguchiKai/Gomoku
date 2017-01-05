package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;

/**
 * CPUの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Cpu extends Player {

    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param ticTacToeBoard ゲーム盤
     */
    public Cpu(TicTacToeBoard ticTacToeBoard, MinMaxCalculator minMaxCalculator, TicTacToeCommandLineIO ticTacToeCommandLineIO) {
        super(ticTacToeBoard, minMaxCalculator, ticTacToeCommandLineIO);
    }


    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    @Override
    public void doMove(int depth) {
        int spot = super.minMaxCalculator.calcMinMax(depth, ticTacToeBoard.getGameBoardState(), Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE).getBestSpot();
        System.out.println("CPUの打ち手は、" + spot);
        ticTacToeBoard.putMoves(spot, Moves.CPU_MOVE);

        ticTacToeCommandLineIO.drawBoard(ticTacToeBoard);
    }
}
