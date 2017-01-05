package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;

import java.io.IOException;

/**
 * ユーザーの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class User extends Player {

    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param ticTacToeBoard ゲーム盤
     */
    public User(TicTacToeBoard ticTacToeBoard, MinMaxCalculator minMaxCalculator, TicTacToeCommandLineIO ticTacToeCommandLineIO) {
        super(ticTacToeBoard, minMaxCalculator, ticTacToeCommandLineIO);
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    @Override
    public void doMove(int depth) {
        try {
            int userInput = ticTacToeCommandLineIO.receiveCommand(ticTacToeBoard.getGameBoardState());
            this.choiceDO(userInput);

            while (userInput == Integer.MAX_VALUE || userInput == Integer.MIN_VALUE) {
                userInput = ticTacToeCommandLineIO.receiveCommand(ticTacToeBoard.getGameBoardState());
                this.choiceDO(userInput);
            }

        } catch (IOException e) {
            System.err.println("エラー:" + e.getMessage());
            e.printStackTrace();
        }
        ticTacToeCommandLineIO.drawBoard(ticTacToeBoard);

    }

    /**
     * ユーザーの入力によって、Userが行うことを決める
     *
     * @param userInput ユーザの入力の値
     */
    private void choiceDO(int userInput) {
        if (userInput == Integer.MAX_VALUE) {
            ticTacToeCommandLineIO.drawExistingCaution();
        } else if (userInput == Integer.MIN_VALUE) {
            ticTacToeCommandLineIO.drawInappropriateCaution();
        } else {
            ticTacToeBoard.putMoves(userInput, Moves.USER_MOVE);
        }
    }
}
