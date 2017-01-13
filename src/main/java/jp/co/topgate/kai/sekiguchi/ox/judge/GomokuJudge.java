package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;

import java.util.stream.IntStream;


/**
 * 五目並べの勝敗結果を審査するためのクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class GomokuJudge implements Judge {


    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param board Boardクラスのインスランス
     * @return 勝敗の結果
     */
    public Result judgeResult(final Board board) {
        Moves[][] gameBoard = board.getGameBoardState();

        if (this.judgeWinLose(gameBoard, Moves.CPU_MOVE)) {
            return Result.LOSE;
        } else if (this.judgeWinLose(gameBoard, Moves.USER_MOVE)) {
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
    boolean judgeWinLose(Moves[][] gameBoard, Moves moves) {
        boolean result;

        int endNum = 5;
        int innerEndNum = 5;
        // row
        for (int startNum = 0; startNum < endNum; startNum++) {
            result = this.judgeRow(gameBoard, moves, startNum, innerEndNum);
            if (result) {
                return result;
            }
            innerEndNum++;
        }

        endNum = 5;
        innerEndNum = 5;
        // column
        for (int startNum = 0; startNum < endNum; startNum++) {
            result = this.judgeColumn(gameBoard, moves, startNum, innerEndNum);
            if (result) {
                return result;
            }
            innerEndNum++;
        }

        endNum = 5;
        innerEndNum = 5;
        // LeftSlanting
        for (int startNum = 0; startNum < endNum; startNum++) {
            result = this.judgeLeftSlanting(gameBoard, moves, startNum, innerEndNum);
            if (result) {
                return result;
            }
            innerEndNum++;
        }

        endNum = 5;
        innerEndNum = 9;
        int column = 8;
        // 右斜め
        for (int startNum = 0; startNum < endNum; startNum++) {
            result = this.judgeRightSlanting(gameBoard, moves, startNum, innerEndNum, column);
            if (result) {
                return result;
            }
            innerEndNum--;
            column--;
        }

        return false;


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
     * ゲーム盤上のRowで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の行で5連が達成されているかの真偽値
     */
    private boolean judgeRow(final Moves[][] gameBoard, final Moves moves, final int startNum, final int endNum) {
        final int maxLength = 9;
        for (int row = 0; row < maxLength; row++) {
            for (int column = startNum; column < endNum; column++) {
                if (gameBoard[row][column] != moves) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * ゲーム盤上のColumnで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の横のラインで5連が達成されているかの真偽値
     */
    private boolean judgeColumn(final Moves[][] gameBoard, final Moves moves, final int startNum, final int endNum) {
        final int maxLength = 9;
        for (int column = 0; column < maxLength; column++) {
            for (int row = startNum; row < endNum; row++) {
                if (gameBoard[row][column] != moves) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * ゲーム盤上の左斜めのラインで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の左斜めのラインで5連が達成されているかの真偽値
     */
    private boolean judgeLeftSlanting(final Moves[][] gameBoard, final Moves moves, final int startNum, final int endNum) {
        for (int i = startNum; i < endNum; i++) {
            if (gameBoard[i][i] != moves) {
                return false;
            }
        }

        return true;

    }

    /**
     * ゲーム盤上の右斜めのラインで5連が達成されているかを審査するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ゲーム盤上の右斜めのラインで5連が達成されているかの真偽値
     */
    private boolean judgeRightSlanting(final Moves[][] gameBoard, final Moves moves, final int startNum, final int endNum, int column) {

        for (int row = startNum; row < endNum; row++) {
            if (gameBoard[row][column] != moves) {
                return false;
            }
            column--;

        }
        return true;

    }


}