package jp.co.topgate.kai.sekiguchi.ox.io;


import jp.co.topgate.kai.sekiguchi.ox.logic.GameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.GomokuGameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.TicTacToeGameLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 最初のモードを選択する画面についてのユーザーインターフェース
 * Created by sekiguchikai on 2017/01/05.
 */
public class SelectModeCommandLineIO {

    /**
     * ユーザーに遊ぶゲームを選択させる画面を表示するメソッド
     */
    public void drawUI() {
        System.out.println("以下の中から遊びたいゲームの番号を入力して、[Enter]キーを入力してください");
        System.out.println("1: 三目並べ");
        System.out.println("2: 五目並べ");
    }


    /**
     * どのゲームを開始するかを選択する入力を受け取るメソッド
     *
     * @return 選択されたゲームのロジック
     */
    public GameLogic receiveCommand() {
        Scanner scanner = new Scanner(System.in);
        int selectedMode = scanner.nextInt();

        return this.getGameLogic(selectedMode);

    }

    /**
     * 選択されたゲームのロジックのインスタンスを返す
     *
     * @param id 各ゲームロジックのid
     * @return ゲームのロジック
     */
    private GameLogic getGameLogic(int id) {
        Map<Integer, GameLogic> logicMap = new HashMap<>();
        logicMap.put(1, new TicTacToeGameLogic());
        logicMap.put(2, new GomokuGameLogic());

        return logicMap.get(id);
    }
}
