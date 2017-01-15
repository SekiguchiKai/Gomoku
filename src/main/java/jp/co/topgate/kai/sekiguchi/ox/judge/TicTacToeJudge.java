
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

    boolean judgeLose(final Moves[][] gameBoard) {

        return (gameBoard[0][0] == Moves.CPU_MOVE && gameBoard[0][1] == Moves.CPU_MOVE && gameBoard[0][2] == Moves.CPU_MOVE ||
                gameBoard[1][0] == Moves.CPU_MOVE && gameBoard[1][1] == Moves.CPU_MOVE && gameBoard[1][2] == Moves.CPU_MOVE ||
                gameBoard[2][0] == Moves.CPU_MOVE && gameBoard[2][1] == Moves.CPU_MOVE && gameBoard[2][2] == Moves.CPU_MOVE ||
                gameBoard[0][0] == Moves.CPU_MOVE && gameBoard[1][0] == Moves.CPU_MOVE && gameBoard[2][0] == Moves.CPU_MOVE ||
                gameBoard[0][1] == Moves.CPU_MOVE && gameBoard[1][1] == Moves.CPU_MOVE && gameBoard[2][1] == Moves.CPU_MOVE ||
                gameBoard[0][2] == Moves.CPU_MOVE && gameBoard[1][2] == Moves.CPU_MOVE && gameBoard[2][2] == Moves.CPU_MOVE ||
                gameBoard[0][0] == Moves.CPU_MOVE && gameBoard[1][1] == Moves.CPU_MOVE && gameBoard[2][2] == Moves.CPU_MOVE ||
                gameBoard[0][2] == Moves.CPU_MOVE && gameBoard[1][1] == Moves.CPU_MOVE && gameBoard[2][0] == Moves.CPU_MOVE
        );
    }

    /**
     * ユーザーが勝利しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利しているかの真偽値
     */

    private boolean judgeWin(final Moves[][] gameBoard) {

        return (gameBoard[0][0] == Moves.USER_MOVE && gameBoard[0][1] == Moves.USER_MOVE && gameBoard[0][2] == Moves.USER_MOVE ||
                gameBoard[1][0] == Moves.USER_MOVE && gameBoard[1][1] == Moves.USER_MOVE && gameBoard[1][2] == Moves.USER_MOVE ||
                gameBoard[2][0] == Moves.USER_MOVE && gameBoard[2][1] == Moves.USER_MOVE && gameBoard[2][2] == Moves.USER_MOVE ||
                gameBoard[0][0] == Moves.USER_MOVE && gameBoard[1][0] == Moves.USER_MOVE && gameBoard[2][0] == Moves.USER_MOVE ||
                gameBoard[0][1] == Moves.USER_MOVE && gameBoard[1][1] == Moves.USER_MOVE && gameBoard[2][1] == Moves.USER_MOVE ||
                gameBoard[0][2] == Moves.USER_MOVE && gameBoard[1][2] == Moves.USER_MOVE && gameBoard[2][2] == Moves.USER_MOVE ||
                gameBoard[0][0] == Moves.USER_MOVE && gameBoard[1][1] == Moves.USER_MOVE && gameBoard[2][2] == Moves.USER_MOVE ||
                gameBoard[0][2] == Moves.USER_MOVE && gameBoard[1][1] == Moves.USER_MOVE && gameBoard[2][0] == Moves.USER_MOVE
        );

    }
}