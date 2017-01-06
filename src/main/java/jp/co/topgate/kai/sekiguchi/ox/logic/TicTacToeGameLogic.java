package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.judge.TicTacToeJudge;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;



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
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();


        ticTacToeCommandLineIO.drawUI(ticTacToeBoard);

        int depthCount = 2;


        while (ticTacToeJudge.judgeResult(ticTacToeBoard) == Result.PENDING) {

            user.doMove(depthCount);


            if (ticTacToeJudge.judgeResult(ticTacToeBoard) == Result.PENDING) {
                cpu.doMove(depthCount);
            }

        }
        ticTacToeCommandLineIO.drawResult(ticTacToeJudge.judgeResult(ticTacToeBoard));
    }
}




