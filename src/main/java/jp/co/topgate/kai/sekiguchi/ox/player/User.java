package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.Cell;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;


import java.io.IOException;

/**
 * ユーザーの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class User extends Player {

    /**
     * コンストラクタ
     * フィールドを初期化する
     *
     * @param board         Boardクラスのインスタンス
     * @param miniMax       MinMaxクラスのインスタンス
     * @param commandLineIO CommandLineIO クラスのインスタンス
     * @param name          プレーヤーの名前を表す
     */
    public User(final Board board, final MiniMax miniMax, final CommandLineIO commandLineIO, final String name) {
        super(board, miniMax, commandLineIO, name);
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    @Override
    public void doMove(final int depth) {
        try {
            Cell userInput = commandLineIO.receiveCommand(board);
            this.choiceDO(userInput);

            while (userInput.getCellRow() == Integer.MAX_VALUE && userInput.getCellColumn() == Integer.MAX_VALUE || userInput.getCellRow() == Integer.MIN_VALUE && userInput.getCellColumn() == Integer.MIN_VALUE) {
                userInput = commandLineIO.receiveCommand(board);
                this.choiceDO(userInput);
            }

        } catch (IOException e) {
            System.err.println("エラー:" + e.getMessage());
            e.printStackTrace();
        }
        commandLineIO.drawUI(board);


    }

    /**
     * ユーザーの入力によって、Userが行うことを決める
     *
     * @param userInput ユーザの入力の値
     */
    private void choiceDO(final Cell userInput) {
        if (userInput.getCellRow() == Integer.MAX_VALUE && userInput.getCellColumn() == Integer.MAX_VALUE) {
            commandLineIO.drawExistingCaution();
        } else if (userInput.getCellRow() == Integer.MIN_VALUE && userInput.getCellColumn() == Integer.MIN_VALUE) {
            commandLineIO.drawInappropriateCaution();
        } else {
            board.putMoves(userInput.getCellRow(), userInput.getCellColumn(), Moves.USER_MOVE);
        }
    }
}