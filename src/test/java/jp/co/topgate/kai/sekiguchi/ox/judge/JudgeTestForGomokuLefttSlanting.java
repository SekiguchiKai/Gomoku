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
     * 左斜めのラインは、操作開始値(0, 8)から操作終了値(4, 4)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
     */
    @Test
    public void puttingFiveCircleMovesInALeftSlantingCenterSlideDecideCirCleUserWin() {
        this.puttingFiveSameMovesInALeftSlantingCenterSlideDecideUserWinOrLose(Moves.CIRCLE, Result.WIN);
    }

    /**
     * 左斜めの真ん中のラインにCrossの打ち手を5つ打つとCircleのユーザーの敗北が決定するかどうかを確認するためのメソッド
     * 左斜めのラインは、操作開始値(0, 8)から操作終了値(4, 4)までの5連を操作し、操作開始値を1つずつ左下のセルに限界値までシフトさせていく
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

}
