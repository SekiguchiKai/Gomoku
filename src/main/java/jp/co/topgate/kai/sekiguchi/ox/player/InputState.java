package jp.co.topgate.kai.sekiguchi.ox.player;

/**
 * インターフェース部分での注意を表す列挙型
 * Created by sekiguchikai on 2017/01/19.
 */
public enum InputState {

    /**
     * 数字以外の文字が入力されたことを表す
     */
    NOT_NUMBER("rowは半角数字で入力してください"),

    /**
     *
     *
     */
    NOT_ALPHABET("columnは1文字の半角英字で入力してください"),


    /**
     * 指定したマスに打ち手が既に存在する場合を表す
     */
    NOT_EMPTY("既に打ち手が存在します"),

    /**
     * 配列の範囲外の値が入力されたことを表す
     */
    OUT_OF_RANGE("範囲外の値が入力されています。"),

    /**
     * 正常な入力を表す
     */
    APPROPRIATE("適切です");

    /**
     * 注意を表す文字列
     */
    private String caution;

    /**
     * コンストラクタ
     *
     * @param caution 注意書き
     */
    InputState(final String caution) {
        this.caution = caution;
    }

    /**
     * 列挙型の各要素の注意文を取得するためのメソッド
     *
     * @return 列挙型の各要素の注意文
     */
    public String getCautionString() {
        return caution;
    }

}
