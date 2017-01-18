package jp.co.topgate.kai.sekiguchi.ox.constantset;

/**
 * 各打ち手の定数を表すメソッド
 * Created by sekiguchikai on 2016/12/20.
 */
public enum Moves {
    /**
     * ユーザーの打ち手
     */
    CIRCLE("○"),
    /**
     * CPUの打ち手
     */
    CROSS("×"),
    /**
     * 打ち手がない場合
     */
    NO_MOVE("|");

    /**
     * 印を表す
     */
    private final String moves;

    /**
     * コンストラクタ
     * 初期化を行う
     *
     *
     * @param moves 打ち手の印
     */
   Moves(final String moves) {
        this.moves = moves;
    }

    /**
     * 各定数に設定された文字列を返すメソッド
     *
     * @return 列挙型の要素
     */
    public String getMoves() {
        return this.moves;
    }
}
