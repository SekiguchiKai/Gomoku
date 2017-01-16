package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.Cell;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.util.Counter;


/**
 * CPUの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Cpu extends Player {

    /**
     * コンストラクタ
     * フィールドを初期化する
     *
     * @param board         Boardクラスのインスタンス
     * @param miniMax       MinMaxクラスのインスタンス
     * @param commandLineIO CommandLineIO クラスのインスタンス
     */
    public Cpu(final Board board, final MiniMax miniMax, final CommandLineIO commandLineIO, final String name) {
        super(board, miniMax, commandLineIO, name);
    }


    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    @Override
    public void doMove(final int depth) {

        Cell cell = super.miniMax.calcMinMax(depth, board, Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);

        final int row = cell.getCellRow();
        final int column = cell.getCellColumn();


        System.out.println("CPUの打ち手は、Y: " + row + "X:" + column);
        board.putMoves(row, column, Moves.CPU_MOVE);

        commandLineIO.drawUI(board);

    }
}