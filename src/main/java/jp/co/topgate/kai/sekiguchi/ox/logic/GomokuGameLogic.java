package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.io.GomokuCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.judge.GomokuJudge;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;

import java.io.IOException;

/**
 * 五目並べのゲームの処理を進めていくクラス
 * Created by sekiguchikai on 2017/01/05.
 */
public class GomokuGameLogic implements GameLogic {
    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    public void playGame() throws IOException {
        System.out.println("五目並べ");

        GomokuCommandLineIO gomokuCommandLineIO = new GomokuCommandLineIO();
        Board gomokuGameBoard = new GomokuGameBoard();

        gomokuCommandLineIO.drawUI(gomokuGameBoard);
        gomokuCommandLineIO.receiveCommand(gomokuGameBoard);

        MinMaxCalculator minMaxCalculator = new MinMaxCalculator();
        Player user = new User(gomokuGameBoard, minMaxCalculator, gomokuCommandLineIO);
        Player cpu = new Cpu(gomokuGameBoard, minMaxCalculator, gomokuCommandLineIO);

        GomokuJudge gomokuJudge = new GomokuJudge();


        int depthCount = 2;


        while (gomokuJudge.judgeResult(gomokuGameBoard) == Result.PENDING) {

            user.doMove(depthCount);

            if (gomokuJudge.judgeResult(gomokuGameBoard) == Result.PENDING) {
                cpu.doMove(depthCount);
            }
        }
        gomokuCommandLineIO.drawResult(gomokuJudge.judgeResult(gomokuGameBoard));

    }

}
