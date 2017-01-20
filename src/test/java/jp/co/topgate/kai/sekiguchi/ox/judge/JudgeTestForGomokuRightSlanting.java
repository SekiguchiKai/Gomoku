package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * JudgeクラスをGomokuゲームの右斜めのラインの勝敗決定ロジック向けにテストするためのクラス
 * Created by sekiguchikai on 2017/01/20.
 */
public class JudgeTestForGomokuRightSlanting {

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
     * 右斜めの真ん中のラインにCircleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(0, 8)から操作終了値(4, 4)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInARightSlantingCenterSlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInARightSlantingCenterSlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 右斜めの真ん中のラインにCrossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(0, 8)から操作終了値(4, 4)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInARightSlantingCenterSlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInARightSlantingCenterSlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 右斜めの真ん中のラインに同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInARightSlantingCenterSlideDecideUserWinOrLose(Moves moves, Result expected) {
        Result actual;

        // (row:0, column8) ~ (row:4, column4)
        int column = 8;
        for (int row = 0; row < 5; row++) {
            board.putMoves(row, column, moves);
            column--;

        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:1, column7) ~ (row:5, column3)
        column = 7;
        for (int row = 1; row < 6; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:2, column6) ~ (row:6, column2)
        column = 6;
        for (int row = 2; row < 7; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:3, column5) ~ (row:7, column1)
        column = 5;
        for (int row = 3; row < 8; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:4, column4) ~ (row:8, column0)
        column = 4;
        for (int row = 4; row < 9; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();
    }


    /**
     * 右斜めの真ん中のrowに1個下にシフトさせたライン(1, 8)から右斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(1, 8)から操作終了値(5, 4)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInARightSlantingRow1SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInARightSlantingRow1SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 右斜めの真ん中のrowに1個下にシフトさせたライン(1, 8)から右斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(1, 8)から操作終了値(5, 4)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInARightSlantingRow1SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInARightSlantingRow1SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 右斜めの真ん中のrowに1個下にシフトさせたライン(1, 8)から右斜めに、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     * (row:1 , column:8 -> row: 5, column)
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInARightSlantingRow1SlideDecideUserWinOrLose(Moves moves, Result expected) {

        /**
         *
         * 以下で、開始値(1,8)から5連の調査を行い、開始値をrowに+1、columnに-1して行き、(5,4)まで開始値を進行させる
         * こうすることで、(1,8)の右斜めのラインを5こずつ限界まで操作できる
         */

        Result actual;

        // (row:1, column8) ~ (row:5, column4)
        int column = 8;
        for (int row = 1; row < 6; row++) {
            board.putMoves(row, column, moves);
            column--;

        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:2, column7) ~ (row:6, column3)
        column = 7;
        for (int row = 2; row < 7; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:3, column6) ~ (row:7, column2)
        column = 6;
        for (int row = 3; row < 8; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:4, column5) ~ (row:8, column1)
        column = 5;
        for (int row = 4; row < 9; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

    }

    /**
     * 右斜めの真ん中のrowに個下にシフトさせたライン(1, 8)から右斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(4, 8)から操作終了値(8, 4)までの5連を操作する
     */
    @Test
    public void puttingFiveCircleMovesInARightSlantingRow4SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInARightSlantingRow4SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 右斜めの真ん中のrowに4個下にシフトさせたライン(1, 8)から右斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(4, 8)から操作終了値(8, 4)までの5連を操作する
     */
    @Test
    public void puttingFiveCrossMovesInARightSlantingRow4SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInARightSlantingRow4SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 右斜めのラインにおいて、row方向にスライドさせた時に、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     * (row:1 , column:8 -> row: 5, column)
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInARightSlantingRow4SlideDecideUserWinOrLose(Moves moves, Result expected) {

        Result actual;

        int column = 8;
        for (int row = 4; row < 9; row++) {
            board.putMoves(row, column, moves);
            column--;
        }

        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

    }


    /**
     * 右斜めの真ん中のcolumnに1個下にシフトさせたライン(0, 7)から右斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(0, 7)から操作終了値(4, 3)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInARightSlantingColumn1SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInARightSlantingColumn1SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 右斜めの真ん中のcolumnに1個下にシフトさせたライン(0, 7)から右斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(0, 7)から操作終了値(4, 3)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCrossMovesInARightSlantingColumn1SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInARightSlantingColumn1SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }

    @Test
    public void sampletset() {
        board.putMoves(3, 4, Moves.CIRCLE);
        board.putMoves(4, 3, Moves.CIRCLE);
        board.putMoves(5, 2, Moves.CIRCLE);
        board.putMoves(6, 1, Moves.CIRCLE);
        board.putMoves(7, 0, Moves.CIRCLE);

        Result actual = judge.judgeResult(board);
        assertThat(actual, is(Result.WIN));

        this.init();

    }


    /**
     * 右斜めのラインにおいて、column方向にスライドさせた時に、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInARightSlantingColumn1SlideDecideUserWinOrLose(Moves moves, Result expected) {

        /**
         *
         * 以下で、開始値(0,7)から5連の調査を行い、開始値をrowに+1、columnに-1して行き、(3,4)まで開始値を進行させる
         * こうすることで、(0,7)の右斜めのラインを5こずつ限界まで操作できる
         */

        Result actual;

        // (row:0, column7) ~ (row:4, column3)
        int column = 7;
        for (int row = 0; row < 5; row++) {
            board.putMoves(row, column, moves);
            column--;

        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();


        // (row:1, column6) ~ (row:5, column2)
        column = 6;
        for (int row = 1; row < 6; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();


        // (row:2, column5) ~ (row:6, column1)
        column = 5;
        for (int row = 2; row < 7; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

        // (row:3, column4) ~ (row:7, column0)
        column = 4;
        for (int row = 3; row < 8; row++) {
            board.putMoves(row, column, moves);
            column--;
        }
        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

    }


    /**
     * 右斜めの真ん中のcolumnに個下にシフトさせたライン(0, 4)から右斜めに5連Circleの打ち手を5つ打つとCircleのユーザーの勝利が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(0, 4)から操作終了値(4, 0)までの5連を操作する
     */
    @Test
    public void puttingFiveCircleMovesInARightSlantingColumn4SlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInARightSlantingColumn4SlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 右斜めの真ん中のcolumnに4個下にシフトさせたライン(0, 4)から右斜めに5連Crossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 右斜めのラインは、操作開始値(0, 4)から操作終了値(4, 0)までの5連を操作する
     */
    @Test
    public void puttingFiveCrossMovesInARightSlantingColumn4SlideDecideCirCleUserLose() {
        this.puttingFiveSameMovesInARightSlantingColumn4SlideDecideUserWinOrLose(Moves.CROSS, Result.LOSE);
    }


    /**
     * 右斜めのラインにおいて、column方向にスライドさせた時に、同じの打ち手を5つ打つと勝敗が決定するかどうかを確認するためのメソッド
     *
     * @param moves    打ち手
     * @param expected 期待する結果
     */
    public void puttingFiveSameMovesInARightSlantingColumn4SlideDecideUserWinOrLose(Moves moves, Result expected) {

        Result actual;

        int column = 4;
        for (int row = 0; row < 5; row++) {
            board.putMoves(row, column, moves);
            column--;
        }

        actual = judge.judgeResult(board);
        assertThat(actual, is(expected));

        this.init();

    }


}
