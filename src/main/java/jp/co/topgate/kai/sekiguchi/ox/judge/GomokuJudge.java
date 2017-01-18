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
        final int maxSize = 9;

        for (int row = 0; row < maxSize; row++) {
            for (int column = 0; column < maxSize; column++) {
                if (this.judgeWin(gameBoard) || this.judgeLose(gameBoard) || gameBoard[row][column] == Moves.EMPTY) {
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
        final int differenceOne = 1;
        final int differenceTwo = 2;
        final int differenceThree = 3;
        final int differenceFour = 4;

        final int rowSize = 9;
        final int columnMax = 5;

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnMax; column++) {
                Moves[][] target = gameBoard;
                if (gameBoard[row][column] == moves && gameBoard[row][column + differenceOne] == moves && gameBoard[row][column + differenceTwo] == moves && gameBoard[row][column + differenceThree] == moves && gameBoard[row][column + differenceFour] == moves) {
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
        final int differenceOne = 1;
        final int differenceTwo = 2;
        final int differenceThree = 3;
        final int differenceFour = 4;

        final int columnSize = 9;
        final int rowMax = 5;

        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowMax; row++) {
                Moves[][] target = gameBoard;
                if (gameBoard[row][column] == moves && gameBoard[row + differenceOne][column] == moves && gameBoard[row + differenceTwo][column] == moves && gameBoard[row + differenceThree][column] == moves && gameBoard[row + differenceFour][column] == moves) {
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
        final int differenceOne = 1;
        final int differenceTwo = 2;
        final int differenceThree = 3;
        final int differenceFour = 4;

        final int indexMax = 5;

        for (int index = 0; index < indexMax; index++) {
            if (gameBoard[index][index] == moves && gameBoard[index + differenceOne][index + differenceOne] == moves && gameBoard[index + differenceTwo][index + differenceTwo] == moves && gameBoard[index + differenceThree][index + differenceThree] == moves && gameBoard[index + differenceFour][index + differenceFour] == moves) {
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

        final int differenceOne = 1;
        final int differenceTwo = 2;
        final int differenceThree = 3;
        final int differenceFour = 4;

        int column = 8;
        final int rowMax = 5;


        // for文1回で、1つの連を表す
        for (int row = 0; row < rowMax; row++) {
            if (gameBoard[row][column] == moves && gameBoard[row + differenceOne][column - differenceOne] == moves && gameBoard[row + differenceTwo][column - differenceTwo] == moves && gameBoard[row + differenceThree][column - differenceThree] == moves && gameBoard[row + differenceFour][column - differenceFour] == moves) {
                return true;
            }
            column--;
        }
        return false;

    }


}

