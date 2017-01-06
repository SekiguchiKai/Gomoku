package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;

import java.io.IOException;

/**
 * 各ゲームロジックの継承元
 * Created by sekiguchikai on 2016/12/20.
 */
public interface GameLogic {

    /**
     * ゲームを進めていくロジックを担当するメソッド
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    void playGame() throws IOException;

}
