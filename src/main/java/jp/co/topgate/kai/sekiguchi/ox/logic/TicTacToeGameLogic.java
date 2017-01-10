package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.TicTacToeScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.io.TicTacToeCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.judge.Judgement;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;


/**
 * 三目並べのゲームの処理を進めていくクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class TicTacToeGameLogic extends GameLogic {
    // とりあえず user= ○, cpu= ×

    /**
     * ゲームを進めていくロジックを担当するメソッド
     *
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    @Override
    public void playGame() {

        final int row = 3;
        final int column = 3;

        Board ticTacToeBoard = new TicTacToeBoard(row, column);
        TicTacToeCommandLineIO ticTacToeCommandLineIO = new TicTacToeCommandLineIO();

        ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();

        MiniMax miniMax = new MiniMax(ticTacToeScoreCalculator);
        Player user = new User(ticTacToeBoard, miniMax, ticTacToeCommandLineIO, "あなた");
        Player cpu = new Cpu(ticTacToeBoard, miniMax, ticTacToeCommandLineIO, "AI");
        Judgement judgement = new Judgement(ticTacToeBoard, ticTacToeScoreCalculator);


        ticTacToeCommandLineIO.drawUI(ticTacToeBoard);

        final int depthCount = 2;

        final int judgeHighSore = 300;
        final int judgeLowSore = -300;


        while (judgement.judgeResult(judgeHighSore, judgeLowSore) == Result.PENDING) {

            user.doMove(depthCount);


            if (judgement.judgeResult(judgeHighSore, judgeLowSore) == Result.PENDING) {
                cpu.doMove(depthCount);
            }

        }
        ticTacToeCommandLineIO.drawResult(judgement.judgeResult(judgeHighSore, judgeLowSore));
    }
}




