package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.GomokuScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.judge.Judgement;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.io.GomokuCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Order;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;

import java.io.IOException;

/**
 * 五目並べのゲームの処理を進めていくクラス
 * Created by sekiguchikai on 2017/01/05.
 */
public class GomokuGameLogic extends GameLogic {
    /**
     * ゲームを進めていくロジックを担当するメソッド
     *
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    @Override
    public void playGame() throws IOException {
        System.out.println("五目並べ");

        GomokuCommandLineIO gomokuCommandLineIO = new GomokuCommandLineIO();

        final int row = 9;
        final int column = 9;

        Board gomokuGameBoard = new GomokuGameBoard(row, column);

        gomokuCommandLineIO.drawUI(gomokuGameBoard);

        ScoreCalculator gomokuScoreCalculator = new GomokuScoreCalculator();

        MiniMax miniMax = new MiniMax(gomokuScoreCalculator);
        Player user = new User(gomokuGameBoard, miniMax, gomokuCommandLineIO, "あなた");
        Player cpu = new Cpu(gomokuGameBoard, miniMax, gomokuCommandLineIO, "AI");

        Judgement judgement = new Judgement(gomokuGameBoard, gomokuScoreCalculator);
        final int depthCount = 3;


        final int judgeHighSore = 500;
        final int judgeLowSore = -500;

        while (judgement.judgeResult(judgeHighSore, judgeLowSore) == Result.PENDING) {

            Order order = super.setOrder(cpu, user);

            Player firstPlayer = order.getFirstPlayer();
            Player secondPlayer = order.getSecondPlayer();


            System.out.println(firstPlayer.getName() + "の番です");
            firstPlayer.doMove(depthCount);

            if (judgement.judgeResult(judgeHighSore, judgeLowSore) == Result.PENDING) {
                System.out.println(secondPlayer.getName() + "の番です");
                secondPlayer.doMove(depthCount);
            }
        }
        gomokuCommandLineIO.drawResult(judgement.judgeResult(judgeHighSore, judgeLowSore));
    }

}
