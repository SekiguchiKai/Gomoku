package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;

import java.util.*;


/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class TicTacToeGameLogic implements GameLogic {
    // とりあえず user= ○, cpu= ×

    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    @Override
    public void playGame() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        TicTacToeCommandLineIO ticTacToeCommandLineIO = new TicTacToeCommandLineIO();
        MinMaxCalculator minMaxCalculator = new MinMaxCalculator();
        Player user = new User(ticTacToeBoard, minMaxCalculator, ticTacToeCommandLineIO);
        Player cpu = new Cpu(ticTacToeBoard, minMaxCalculator, ticTacToeCommandLineIO);


        ticTacToeCommandLineIO.drawBoard(ticTacToeBoard);

        int depthCount = 2;


        while (this.judgeResult(ticTacToeBoard.getGameBoardState()) == Result.PENDING) {

            user.doMove(depthCount);


            if (this.judgeResult(ticTacToeBoard.getGameBoardState()) == Result.PENDING) {
                cpu.doMove(depthCount);
            }

        }
        ticTacToeCommandLineIO.drawResult(this.judgeResult(ticTacToeBoard.getGameBoardState()));
    }


    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    Result judgeResult(Moves[] gameBoard) {

        if (this.judgeLose(gameBoard)) {
            return Result.LOSE;
        } else if (this.judgeWin(gameBoard)) {
            return Result.WIN;
        }

        List<Moves> gameBoardList = Arrays.asList(gameBoard);

        if (!gameBoardList.contains(Moves.NO_MOVE)) {
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

    private boolean judgeLose(Moves[] gameBoard) {

        return (gameBoard[0] == Moves.CPU_MOVE && gameBoard[1] == Moves.CPU_MOVE && gameBoard[2] == Moves.CPU_MOVE ||
                gameBoard[3] == Moves.CPU_MOVE && gameBoard[4] == Moves.CPU_MOVE && gameBoard[5] == Moves.CPU_MOVE ||
                gameBoard[6] == Moves.CPU_MOVE && gameBoard[7] == Moves.CPU_MOVE && gameBoard[8] == Moves.CPU_MOVE ||
                gameBoard[0] == Moves.CPU_MOVE && gameBoard[3] == Moves.CPU_MOVE && gameBoard[6] == Moves.CPU_MOVE ||
                gameBoard[1] == Moves.CPU_MOVE && gameBoard[4] == Moves.CPU_MOVE && gameBoard[7] == Moves.CPU_MOVE ||
                gameBoard[2] == Moves.CPU_MOVE && gameBoard[5] == Moves.CPU_MOVE && gameBoard[8] == Moves.CPU_MOVE ||
                gameBoard[0] == Moves.CPU_MOVE && gameBoard[4] == Moves.CPU_MOVE && gameBoard[8] == Moves.CPU_MOVE ||
                gameBoard[2] == Moves.CPU_MOVE && gameBoard[4] == Moves.CPU_MOVE && gameBoard[6] == Moves.CPU_MOVE
        );
    }

    /**
     * ユーザーが勝利しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利しているかの真偽値
     */

    private boolean judgeWin(Moves[] gameBoard) {

        return (gameBoard[0] == Moves.USER_MOVE && gameBoard[1] == Moves.USER_MOVE && gameBoard[2] == Moves.USER_MOVE ||
                gameBoard[3] == Moves.USER_MOVE && gameBoard[4] == Moves.USER_MOVE && gameBoard[5] == Moves.USER_MOVE ||
                gameBoard[6] == Moves.USER_MOVE && gameBoard[7] == Moves.USER_MOVE && gameBoard[8] == Moves.USER_MOVE ||
                gameBoard[0] == Moves.USER_MOVE && gameBoard[3] == Moves.USER_MOVE && gameBoard[6] == Moves.USER_MOVE ||
                gameBoard[1] == Moves.USER_MOVE && gameBoard[4] == Moves.USER_MOVE && gameBoard[7] == Moves.USER_MOVE ||
                gameBoard[2] == Moves.USER_MOVE && gameBoard[5] == Moves.USER_MOVE && gameBoard[8] == Moves.USER_MOVE ||
                gameBoard[0] == Moves.USER_MOVE && gameBoard[4] == Moves.USER_MOVE && gameBoard[8] == Moves.USER_MOVE ||
                gameBoard[2] == Moves.USER_MOVE && gameBoard[4] == Moves.USER_MOVE && gameBoard[6] == Moves.USER_MOVE
        );

    }


}




