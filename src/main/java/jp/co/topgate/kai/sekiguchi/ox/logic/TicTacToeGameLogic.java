package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.judge.Judge;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
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

        final int rowSize = 3;
        final int columnSize = 3;
        final int judgeCriteriaSequence = 3;

        final int maxPoint = 30;
        final int minPoint = -30;

        final Board board = new Board(rowSize, columnSize);
        final CommandLineIO commandLineIO = new CommandLineIO();

        final ScoreCalculator scoreCalculator = new ScoreCalculator(rowSize, columnSize, judgeCriteriaSequence, maxPoint, minPoint);

        final MiniMax miniMax = new MiniMax(scoreCalculator);
        final Player user = new User(board, miniMax, commandLineIO, "あなた");
        final Player cpu = new Cpu(board, miniMax, commandLineIO, "AI");
        final Judge ticTacToeJudge = new Judge(rowSize, columnSize, judgeCriteriaSequence);


        commandLineIO.drawUI(board);

        final int depthCount = 2;


        while (ticTacToeJudge.judgeResult(board) == Result.PENDING) {
            user.doMove(depthCount);

            if (ticTacToeJudge.judgeResult(board) == Result.PENDING) {
                cpu.doMove(depthCount);
            }
        }
        commandLineIO.drawResult(ticTacToeJudge.judgeResult(board));
    }
}

