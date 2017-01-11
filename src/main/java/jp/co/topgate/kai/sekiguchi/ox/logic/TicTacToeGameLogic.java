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

        final Board ticTacToeBoard = new TicTacToeBoard(row, column);
        final TicTacToeCommandLineIO ticTacToeCommandLineIO = new TicTacToeCommandLineIO();

        final ScoreCalculator ticTacToeScoreCalculator = new TicTacToeScoreCalculator();

        final MiniMax miniMax = new MiniMax(ticTacToeScoreCalculator);
        final Player user = new User(ticTacToeBoard, miniMax, ticTacToeCommandLineIO, "あなた");
        final Player cpu = new Cpu(ticTacToeBoard, miniMax, ticTacToeCommandLineIO, "AI");
        final Judgement judgement = new Judgement(ticTacToeBoard, ticTacToeScoreCalculator);


        ticTacToeCommandLineIO.drawUI(ticTacToeBoard);

        final int depthCount = 2;


        while (judgement.judgeResult() == Result.PENDING) {
            user.doMove(depthCount);

            if (judgement.judgeResult() == Result.PENDING) {
                cpu.doMove(depthCount);
            }
        }
        ticTacToeCommandLineIO.drawResult(judgement.judgeResult());
    }
}
