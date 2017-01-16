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
     * 先攻の打ち手となるプレーヤーを設定するためのメソッド
     *
     * @param firstPlayer 先行の打ち手となるプレーヤー
     */
    public void setFirstPlayer(final Player firstPlayer) {
        this.firstPlayer = firstPlayer;

    }

    /**
     * 後攻の打ち手となるプレーヤーを設定するためのメソッド
     *
     * @param secondPlayer 先行の打ち手となるプレーヤー
     */
    public void setSecondPlayer(final Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    /**
     * 各プレーヤーの打ち手の順番を決める
     *
     * @param user Userクラスのインスタンス
     * @param cpu  Cpuクラスのインスタンス
     */
    public void setRandomOrder(final Player user, final Player cpu) {
        int userOrder = (int) (Math.random() * 2) + 1;

        if (userOrder == 1) {
            this.firstPlayer = user;
            this.secondPlayer = cpu;
        } else {
            this.firstPlayer = cpu;
            this.secondPlayer = user;
        }

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