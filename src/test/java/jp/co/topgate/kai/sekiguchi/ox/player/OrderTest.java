package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.GomokuScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.io.GomokuCommandLineIO;
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
    Order order = new Order();
    Board board = new GomokuBoard(9, 9);
    ScoreCalculator scoreCalculator = new GomokuScoreCalculator();
    MiniMax miniMax = new MiniMax(scoreCalculator);
    CommandLineIO commandLineIO = new GomokuCommandLineIO();


    Player user = new User(board, miniMax, commandLineIO, "user");
    Player cpu = new Cpu(board, miniMax, commandLineIO, "cpu");


    @Test
    public void setSequentialRandomList() {
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