package jp.co.topgate.kai.sekiguchi.ox.constantset;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 列挙型RESULTをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class ResultTest {
    /**
     * getResultメソッドをテストするためのメソッド
     */
    @Test
    public void 列挙型のフィールドを元にそのフィールドに紐づけられた勝敗結果の文字列を取得することが出来る() {
        this.helper(Result.WIN, "君の勝ちだ");
        this.helper(Result.LOSE, "君の負けだ");
        this.helper(Result.DRAW, "引き分けだ");

    }

    /**
     * getResultメソッドをテストするためのメソッドの補助メソッド
     *
     * @param data     テストで使用するデータ
     * @param expected 期待する値
     */
    private void helper(Result data, String expected) {
        assertThat(data.getResult(), is(expected));

    }

}