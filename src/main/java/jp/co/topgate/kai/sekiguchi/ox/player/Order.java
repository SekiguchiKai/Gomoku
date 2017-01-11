package jp.co.topgate.kai.sekiguchi.ox.player;


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
    public Order(final Player firstPlayer, final Player secondPlayer) {
        this.firstPlayer = firstPlayer;
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

