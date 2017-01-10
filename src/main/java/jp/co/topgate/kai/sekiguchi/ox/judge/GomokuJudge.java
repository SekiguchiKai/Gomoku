package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;

import java.util.stream.IntStream;


/**
 * 五目並べの勝敗結果を審査するためのクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class GomokuJudge implements Judgement {

    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param board Boardクラスのインスランス
     * @return 勝敗の結果
     */
    public Result judgeResult(final Board board) {

        if (this.judgeLose(board.getGameBoardState())) {
            return Result.LOSE;
        } else if (this.judgeWin(board.getGameBoardState())) {
            return Result.WIN;
        } else if (this.judgeDraw(board.getGameBoardState())) {
            return Result.DRAW;
        }

        return Result.PENDING;
    }


    /**
     * ユーザーが敗北しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが敗北しているかの真偽値
     */
    boolean judgeLose(final Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.CPU_MOVE) || this.judgeColumn(gameBoard, Moves.CPU_MOVE) || this.judgeLeftSlanting(gameBoard, Moves.CPU_MOVE) || this.judgeRightSlanting(gameBoard, Moves.CPU_MOVE);
    }

    /**
     * ユーザーが勝利しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利しているかの真偽値
     */
    boolean judgeWin(final Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.USER_MOVE) || this.judgeColumn(gameBoard, Moves.USER_MOVE) || this.judgeLeftSlanting(gameBoard, Moves.USER_MOVE) || this.judgeRightSlanting(gameBoard, Moves.USER_MOVE);
    }

    /**
     * 引き分けかどうかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 引き分けかどうかの真偽値
     */
    boolean judgeDraw(final Moves[][] gameBoard) {
        for (int y = 0; y < gameBoard.length; y++) {
            for (int x = 0; x < gameBoard[y].length; x++) {
                if (gameBoard[y][x] == Moves.NO_MOVE) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * ゲーム盤上の縦のラインで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の縦のラインで5連が達成されているかの真偽値
     */
    private boolean judgeRow(final Moves[][] gameBoard, final Moves moves) {

        final int maxLength = 5;

        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i][j + one] && moves == gameBoard[i][j + two] && moves == gameBoard[i][j + three] && moves == gameBoard[i][j + four]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * ゲーム盤上の横のラインで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の横のラインで5連が達成されているかの真偽値
     */
    private boolean judgeColumn(final Moves[][] gameBoard, final Moves moves) {

        final int maxLength = 5;

        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i + one][j] && moves == gameBoard[i + two][j] && moves == gameBoard[i + three][j] && moves == gameBoard[i + four][j]) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * ゲーム盤上の左斜めのラインで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の左斜めのラインで5連が達成されているかの真偽値
     */
    private boolean judgeLeftSlanting(final Moves[][] gameBoard, final Moves moves) {

        final int maxLength = 5;

        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;

        for (int i = 0; i < maxLength; i++) {
            if (moves == gameBoard[i][i] && moves == gameBoard[i + one][i + one] && moves == gameBoard[i + two][i + two] && moves == gameBoard[i + three][i + three] && moves == gameBoard[i + four][i + four]) {
                return true;
            }
        }

        return false;

    }

    /**
     * ゲーム盤上の右斜めのラインで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の右斜めのラインで5連が達成されているかの真偽値
     */
    private boolean judgeRightSlanting(final Moves[][] gameBoard, final Moves moves) {

        final int maxLength = 5;
        final int startNumber = 8;

        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;


        for (int i = startNumber; i > maxLength; i--) {
            for (int j = 0; j < maxLength; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i - one][j + one] && moves == gameBoard[i - two][j + two] && moves == gameBoard[i - three][j + three] && moves == gameBoard[i - four][j + four]) {
                    return true;
                }
            }
        }
        return false;

    }


}
