package jp.co.topgate.kai.sekiguchi.ox.constantset;

/**
 * プレーヤーの打ち手を表す
 * Created by sekiguchikai on 2016/12/23.
 */
public enum Signal {
    /**
     * 「○」を表す印
     */
    CIRCLE("○"),
    /**
     * 「×」を表す印
     */
    CROSS("×"),
    /**
     * 空の状態を表す
     */
    EMPTY(" ");

    /**
     * 印を表す
     */
    private final String signal;

    /**
     * コンストラクタ
     * 初期化を行う
     *
     * @param signal 打ち手の印
     */
    Signal(final String signal) {
        this.signal = signal;
    }

    /**
     * 各定数に設定された文字列を返すメソッド
     *
     * @return 列挙型の要素
     */
    public String getSignal() {
        return this.signal;
    }
}
