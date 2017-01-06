package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

/**
 * ScoreCalculator系クラスの継承元となるクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public interface ScoreCalculator {
    /**
     * 現在のゲーム盤の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    int calcScore(Moves[][] gameBoard);
}
