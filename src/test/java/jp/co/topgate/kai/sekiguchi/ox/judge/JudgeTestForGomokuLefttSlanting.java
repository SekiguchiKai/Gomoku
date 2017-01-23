package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * JudgeクラスをGomokuゲームの左斜めのラインの勝敗決定ロジック向けにテストするためのクラス
 * Created by sekiguchikai on 2017/01/20.
 */
public class JudgeTestForGomokuLefttSlanting {
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

    private void init() {
        this.board = new Board(this.rowSize, this.columnSize);
        this.judge = new Judge(this.rowSize, this.columnSize, this.judgeCriteriaSequence);
    }

    /**
     * 左斜めの真ん中のラインにCircleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(0, 0)から操作終了値(4, 4)までの5連を操作し、操作開始値を1つずつ右下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInALeftSlantingCenterSlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInALeftSlantingCenterSlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 左斜めの真ん中のラインにCrossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(0, 0)から操作終了値(4, 4)までの5連を操作し、操作開始値を1つずつ右下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInALeftSlantingCenterSlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInALeftSlantingCenterSlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 左斜めの真ん中のラインに同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInALeftSlantingCenterSlideDecideUserWinOrLose(Moves moves, Result expected) {
        Result actual;

        final int indexMax = 5;
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = 5;
        int column;

        for (int i = 0; i < indexMax; i++) {

            column = columnStart;
            for (int row = rowStart; row < rowEnd; row++) {
                board.putMoves(row, column, moves);
                column++;
            }
            actual = judge.judgeResult(board);
            assertThat(actual, is(expected));

            rowStart++;
            columnStart++;
            rowEnd++;

            this.init();
        }
    }

    /**
     * 左斜めの真ん中のrowに1個下にシフトさせたライン(1, 0)から右斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(0, 1)から操作終了値(5, 4)までの5連を操作し、操作開始値を1つずつ右下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInALeftSlantingRow1SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInALeftSlantingRow1SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 左斜めの真ん中のrowに1個下にシフトさせたライン(1, 8)から左斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(0, 1)から操作終了値(5, 4)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInALeftSlantingRow1SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInALeftSlantingRow1SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 左斜めの真ん中のrowに1個下にシフトさせたライン(0, 1)から左斜めに、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInALeftSlantingRow1SlideDecideUserWinOrLose(Moves moves, Result expected) {


        Result actual;

        // (row:1, column0) ~ (row:5, column4)
        int column = 0;
        for (int row = 1; row < 6; row++) {
            board.putMoves(row, column, moves);
            column++;

        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:2, column1) ~ (row:6, column5)
        column = 1;
        for (int row = 2; row < 7; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:3, column2) ~ (row:7, column6)
        column = 2;
        for (int row = 3; row < 8; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:4, column3) ~ (row:8, column7)
        column = 3;
        for (int row = 4; row < 9; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

    }


    /**
     * 左斜めの真ん中のrowに4個下にシフトさせたライン(4, 0)から左斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(4, 0)から操作終了値(8, 4)までの5連を操作し、操作開始値を1つずつ右下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInALeftSlantingRow4SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInALeftSlantingRow4SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 左斜めの真ん中のrowに1個下にシフトさせたライン(4, 0)から左斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(4, 0)から操作終了値(8, 4)までの5連を操作し、操作開始値を1つずつ右下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInALeftSlantingRow4SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInALeftSlantingRow4SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 左斜めの真ん中のrowに4個下にシフトさせたライン(0, 4)から左斜めに、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInALeftSlantingRow4SlideDecideUserWinOrLose(Moves moves, Result expected) {
        // (row:4, column0) ~ (row:8, column4)
        int column = 0;
        for (int row = 4; row < 9; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        Result actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();
    }

    /**
     * 左斜めの真ん中のcolumnに1個右にシフトさせたライン(0, 1)から左斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(0, 1)から操作終了値(4, 5)までの5連を操作し、操作開始値を1つずつ右下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInALeftSlantingColumn1SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInALeftSlantingColumn1SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 左斜めの真ん中のrowに1個右にシフトさせたライン(0, 1)から左斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(0, 1)から操作終了値(4, 5)までの5連を操作し、操作開始値を1つずつ右下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInALeftSlantingColumn1SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInALeftSlantingColumn1SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 左斜めの真ん中のrowに1個右にシフトさせたライン(0, 1)から左斜めに、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInALeftSlantingColumn1SlideDecideUserWinOrLose(Moves moves, Result expected) {


        Result actual;

        // (row:0, column1) ~ (row:4, column5)
        int column = 1;
        for (int row = 0; row < 5; row++) {
            board.putMoves(row, column, moves);
            column++;

        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:1, column2) ~ (row:5, column6)
        column = 2;
        for (int row = 1; row < 6; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:2, column3) ~ (row:6, column7)
        column = 3;
        for (int row = 2; row < 7; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:3, column4) ~ (row:7, column8)
        column = 4;
        for (int row = 3; row < 8; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

    }


    /**
     * 左斜めの真ん中のcolumnに4個右にシフトさせたライン(1, 0)から左斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(1, 0)から操作終了値(4, 5)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInALeftSlantingColumn4SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInALeftSlantingColumn4SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 左斜めの真ん中のrowに4個右にシフトさせたライン(1, 0)から左斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(1, 0)から操作終了値(4, 5)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInALeftSlantingColumn4SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInALeftSlantingColumn4SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 左斜めの真ん中のrowに4個右にシフトさせたライン(1, 0)から左斜めに、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInALeftSlantingColumn4SlideDecideUserWinOrLose(Moves moves, Result expected) {
        // (row:0, column4) ~ (row:4, column8)
        int column = 4;
        for (int row = 0; row < 5; row++) {
            board.putMoves(row, column, moves);
            column++;
        }
        Result actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();
    }


}
