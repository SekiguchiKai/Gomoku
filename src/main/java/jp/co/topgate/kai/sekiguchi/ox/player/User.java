package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.minimax.Cell;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;


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
            InputState userInputState = commandLineIO.receiveCommand(board);
            Cell userInput = commandLineIO.getCell();
            this.choiceDo(userInputState, userInput);


            commandLineIO.drawUI(board);

            while (userInputState != InputState.APPROPRIATE) {
                userInputState = commandLineIO.receiveCommand(board);
                userInput = commandLineIO.getCell();
                this.choiceDo(userInputState, userInput);

                commandLineIO.drawUI(board);
            }

        } catch (IOException e) {
            System.err.println("エラー:" + e.getMessage());
            e.printStackTrace();
        }


    }

    /**
     * ユーザーの入力によって、Userが行うことを決める
     *
     * @param userInputState ユーザーの入力の状態
     * @param userInput      ユーザの入力の値
     */
    private void choiceDo(final InputState userInputState, final Cell userInput) {

        if (userInputState == InputState.NOT_EMPTY) {
            commandLineIO.drawExistingCaution();
        } else if (userInputState == InputState.INAPPROPRIATE_NUMBER) {
            commandLineIO.drawInappropriateCaution();
        } else if (userInputState == InputState.NOT_NUMBER) {
            commandLineIO.drawhalfWidthDigitCaution();
        } else {
            board.putMoves(userInput.getCellRow(), userInput.getCellColumn(), Moves.CIRCLE);
        }
    }
}
