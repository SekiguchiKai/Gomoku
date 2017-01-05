package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.io.GomokuCommandLineIO;

import java.io.IOException;

/**
 * 五目並べのゲームの処理を進めていくクラス
 * Created by sekiguchikai on 2017/01/05.
 */
public class GomokuGameLogic implements GameLogic {
    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    public void playGame() throws IOException{
        System.out.println("五目並べ");

        GomokuCommandLineIO gomokuCommandLineIO = new GomokuCommandLineIO();
        Board gomokuGameBoard = new GomokuGameBoard();
        gomokuCommandLineIO.drawUI(gomokuGameBoard);
        gomokuCommandLineIO.receiveCommand(gomokuGameBoard.getGameBoardState());

    }

}
