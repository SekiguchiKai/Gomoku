package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.judge.Judge;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
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

        CommandLineIO commandLineIO = new CommandLineIO();

        final int rowSize = 9;
        final int columnSize = 9;
        final int judgeCriteriaSequence = 5;

        final int maxPoint = 50;
        final int minPoint = -50;

        final Board board = new Board(rowSize, columnSize);

        commandLineIO.drawUI(board);

        final ScoreCalculator scoreCalculator = new ScoreCalculator(rowSize, columnSize, judgeCriteriaSequence, maxPoint, minPoint);

        final MiniMax miniMax = new MiniMax(scoreCalculator);
        final Player user = new User(board, miniMax, commandLineIO, "あなた");
        final Player cpu = new Cpu(board, miniMax, commandLineIO, "AI");


        final Judge gomokuJudge = new Judge(rowSize, columnSize, judgeCriteriaSequence);
        final int depthCount = 3;
        Order order = new Order();

        final int movesMaxNumber = 83;

        order.setSequentialRandomList(movesMaxNumber, user, cpu);

        while (gomokuJudge.judgeResult(board) == Result.PENDING) {


//            Player firstPlayer = order.getNextPlayer();
//            Player secondPlayer = order.getNextPlayer();

            Player firstPlayer = user;
            Player secondPlayer = user;


            System.out.println(firstPlayer.getName() + "の番です");
            firstPlayer.doMove(depthCount);

            if (gomokuJudge.judgeResult(board) == Result.PENDING) {
                System.out.println(secondPlayer.getName() + "の番です");
                secondPlayer.doMove(depthCount);
            }
        }
        commandLineIO.drawResult(gomokuJudge.judgeResult(board));
    }

}