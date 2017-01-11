package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuBoard;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.GomokuScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.TicTacToeScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Judgementクラスをテストするためのクラス
 * <p>
 * Created by sekiguchikai on 2017/01/10.
 */
public class JudgementTest {


    /**
     * judgeResultメソッドをテストするためのメソッド
     */
    @Test
    public void judgeResult() {
        Board gomokuBoard = new GomokuBoard(9, 9);
        Board ticTacToeBoard = new TicTacToeBoard(3, 3);

        ScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();
        ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();

        Judgement gomokuJudgement = new Judgement(gomokuBoard, gomokuScoreCalculator);
        Judgement ticTacToeJudgement = new Judgement(ticTacToeBoard, ticTacToeScoreCalculator);

        // TicTacToe
        this.judgeResultHelper(3, Moves.CPU_MOVE, Result.LOSE, ticTacToeJudgement, ticTacToeBoard);
        this.initBoard(ticTacToeBoard);

        this.judgeResultHelper(3, Moves.USER_MOVE, Result.WIN, ticTacToeJudgement, ticTacToeBoard);
        this.initBoard(ticTacToeBoard);

        this.judgeResultHelper(3, Moves.NO_MOVE, Result.PENDING, ticTacToeJudgement, ticTacToeBoard);
        this.initBoard(ticTacToeBoard);


        // Gomoku
        this.judgeResultHelper(5, Moves.CPU_MOVE, Result.LOSE, gomokuJudgement, gomokuBoard);
        this.initBoard(gomokuBoard);

        this.judgeResultHelper(5, Moves.USER_MOVE, Result.WIN, gomokuJudgement, gomokuBoard);
        this.initBoard(gomokuBoard);

        this.judgeResultHelper(5, Moves.NO_MOVE, Result.PENDING, gomokuJudgement, gomokuBoard);
        this.initBoard(gomokuBoard);


    }


    /**
     * judgeResultメソッドをテストするためのメソッドを補助するメソッド
     *
     * @param moves     列挙型Movesの要素
     * @param result    列挙型Resultの要素
     * @param judgement Judgementクラスのインスタンス
     * @param board     Boardクラスのインスタンス
     */
    private void judgeResultHelper(int maxLength, Moves moves, Result result, Judgement judgement, Board board) {
        IntStream.range(0, maxLength).forEach(i -> board.putMoves(0, i, moves));

        assertThat(judgement.judgeResult(), is(result));

        IntStream.range(0, maxLength).forEach(i -> board.putMoves(i, 0, moves));
        assertThat(judgement.judgeResult(), is(result));

        IntStream.range(0, maxLength).forEach(i -> board.putMoves(i, i, moves));
        assertThat(judgement.judgeResult(), is(result));


    }

    /**
     * ゲーム盤をクリアするためのメソッド
     *
     * @param board Boardクラスのインスタンス
     */
    private void initBoard(Board board) {
        int rowSize = board.getRowSize();
        int columnSize = board.getColumnSize();

        IntStream.range(0, rowSize).forEach(y -> IntStream.range(0, columnSize).forEach(x -> board.putMoves(y, x, Moves.NO_MOVE)));
    }


}