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
 * JudgeクラスをGomokuゲーム向けにテストするためのメソッド
 * Created by sekiguchikai on 2017/01/20.
 */
public class JudgeTestForGomoku {

    final int rowSize = 9;
    final int columnSize = 9;
    final int judgeCriteriaSequence = 5;
    private Board board;
    private Judge judge;

    @Before
    public void createInstances() {
        this.board = new Board(this.rowSize, this.columnSize);
        this.judge = new Judge(this.rowSize, this.columnSize, this.judgeCriteriaSequence);
    }

    /**
     * rowにCircleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * rowは、0~9行目まで全てを網羅している
     * columnは、0~4、1~5、のように範囲をスライドし、全てを網羅している
     */
    @Test
    public void puttingFiveCircleMovesInARowDecideCirCleUserWin() {
        int columnEndNum = 5;

        for (int columnStartNum = 0; columnStartNum < 4; columnStartNum++) {
            this.puttingFiveSameMovesInARowDecideUserWinOrLose(columnStartNum, columnEndNum, Moves.CIRCLE, Result.WIN);
            columnEndNum++;
        }
    }

    /**
     * rowにCircleの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * rowは、0~9行目まで全てを網羅している
     * columnは、0~4、1~5、のように範囲をスライドし、全てを網羅している
     */
    @Test
    public void puttingFiveCrossMovesInARowDecideCirCleUserLose() {
        int columnEndNum = 5;

        for (int columnStartNum = 0; columnStartNum < 4; columnStartNum++) {
            this.puttingFiveSameMovesInARowDecideUserWinOrLose(columnStartNum, columnEndNum, Moves.CROSS, Result.LOSE);
            columnEndNum++;
        }
    }

    /**
     * 引数で受け取ったcolumnの範囲で、全てのrow（0~9）を操作し、勝敗がついたか確認する
     *
     * @param columnStartNum 操作するラインのcolumnの操作開始場所
     * @param columnEndNum   操作するラインのcolumnの操作終了場所
     * @param moves          打ち手
     * @param expected       期待する結果
     */
    public void puttingFiveSameMovesInARowDecideUserWinOrLose(final int columnStartNum, final int columnEndNum, Moves moves, Result expected) {

        for (int row = 0; row < rowSize; row++) {
            for (int column = columnStartNum; column < columnEndNum; column++) {
                board.putMoves(row, column, moves);
            }
            Result actual = judge.judgeResult(board);
            assertThat(actual, is(expected));
        }
    }

    /**
     * columnにCircleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * columnは、0~9列目まで全てを網羅している
     * rowは、0~4、1~5、のように範囲をスライドし、全てを網羅している
     */
    @Test
    public void puttingFiveCircleMovesInAColumnDecideCirCleUserWin() {
        int rowEndNum = 5;

        for (int rowStartNum = 0; rowStartNum < 4; rowStartNum++) {
            this.puttingFiveSameMovesInAColumnDecideUserWinOrLose(rowStartNum, rowEndNum, Moves.CIRCLE, Result.WIN);
            rowEndNum++;
        }
    }

    /**
     * columnにCircleの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * columnは、0~9列目まで全てを網羅している
     * rowは、0~4、1~5、のように範囲をスライドし、全てを網羅している
     */
    @Test
    public void puttingFiveCrossMovesInAColumnDecideCirCleUserLose() {
        int rowEndNum = 5;

        for (int rowStartNum = 0; rowStartNum < 4; rowStartNum++) {
            this.puttingFiveSameMovesInAColumnDecideUserWinOrLose(rowStartNum, rowEndNum, Moves.CROSS, Result.LOSE);
            rowEndNum++;
        }
    }

    /**
     * 引数で受け取ったrowの範囲で、全てのcolumn(0~9）を操作し、勝敗がついたか確認する
     *
     * @param rowStartNum 操作するラインのrowの操作開始場所
     * @param rowEndNum   操作するラインのrowの操作終了場所
     * @param moves       打ち手
     * @param expected    期待する結果
     */
    public void puttingFiveSameMovesInAColumnDecideUserWinOrLose(final int rowStartNum, final int rowEndNum, Moves moves, Result expected) {

        for (int column = 0; column < columnSize; column++) {
            for (int row = rowStartNum; row < rowEndNum; row++) {
                board.putMoves(row, column, moves);
            }
            Result actual = judge.judgeResult(board);
            assertThat(actual, is(expected));
        }
    }


    /**
     * 右斜めのラインにCircleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、0~2行目まで全てを網羅している
     */
    @Test
    public void puttingFiveCircleMovesInARightSlantingDecideCirCleUserWin() {
        this.puttingFiveSameMovesInARightSlantingDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 右斜めのラインにCrossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、0~2行目まで全てを網羅している
     */
    @Test
    public void puttingFiveCrossMovesInARightSlantingDecideCirCleUserLose() {
        this.puttingFiveSameMovesInARightSlantingDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 右斜めのラインに同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、0~2行目まで全てを網羅している
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInARightSlantingDecideUserWinOrLose(Moves moves, Result expected) {
        int column = columnSize - 1;
        for (int row = 0; row < this.judgeCriteriaSequence; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        Result actual = this.judge.judgeResult(board);
        assertThat(actual, is(expected));

    }


}
