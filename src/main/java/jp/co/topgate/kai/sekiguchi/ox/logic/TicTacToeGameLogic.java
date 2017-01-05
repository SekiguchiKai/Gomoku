package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;

import java.util.*;
import java.util.stream.IntStream;


/**
 * 三目並べのゲームの処理を進めていくクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class TicTacToeGameLogic implements GameLogic {
    // とりあえず user= ○, cpu= ×

    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    @Override
    public void playGame() {
        Board ticTacToeBoard = new TicTacToeBoard();
        TicTacToeCommandLineIO ticTacToeCommandLineIO = new TicTacToeCommandLineIO();
        MinMaxCalculator minMaxCalculator = new MinMaxCalculator();
        Player user = new User(ticTacToeBoard, minMaxCalculator, ticTacToeCommandLineIO);
        Player cpu = new Cpu(ticTacToeBoard, minMaxCalculator, ticTacToeCommandLineIO);


        ticTacToeCommandLineIO.drawUI(ticTacToeBoard);

        int depthCount = 2;


        while (this.judgeResult(ticTacToeBoard) == Result.PENDING) {

            user.doMove(depthCount);


            if (this.judgeResult(ticTacToeBoard) == Result.PENDING) {
                cpu.doMove(depthCount);
            }

        }
        ticTacToeCommandLineIO.drawResult(this.judgeResult(ticTacToeBoard));
    }


    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    Result judgeResult(Board board) {

        Moves[][] gameBoard = board.getGameBoardState();

        if (this.judgeLose(gameBoard)) {
            return Result.LOSE;
        } else if (this.judgeWin(gameBoard)) {
            return Result.WIN;
        }

        for (int y = 0; y < board.getYLength(); y++) {
            for (int x = 0; x < board.getYLength(); x++) {
                if (gameBoard[y][x] != Moves.NO_MOVE) {
                    return Result.DRAW;
                }
            }
        }

        return Result.PENDING;
    }


    /**
     * ユーザーが敗北しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが敗北しているかの真偽値
     */

    private boolean judgeLose(Moves[][] gameBoard) {

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

    private boolean judgeWin(Moves[][] gameBoard) {

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




