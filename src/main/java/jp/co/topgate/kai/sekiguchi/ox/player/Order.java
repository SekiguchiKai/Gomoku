package jp.co.topgate.kai.sekiguchi.ox.player;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
     * 開始の打ち手から、終了の打ち手までをランダムに決定してその順番を保持するためのリスト
     */
    private List<Player> sequentialRandomList = new ArrayList<>();

    /**
     * getNextPlayerメソッドが呼ばれた回数を数えるためのカウンター
     */
    private int counter;


    /**
     * 1回ごとに打ち手順を決定するのではなく、ゲーム開始時から終了時までの打ち手順を一気に決定するためのメソッド
     *
     * @param movesMaxNumber 打ち手の最大回数
     * @param user           User
     * @param cpu            Cpu
     */
    public void setSequentialRandomList(final int movesMaxNumber, final Player user, final Player cpu) {

        final int playerOrderMax = 2;

        IntStream.range(1, movesMaxNumber).forEach(i -> {
            int userOrder = (int) (Math.random() * playerOrderMax);
            if (userOrder == 1) {
                this.sequentialRandomList.add(user);
            } else {
                this.sequentialRandomList.add(cpu);
            }
        });
    }

    /**
     * 次の打ち手のプレーヤーを返すためのメソッド
     *
     * @return Playerクラスのインスタンス
     */
    public Player getNextPlayer() {
        this.counter++;
        return this.sequentialRandomList.get(this.counter);
    }

}