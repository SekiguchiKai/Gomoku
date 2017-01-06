package jp.co.topgate.kai.sekiguchi.ox.constantset;

/**
 * 結果の要素の集合体である列挙型
 * Created by sekiguchikai on 2016/12/23.
 */
public enum Result {
    /**
     * 勝ち
     */
     WIN("君の勝ちだ"),
    /**
     * 負け
     */
    LOSE("君の負けだ"),
    /**
     * 引き分け
     */
    DRAW("引き分けだ"),
    /**
     * 未決
     */
    PENDING("未決");

    /**
     * 勝敗の結果
     */
    private final String result;

    /**
     * コンストラクタ
     * 初期化する
     * @param result 勝敗結果
     */
    Result(String result) {
        this.result = result;
    }

    /**
     * 各定数に設定された文字列を返すメソッド
     * @return 列挙型の要素
     */
    public String getResult() {
        return this.result;
    }





}
