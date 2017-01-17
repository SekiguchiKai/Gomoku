
package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;

/**
 * 三目並べの勝敗結果を調べるクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class TicTacToeJudge implements Judge {

    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param board Boardクラスのインスタンス
     * @return 勝敗の結果
     */
    public Result judgeResult(final Board board) {

        Moves[][] gameBoard = board.getGameBoardState();

        if (this.judgeLose(gameBoard)) {
            return Result.LOSE;
        } else if (this.judgeWin(gameBoard)) {
            return Result.WIN;
        }

        for (int y = 0; y < board.getRowSize(); y++) {
            for (int x = 0; x < board.getRowSize(); x++) {
                if (gameBoard[y][x] == Moves.NO_MOVE) {
                    return Result.PENDING;
                }
            }
        }
        return Result.DRAW;


    }


    /**
     * ユーザーが敗北しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが敗北しているかの真偽値
     */
   private boolean judgeLose(final Moves[][] gameBoard) {

        return this.judgeRow(gameBoard, Moves.CPU_MOVE)
                || this.judgeColumn(gameBoard, Moves.CPU_MOVE)
                || this.judgeLeftSlanting(gameBoard, Moves.CPU_MOVE)
                || this.judgeRightSlanting(gameBoard, Moves.CPU_MOVE);

    }


    /**
     * ユーザーが勝利しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利しているかの真偽値
     */

    private boolean judgeWin(final Moves[][] gameBoard) {


        return this.judgeRow(gameBoard, Moves.USER_MOVE)
                || this.judgeColumn(gameBoard, Moves.USER_MOVE)
                || this.judgeLeftSlanting(gameBoard, Moves.USER_MOVE)
                || this.judgeRightSlanting(gameBoard, Moves.USER_MOVE);
    }

    /**
     * rowが同じ打ち手で揃っているかどうかを確認
     * rowで、3つ同じ打ち手が揃っている場合に、trueを返し、そうでない場合にはfalseを返す
     *
     * @return rowで、3つ同じ打ち手が揃っているかどうかの真偽値
     */
    private boolean judgeRow(final Moves[][] gameBoard, final Moves moves) {
        final int rowSize = 3;

        final int columnZero = 0;
        final int columnOne = 1;
        final int columnTwo = 2;

        for (int row = 0; row < rowSize; row++) {
            if (gameBoard[row][columnZero] == moves && gameBoard[row][columnOne] == moves && gameBoard[row][columnTwo] == moves) {
                return true;
            }
        }

        return false;
    }

    /**
     * columnが同じ打ち手で揃っているかどうかを確認
     * columnで、3つ同じ打ち手が揃っている場合に、trueを返し、そうでない場合にはfalseを返す
     *
     * @return columnで、3つ同じ打ち手が揃っているかどうかの真偽値
     */
    private boolean judgeColumn(final Moves[][] gameBoard, final Moves moves) {
        final int columnSize = 3;

        final int rowZero = 0;
        final int rowOne = 1;
        final int rowTwo = 2;


        for (int column = 0; column < columnSize; column++) {
            if (gameBoard[rowZero][column] == moves && gameBoard[rowOne][column] == moves && gameBoard[rowTwo][column] == moves) {
                return true;
            }
        }

        return false;
    }


    /**
     * 左斜めのラインが同じ打ち手で3つ揃っているかどうかを確認
     * 左斜めのラインで3つ同じ打ち手が揃っている場合に、trueを返し、そうでない場合にはfalseを返す
     *
     * @return 左斜めのラインで、3つ同じ打ち手が揃っているかどうかの真偽値
     */
    private boolean judgeLeftSlanting(final Moves[][] gameBoard, final Moves moves) {
        final int indexSize = 3;
        for (int index = 0; index < indexSize; index++) {
            if (gameBoard[index][index] != moves) {
                return false;
            }
        }
        return true;
    }

    /**
     * 右斜めのラインが同じ打ち手で3つ揃っているかどうかを確認
     * 右斜めのラインで3つ同じ打ち手が揃っている場合に、trueを返し、そうでない場合にはfalseを返す
     *
     * @return 右斜めのラインで、3つ同じ打ち手が揃っているかどうかの真偽値
     */
    private boolean judgeRightSlanting(final Moves[][] gameBoard, final Moves moves) {
        final int rowSize = 3;
        int column = 2;

        for (int row = 0; row < rowSize; row++) {
            if (gameBoard[row][column] != moves) {
                return false;
            }
            column--;
        }
        return true;
    }
}