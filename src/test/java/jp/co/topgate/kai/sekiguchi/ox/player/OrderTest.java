package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.GomokuGameBoard;
import jp.co.topgate.kai.sekiguchi.ox.calculator.GomokuScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.io.GomokuCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.minimax.MiniMax;
import org.hamcrest.CoreMatchers;
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
    Board board = new GomokuGameBoard(9, 9);
    ScoreCalculator scoreCalculator = new GomokuScoreCalculator();
    MiniMax miniMax = new MiniMax(scoreCalculator);
    CommandLineIO commandLineIO = new GomokuCommandLineIO();


    Player user = new User(board, miniMax, commandLineIO, "user");
    Player cpu = new Cpu(board, miniMax, commandLineIO, "cpu");


    /**
     * setFirstPlayerメソッドをテストするためのメソッド
     */
    @Test
    public void setFirstPlayer() {
        this.order.setFirstPlayer(user);
        this.getFirstPlayer(user);

        this.order.setFirstPlayer(cpu);
        this.getFirstPlayer(cpu);
    }

    /**
     * setSecondPlayerメソッドをテストするためのメソッド
     */
    @Test
    public void setSecondPlayer() {
        this.order.setSecondPlayer(user);
        this.getSecondPlayer(user);

        this.order.setSecondPlayer(cpu);
        this.getSecondPlayer(cpu);

    }


    @Test
    public void setRandomOrder() {
        List<Player> firstPlayerList = new ArrayList<>();
        List<Player> secondPlayerList = new ArrayList<>();

        final int maxLength = 100;
        IntStream.range(0, maxLength).forEach(i -> {
            order.setRandomOrder(user, cpu);
            Player firstPlayer = order.getFirstPlayer();
            Player secondPlayer = order.getSecondPlayer();
            firstPlayerList.add(firstPlayer);
            secondPlayerList.add(secondPlayer);
        });

        assertThat(firstPlayerList, hasItems(user, cpu));
        assertThat(secondPlayerList, hasItems(user, cpu));


    }

    /**
     * getFirstPlayerメソッドをテストし、 setFirstPlayerメソッドをテストするためのメソッドを補助する
     *
     * @param expected
     */
    private void getFirstPlayer(Player expected) {
        Player actual = order.getFirstPlayer();
        assertThat(actual, is(expected));
    }


    /**
     * getSecondPlayerメソッドをテストし、 setSecondPlayerメソッドをテストするためのメソッドを補助する
     *
     * @param expected
     */
    private void getSecondPlayer(Player expected) {
        Player actual = order.getSecondPlayer();
        assertThat(actual, is(expected));
    }

}