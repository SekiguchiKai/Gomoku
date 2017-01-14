package jp.co.topgate.kai.sekiguchi.ox;

import jp.co.topgate.kai.sekiguchi.ox.logic.GameLogic;
import jp.co.topgate.kai.sekiguchi.ox.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Mainのクラス、このアプリケーションのエントリーポイント
 * Created by sekiguchikai on 2016/12/20.
 */
public class Main {
    /**
     * メインメソッド
     *
     * @param args
     */
    public static void main(String[] args) {
//
//        // ログを取得するための準備をする
//        Log.doLogging();

        // 最初の選択画面を選択させる
        SelectMode selectMode = new SelectMode();
        selectMode.showMode();

        // 実行するゲームのロジック
        GameLogic gameLogic = selectMode.selectMode();

        try {
            gameLogic.playGame();
        } catch (IOException e) {
            System.err.println("エラーが発生しました" + e.getMessage());
            e.printStackTrace();
        }


    }
}
