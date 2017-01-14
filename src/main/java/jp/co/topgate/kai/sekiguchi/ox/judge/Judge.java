package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;

/**
 * 勝敗の決定を審査するメソッド
 * Created by sekiguchikai on 2017/01/06.
 */
public interface Judge {

    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    Result judgeResult(Board board);
}