
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
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    public Result judgeResult(Board board) {

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

    boolean judgeLose(Moves[][] gameBoard) {

        return (gameBoard[0][0] == Moves.CROSS && gameBoard[0][1] == Moves.CROSS && gameBoard[0][2] == Moves.CROSS ||
                gameBoard[1][0] == Moves.CROSS && gameBoard[1][1] == Moves.CROSS && gameBoard[1][2] == Moves.CROSS ||
                gameBoard[2][0] == Moves.CROSS && gameBoard[2][1] == Moves.CROSS && gameBoard[2][2] == Moves.CROSS ||
                gameBoard[0][0] == Moves.CROSS && gameBoard[1][0] == Moves.CROSS && gameBoard[2][0] == Moves.CROSS ||
                gameBoard[0][1] == Moves.CROSS && gameBoard[1][1] == Moves.CROSS && gameBoard[2][1] == Moves.CROSS ||
                gameBoard[0][2] == Moves.CROSS && gameBoard[1][2] == Moves.CROSS && gameBoard[2][2] == Moves.CROSS ||
                gameBoard[0][0] == Moves.CROSS && gameBoard[1][1] == Moves.CROSS && gameBoard[2][2] == Moves.CROSS ||
                gameBoard[0][2] == Moves.CROSS && gameBoard[1][1] == Moves.CROSS && gameBoard[2][0] == Moves.CROSS
        );
    }

    /**
     * ユーザーが勝利しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利しているかの真偽値
     */

    private boolean judgeWin(Moves[][] gameBoard) {

        return (gameBoard[0][0] == Moves.CIRCLE && gameBoard[0][1] == Moves.CIRCLE && gameBoard[0][2] == Moves.CIRCLE ||
                gameBoard[1][0] == Moves.CIRCLE && gameBoard[1][1] == Moves.CIRCLE && gameBoard[1][2] == Moves.CIRCLE ||
                gameBoard[2][0] == Moves.CIRCLE && gameBoard[2][1] == Moves.CIRCLE && gameBoard[2][2] == Moves.CIRCLE ||
                gameBoard[0][0] == Moves.CIRCLE && gameBoard[1][0] == Moves.CIRCLE && gameBoard[2][0] == Moves.CIRCLE ||
                gameBoard[0][1] == Moves.CIRCLE && gameBoard[1][1] == Moves.CIRCLE && gameBoard[2][1] == Moves.CIRCLE ||
                gameBoard[0][2] == Moves.CIRCLE && gameBoard[1][2] == Moves.CIRCLE && gameBoard[2][2] == Moves.CIRCLE ||
                gameBoard[0][0] == Moves.CIRCLE && gameBoard[1][1] == Moves.CIRCLE && gameBoard[2][2] == Moves.CIRCLE ||
                gameBoard[0][2] == Moves.CIRCLE && gameBoard[1][1] == Moves.CIRCLE && gameBoard[2][0] == Moves.CIRCLE
        );

    }
}