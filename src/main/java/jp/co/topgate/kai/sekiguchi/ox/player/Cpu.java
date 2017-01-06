package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.minimax.TicTacToeMiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;



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
    public Cpu(Board board, TicTacToeMiniMax ticTacToeMiniMax, CommandLineIO commandLineIO) {
        super(board, ticTacToeMiniMax, commandLineIO);
    }


    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    @Override
    public void doMove(int depth) {
        int y = super.ticTacToeMiniMax.calcMinMax(depth, board, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE).getCellY();
        int x = super.ticTacToeMiniMax.calcMinMax(depth, board, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE).getCellX();


        System.out.println("CPUの打ち手は、Y: " + y + "X:" + x);
        board.putMoves(y, x, Moves.CPU_MOVE);

        commandLineIO.drawUI(board);
    }
}
