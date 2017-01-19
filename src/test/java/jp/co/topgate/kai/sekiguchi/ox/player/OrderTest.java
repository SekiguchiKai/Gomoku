package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Orderクラスをテストするためのクラス
 * Created by sekiguchikai on 2017/01/11.
 */
public class OrderTest {
    @Test
    public void setSequentialRandomList() {
        final int rowSize = 9;
        final int columnSize = 9;
        final int judgeCriteriaSequence = 5;

        final int maxPoint = 50;
        final int minPoint = -50;


        Order order = new Order();
        Board board = new Board(9, 9);
        ScoreCalculator scoreCalculator = new ScoreCalculator(rowSize, columnSize, judgeCriteriaSequence, maxPoint, minPoint);
        MiniMax miniMax = new MiniMax(scoreCalculator);
        CommandLineIO commandLineIO = new CommandLineIO();


        Player user = new User(board, miniMax, commandLineIO, "user");
        Player cpu = new Cpu(board, miniMax, commandLineIO, "cpu");

        List<Player> nextPlayerList = new ArrayList<>();

        final int moveMaxNumber = 83;

        order.setSequentialRandomList(moveMaxNumber, user, cpu);


        IntStream.range(0, 81).forEach(i -> {
            Player nextPlayer = order.getNextPlayer();

            nextPlayerList.add(nextPlayer);
        });

        assertThat(nextPlayerList, hasItems(user, cpu));
    }
}