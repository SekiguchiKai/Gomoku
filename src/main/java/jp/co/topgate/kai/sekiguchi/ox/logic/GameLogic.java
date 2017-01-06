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
     * ゲームを進行していくロジックを担当するメソッド
     */
    void playGame() throws IOException;

}
