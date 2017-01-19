package jp.co.topgate.kai.sekiguchi.ox.player;

/**
 * インターフェース部分での注意を表す列挙型
 * Created by sekiguchikai on 2017/01/19.
 */
public enum IoCaution {

    /**
     * 数字以外の文字が入力されたことを表す
     */
    NOT_NUMBER("半角数字で入力してくださ"),

    /**
     * 不適切な数字が入力されたことを表す
     */
    INAPPROPRIATE_NUMBER("不適切な数字です"),

    /**
     * 指定したマスに打ち手が既に存在する場合を表す
     */
    NOT_EMPTY("既に打ち手が存在します"),

    /**
     * 正常な入力を表す
     */
    APPROPRIATE("適切です");

    private String caution;

    /**
     * コンストラクタ
     *
     * @param caution 注意書き
     */
    IoCaution(final String caution) {
        this.caution = caution;
    }

    /**
     * 注意書きを取得するためのメソッド
     *
     * @return 注意書き
     */
    public String getCaution() {
        return this.caution;
    }
}
