package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;


import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * JudgeクラスをTicTacToeゲーム向けにテストするためのメソッド
 * Created by sekiguchikai on 2017/01/18.
 */
public class JudgeTestForTicTacToe {
    final int rowSize = 3;
    final int columnSize = 3;
    final int judgeCriteriaSequence = 3;
    private Board board;
    private Judge judge;

    @Before
    public void setU() {
        this.board = new Board(this.rowSize, this.columnSize);
        this.judge = new Judge(this.rowSize, this.columnSize, this.judgeCriteriaSequence);
    }


    /**
     * rowにCircleの打ち手を3つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * rowは、0~2行目まで全てを網羅している
     */
    @Test
    public void 同じrowにCIRCLEを3個並べるとUserの勝利が決定する() {
        this.puttingThreeSameMovesInARowDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * rowにCrossの打ち手を3つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * rowは、0~2行目まで全てを網羅している
     */
    @Test
    public void 同じrowにCROSSを3個並べるとUserの敗北が決定する() {
        this.puttingThreeSameMovesInARowDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * rowに同じの打ち手を3つ打つと勝敗が決定するかどうかを確認するためのメソッド
     * rowは、0~2行目まで全てを網羅している
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingThreeSameMovesInARowDecideUserWinOrLose(Moves moves, Result expected) {
        for (int row = 0; row < this.rowSize; row++) {
            for (int column = 0; column < this.columnSize; column++) {
                board.putMoves(row, column, moves);
            }
            Result actual = judge.judgeResult(board);
            assertThat(actual, is(expected));
        }
    }


    /**
     * columnにCircleの打ち手を3つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * columnは、0~2行目まで全てを網羅している
     */
    @Test
    public void 同じcolumnにCIRCLEを3個並べるとUserの勝利が決定する() {
        this.puttingThreeSameMovesInAColumnDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * columnにCrossの打ち手を3つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * columnは、0~2行目まで全てを網羅している
     */
    @Test
    public void 同じcolumnにCROSSを個並べるとUserの敗北が決定する() {
        this.puttingThreeSameMovesInAColumnDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * columnに同じの打ち手を3つ打つと勝敗が決定するかどうかを確認するためのメソッド
     * columnは、0~2行目まで全てを網羅している
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingThreeSameMovesInAColumnDecideUserWinOrLose(Moves moves, Result expected) {
        for (int column = 0; column < this.rowSize; column++) {
            for (int row = 0; row < this.rowSize; row++) {
                board.putMoves(row, column, moves);
            }
            Result actual = judge.judgeResult(board);
            assertThat(actual, is(expected));
        }
    }


    /**
     * 左斜めのラインにCircleの打ち手を3つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、0~2行目まで全てを網羅している
     */
    @Test
    public void 左斜めの対角線のラインに3個のCIRCLEを並べるとUserの勝利が決定する() {
        this.puttingThreeSameMovesInALeftSlantingDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 左斜めのラインにCrossの打ち手を3つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、0~2行目まで全てを網羅している
     */
    @Test
    public void 左斜めの対角線のラインに3個のCROSSを並べるとUserの敗北が決定する() {
        this.puttingThreeSameMovesInALeftSlantingDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 左斜めのラインに同じの打ち手を3つ打つと勝敗が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、0~2行目まで全てを網羅している
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingThreeSameMovesInALeftSlantingDecideUserWinOrLose(Moves moves, Result expected) {
        final int indexSize = 3;
        IntStream.range(0, indexSize).forEach(idx -> board.putMoves(idx, idx, moves));

        Result actual = judge.judgeResult(board);
        assertThat(actual, is(expected));
    }

    /**
     * 右斜めのラインにCircleの打ち手を3つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、0~2行目まで全てを網羅している
     */
    @Test
    public void 右斜めの対角線のラインに3個のCIRCLEを並べるとUserの勝利が決定する() {
        this.puttingThreeSameMovesInARightSlantingDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 右斜めのラインにCrossの打ち手を3つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、0~2行目まで全てを網羅している
     */
    @Test
    public void 右斜めの対角線のラインに3個のCROSSを並べるとUserの敗北が決定する() {
        this.puttingThreeSameMovesInARightSlantingDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 右斜めのラインに同じの打ち手を3つ打つと勝敗が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、0~2行目まで全てを網羅している
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingThreeSameMovesInARightSlantingDecideUserWinOrLose(Moves moves, Result expected) {

        int column = 2;

        for (int row = 0; row < rowSize; row++) {
            board.putMoves(row, column, moves);
            column--;
        }

        Result actual = judge.judgeResult(board);
        assertThat(actual, is(expected));
    }


}