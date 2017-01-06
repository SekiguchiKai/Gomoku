package jp.co.topgate.kai.sekiguchi.ox.player;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.org.apache.xpath.internal.operations.Plus;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

/**
 * 順番を扱うクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class Order {

    /**
     * 最初のプレーヤー
     */
    private Player firstPlayer;

    /**
     * 2番目のプレーヤー
     */
    private Player secondPlayer;

    /**
     * コンストラクタ
     *
     * @param firstPlayer  最初のプレーヤー
     * @param secondPlayer 2番目のプレーヤー
     */
    public Order(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }


    /**
     * firstPlayerを設定するためのメソッド
     *
     * @param firstPlayer Playerのインスタンス
     */
    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    /**
     * setSecondPlayerを設定するためのメソッド
     *
     * @param firstPlayer Playerのインスタンス
     */
    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }


    /**
     * firstPlayerを取得するためのメソッド
     *
     * @return Playerクラスのインスタンス
     */
    public Player getFirstPlayer() {
        return this.firstPlayer;
    }

    /**
     * secondPlayerを取得するためのメソッド
     *
     * @return Playerクラスのインスタンス
     */
    public Player getSecondPlayer() {
        return this.secondPlayer;
    }


}
