package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Cpuクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class CpuTest {
//    private TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
//    private MinMaxCalculator minMaxCalculator = new MinMaxCalculator();
//    private TicTacToeCommandLineIO ticTacToeCommandLineIO = new TicTacToeCommandLineIO();
//    private Cpu cpu = new Cpu(ticTacToeBoard, minMaxCalculator, ticTacToeCommandLineIO);
//
//    /**
//     * doMoveメソッドをテストするためのメソッド
//     */
//    @Test
//    public void doMove() {
//        // ユーザーが四隅においた際
//        List<Integer> cornerList = Arrays.asList(0, 2, 6, 8);
//        cornerList.forEach(i -> {
//            ticTacToeBoard.putMoves(0, Moves.USER_MOVE);
//            this.assertDoMOve(2, 4, Moves.CPU_MOVE);
//        });
//
//        this.initGameBoard(ticTacToeBoard);
//
//        // 勝つ時の一手
//        ticTacToeBoard.putMoves(0, Moves.CPU_MOVE);
//        ticTacToeBoard.putMoves(1, Moves.CPU_MOVE);
//        this.assertDoMOve(2, 2, Moves.CPU_MOVE);
//
//        this.initGameBoard(ticTacToeBoard);
//
//        ticTacToeBoard.putMoves(0, Moves.CPU_MOVE);
//        ticTacToeBoard.putMoves(4, Moves.CPU_MOVE);
//        this.assertDoMOve(2, 8, Moves.CPU_MOVE);
//
//        this.initGameBoard(ticTacToeBoard);
//
//        ticTacToeBoard.putMoves(1, Moves.CPU_MOVE);
//        ticTacToeBoard.putMoves(4, Moves.CPU_MOVE);
//        this.assertDoMOve(2, 7, Moves.CPU_MOVE);
//
//
//        this.initGameBoard(ticTacToeBoard);
//        // 負けないための一手
//        ticTacToeBoard.putMoves(0, Moves.USER_MOVE);
//        ticTacToeBoard.putMoves(1, Moves.USER_MOVE);
//        this.assertDoMOve(2, 2, Moves.CPU_MOVE);
//
//        this.initGameBoard(ticTacToeBoard);
//
//        ticTacToeBoard.putMoves(0, Moves.USER_MOVE);
//        ticTacToeBoard.putMoves(4, Moves.USER_MOVE);
//        this.assertDoMOve(2, 8, Moves.CPU_MOVE);
//
//        this.initGameBoard(ticTacToeBoard);
//
//        ticTacToeBoard.putMoves(1, Moves.USER_MOVE);
//        ticTacToeBoard.putMoves(4, Moves.USER_MOVE);
//        this.assertDoMOve(2, 7, Moves.CPU_MOVE);
//
//        this.initGameBoard(ticTacToeBoard);
//
//
//    }
//
//    /**
//     * 引数で受け取ったBoarクラスのインスタンスを初期化するためのメソッド
//     *
//     * @param ticTacToeBoard Boardクラスのインスタンス
//     */
//    private void initGameBoard(TicTacToeBoard ticTacToeBoard) {
//        IntStream.range(0, 9).forEach(i -> ticTacToeBoard.putMoves(i, Moves.NO_MOVE));
//    }
//
//    /**
//     * doMoveメソッドが適切に実行されているかテストするためのメソッド
//     *
//     * @param depth    探索の深さ
//     * @param spot     ゲーム版の場所
//     * @param expected 期待する値
//     */
//    private void assertDoMOve(int depth, int spot, Moves expected) {
//        cpu.doMove(depth);
//        assertThat(ticTacToeBoard.getGameBoardState()[spot], is(expected));
//    }

}