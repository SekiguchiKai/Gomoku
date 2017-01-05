package jp.co.topgate.kai.sekiguchi.ox.logic;

import java.io.IOException;

/**
 * 各ゲームロジックの継承元
 * Created by sekiguchikai on 2016/12/20.
 */
public interface GameLogic{

    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    void playGame ()throws IOException;


}
