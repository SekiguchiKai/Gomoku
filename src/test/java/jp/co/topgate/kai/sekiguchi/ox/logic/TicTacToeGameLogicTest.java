package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * NormalGameLogicクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class TicTacToeGameLogicTest {


    /**
     * judgeResultメソッドをテストするためのメソッド
     */
    @Test
    public void judgeResult() {
        TicTacToeGameLogic ticTacToeGameLogic = new TicTacToeGameLogic();
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

        this.callHelper(ticTacToeBoard, Moves.USER_MOVE, ticTacToeGameLogic);
        this.callHelper(ticTacToeBoard, Moves.CPU_MOVE, ticTacToeGameLogic);
        this.callHelper(ticTacToeBoard, Moves.NO_MOVE, ticTacToeGameLogic);

        IntStream.range(0, TicTacToeBoard.gameBoardLength).forEach(i -> ticTacToeBoard.putMoves(i, Moves.NO_MOVE));

        ticTacToeBoard.putMoves(0, Moves.CPU_MOVE);
        ticTacToeBoard.putMoves(1, Moves.CPU_MOVE);
        ticTacToeBoard.putMoves(2, Moves.USER_MOVE);
        ticTacToeBoard.putMoves(3, Moves.USER_MOVE);
        ticTacToeBoard.putMoves(4, Moves.USER_MOVE);
        ticTacToeBoard.putMoves(5, Moves.CPU_MOVE);
        ticTacToeBoard.putMoves(6, Moves.CPU_MOVE);
        ticTacToeBoard.putMoves(7, Moves.USER_MOVE);
        ticTacToeBoard.putMoves(8, Moves.CPU_MOVE);


        this.assertDraw(ticTacToeBoard.getGameBoardState(), ticTacToeGameLogic);
    }

    /**
     * assertLinesとassertResultを実行するためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     * @param moves 列挙型MOVESの要素
     */

    private void callHelper(TicTacToeBoard ticTacToeBoard, Moves moves, TicTacToeGameLogic ticTacToeGameLogic) {
        setGameBoard(ticTacToeBoard, 0, 1, 2, moves, moves, moves);
        assertResult(ticTacToeBoard, moves, ticTacToeGameLogic);


        setGameBoard(ticTacToeBoard, 3, 4, 5, moves, moves, moves);
        assertResult(ticTacToeBoard, moves, ticTacToeGameLogic);

        setGameBoard(ticTacToeBoard, 6, 7, 8, moves, moves, moves);
        assertResult(ticTacToeBoard, moves, ticTacToeGameLogic);

        setGameBoard(ticTacToeBoard, 0, 3, 6, moves, moves, moves);
        assertResult(ticTacToeBoard, moves, ticTacToeGameLogic);

        setGameBoard(ticTacToeBoard, 2, 5, 8, moves, moves, moves);
        assertResult(ticTacToeBoard, moves, ticTacToeGameLogic);

        setGameBoard(ticTacToeBoard, 0, 4, 8, moves, moves, moves);
        assertResult(ticTacToeBoard, moves, ticTacToeGameLogic);

        setGameBoard(ticTacToeBoard, 2, 4, 6, moves, moves, moves);
        assertResult(ticTacToeBoard, moves, ticTacToeGameLogic);
    }

    /**
     * ゲーム盤をセットするためメソッド
     *
     * @param ticTacToeBoard  Boardクラスのインスタンス
     * @param spot1  ゲーム盤の場所
     * @param spot2  ゲーム盤の場所
     * @param spot3  ゲーム盤の場所
     * @param moves1 列挙型MOVESの要素
     * @param moves2 列挙型MOVESの要素
     * @param moves3 列挙型MOVESの要素
     */

    private void setGameBoard(TicTacToeBoard ticTacToeBoard, int spot1, int spot2, int spot3, Moves moves1, Moves moves2, Moves moves3) {
        ticTacToeBoard.putMoves(spot1, moves1);
        ticTacToeBoard.putMoves(spot2, moves2);
        ticTacToeBoard.putMoves(spot3, moves3);


    }


    /**
     * 勝ち、負け、未決が適切に決定されているかをテストするためのメソッド
     *
     * @param ticTacToeBoard           Boardクラスのインスタンス
     * @param moves           列挙型MOVESの要素
     * @param ticTacToeGameLogic ゲームのロジック
     */

    private void assertResult(TicTacToeBoard ticTacToeBoard, Moves moves, TicTacToeGameLogic ticTacToeGameLogic) {
        if (moves == Moves.USER_MOVE) {
            assertThat(ticTacToeGameLogic.judgeResult(ticTacToeBoard.getGameBoardState()), is(Result.WIN));
        } else if (moves == Moves.CPU_MOVE) {
            assertThat(ticTacToeGameLogic.judgeResult(ticTacToeBoard.getGameBoardState()), is(Result.LOSE));
        } else if (moves == Moves.NO_MOVE) {
            assertThat(ticTacToeGameLogic.judgeResult(ticTacToeBoard.getGameBoardState()), is(Result.PENDING));
        }

        IntStream.range(0, TicTacToeBoard.gameBoardLength).forEach(i -> ticTacToeBoard.putMoves(i, Moves.NO_MOVE));
    }

        /**
         * 引き分けが適切に決定されているかをテストするためのメソッド
         *
         * @param gameBoard       ゲーム盤
         * @param ticTacToeGameLogic ゲームのロジック
         */

    private void assertDraw(Moves[] gameBoard, TicTacToeGameLogic ticTacToeGameLogic) {
        assertThat(ticTacToeGameLogic.judgeResult(gameBoard), is(Result.DRAW));
    }


}