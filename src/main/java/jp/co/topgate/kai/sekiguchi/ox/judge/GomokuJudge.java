package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;


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

        if (this.judgeWin(gameBoard)) {
            return Result.WIN;
        } else if (this.judgeLose(gameBoard)) {
            return Result.LOSE;
        } else if (this.judgeDraw(gameBoard)) {
            return Result.DRAW;
        }


        return Result.PENDING;
    }

    /**
     * ユーザーが勝利したかどうかを確認するためのメソッド
     * 縦、横、左斜め、右斜めを走査する
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利したかどうかの真偽値
     */
    private boolean judgeWin(final Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.CIRCLE) || this.judgeColumn(gameBoard, Moves.CIRCLE) || this.judgeLeftSlanting(gameBoard, Moves.CIRCLE) || this.judgeRightSlanting(gameBoard, Moves.CIRCLE);

    }


    /**
     * ユーザーが敗北したかどうかを確認するためのメソッド
     * 縦、横、左斜め、右斜めを走査する
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが敗北したかどうかの真偽値
     */
    private boolean judgeLose(final Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.CROSS) || this.judgeColumn(gameBoard, Moves.CROSS) || this.judgeLeftSlanting(gameBoard, Moves.CROSS) || this.judgeRightSlanting(gameBoard, Moves.CROSS);

    }


    /**
     * 引き分けかどうかを確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 引き分けかどうかの真偽値
     */
    private boolean judgeDraw(final Moves[][] gameBoard) {
        final int maxLength = 9;

        for (int row = 0; row < maxLength; row++) {
            for (int column = 0; column < maxLength; column++) {
                if ((this.judgeWin(gameBoard)) || (this.judgeLose(gameBoard)) || (gameBoard[row][column] == Moves.NO_MOVE)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * row(横のライン)が引数で指定されたMoveで5連が達成されているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean judgeRow(final Moves[][] gameBoard, final Moves moves) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 5; column++) {
                Moves[][] target = gameBoard;
                if (gameBoard[row][column] == moves && gameBoard[row][column + 1] == moves && gameBoard[row][column + 2] == moves && gameBoard[row][column + 3] == moves && gameBoard[row][column + 4] == moves) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * column(縦のライン)が引数で指定されたMoveで5連が達成されているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean judgeColumn(final Moves[][] gameBoard, final Moves moves) {
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 5; row++) {
                Moves[][] target = gameBoard;
                if (gameBoard[row][column] == moves && gameBoard[row + 1][column] == moves && gameBoard[row + 2][column] == moves && gameBoard[row + 3][column] == moves && gameBoard[row + 4][column] == moves) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 左斜めのラインが引数で指定されたMoveで5連が達成されているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean judgeLeftSlanting(final Moves[][] gameBoard, final Moves moves) {

        boolean result;

        for (int startIndex = 0; startIndex < 5; startIndex++) {
            result = this.judgeLeftSlantingHelper(gameBoard, moves, startIndex);

            if (result) {
                return result;
            }
        }

        return false;

    }

    /**
     * 引数で受け取った各左斜めのラインについて、指定されたMoveで5連が達成されているか確認するためのメソッド
     *
     * @param gameBoard  ゲーム盤
     * @param moves      検査対象のプレーヤーの打ち手
     * @param startIndex rowとcolumnのインデックスの開始値
     * @return 勝敗が決定したか真偽値
     */
    private boolean judgeLeftSlantingHelper(final Moves[][] gameBoard, final Moves moves, final int startIndex) {

        for (int index = 0; index < 5; index++) {
            if (gameBoard[index][index] == moves && gameBoard[index + 1][index + 1] == moves && gameBoard[index + 2][index + 2] == moves && gameBoard[index + 3][index + 3] == moves && gameBoard[index + 4][index + 4] == moves) {
                return true;
            }
        }
        return false;
    }


    /**
     * 左斜めのラインが引数で指定されたMoveで5連が達成されているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean judgeRightSlanting(final Moves[][] gameBoard, final Moves moves) {

        int column = 8;


        // for文1回で、1つの連を表す
        for (int row = 0; row < 5; row++) {
            if (gameBoard[row][column] == moves && gameBoard[row + 1][column - 1] == moves && gameBoard[row + 2][column - 2] == moves && gameBoard[row + 3][column - 3] == moves && gameBoard[row + 4][column - 4] == moves) {
                return true;
            }
            column--;
        }
        return false;

    }


}

