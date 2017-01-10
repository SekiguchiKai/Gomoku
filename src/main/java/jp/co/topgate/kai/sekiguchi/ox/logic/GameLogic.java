package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Order;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;

import java.io.IOException;
import java.util.Map;

/**
 * 各ゲームロジックの継承元
 * Created by sekiguchikai on 2016/12/20.
 */
public abstract class GameLogic {

    /**
     * ゲームを進めていくロジックを担当するメソッド
     *
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    public abstract void playGame() throws IOException;


    /**
     * 各プレーヤーの打ち手の順番を決める
     *
     * @param user Userクラスのインスタンス
     * @param cpu  Cpuクラスのインスタンス
     * @return Orderクラスのインスタンス
     */
    public Order setOrder(final Player user, final Player cpu) {
        int userOrder = (int) (Math.random() * 2) + 1;

        if (userOrder == 1) {
            return new Order(user, cpu);
        }
        return new Order(cpu, user);

    }


}
