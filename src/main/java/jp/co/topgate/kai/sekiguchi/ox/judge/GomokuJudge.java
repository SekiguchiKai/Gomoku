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
    public Result judgeResult(Board board) {

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
    boolean judgeLose(Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.CPU_MOVE) || this.judgeColumn(gameBoard, Moves.CPU_MOVE) || this.judgeLeftSlanting(gameBoard, Moves.CPU_MOVE) || this.judgeRightSlanting(gameBoard, Moves.CPU_MOVE);
    }

    /**
     * ユーザーが勝利しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利しているかの真偽値
     */

    boolean judgeWin(Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.USER_MOVE) || this.judgeColumn(gameBoard, Moves.USER_MOVE) || this.judgeLeftSlanting(gameBoard, Moves.USER_MOVE) || this.judgeRightSlanting(gameBoard, Moves.USER_MOVE);
    }

    boolean judgeDraw(Moves[][] gameBoard) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
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
    private boolean judgeRow(Moves[][] gameBoard, Moves moves) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i][j + 1] && moves == gameBoard[i][j + 2] && moves == gameBoard[i][j + 3] && moves == gameBoard[i][j + 4]) {
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
    private boolean judgeColumn(Moves[][] gameBoard, Moves moves) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i + 1][j] && moves == gameBoard[i + 2][j] && moves == gameBoard[i + 3][j] && moves == gameBoard[i + 4][j]) {
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
    private boolean judgeLeftSlanting(Moves[][] gameBoard, Moves moves) {
        for (int i = 0; i < 5; i++) {
            if (moves == gameBoard[i][i] && moves == gameBoard[i + 1][i + 1] && moves == gameBoard[i + 2][i + 2] && moves == gameBoard[i + 3][i + 3] && moves == gameBoard[i + 4][i + 4]) {
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
    private boolean judgeRightSlanting(Moves[][] gameBoard, Moves moves) {
        for (int i = 8; i > 5; i--) {
            for (int j = 0; j < 5; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i - 1][j + 1] && moves == gameBoard[i - 2][j + 2] && moves == gameBoard[i - 3][j + 3] && moves == gameBoard[i - 4][j + 4]) {
                    return true;
                }
            }
        }
        return false;

    }


}
