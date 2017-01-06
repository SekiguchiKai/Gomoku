package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;


/**
 * 五目並べの勝敗結果を審査するためのクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class GomokuJudge implements Judgement {

    // 勝ち判定
    // 負け判定

    // たて
    // 横
    // 斜め

    // =>一個を固定し、もう一方をi++すれば良い

    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    public Result judgeResult(Board board) {
        Moves[][] gameBoard = board.getGameBoardState();

        if (this.judgeLose(gameBoard)) {
            return Result.LOSE;
        } else if (this.judgeWin(gameBoard)) {
            return Result.WIN;
        } else if (this.judgeDraw(gameBoard)) {
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
        for (int y = 0; y < GomokuGameBoard.Y; y++) {
            for (int x = 0; x < GomokuGameBoard.X; x++) {
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

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i + 1][j + 1] && moves == gameBoard[i + 2][j + 2] && moves == gameBoard[i + 3][j + 3] && moves == gameBoard[i + 4][j + 4]) {
                    return true;
                }
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
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 9; j++) {
                if (moves == gameBoard[i][j] && moves == gameBoard[i - 1][j + 1] && moves == gameBoard[i - 2][j + 2] && moves == gameBoard[i - 3][j + 3] && moves == gameBoard[i - 4][j + 4]) {
                    return true;
                }
            }
        }
        return false;

    }


}
