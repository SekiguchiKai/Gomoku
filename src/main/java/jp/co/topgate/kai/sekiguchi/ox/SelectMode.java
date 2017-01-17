package jp.co.topgate.kai.sekiguchi.ox;

import jp.co.topgate.kai.sekiguchi.ox.logic.GameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.GomokuGameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.TicTacToeGameLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 最初のモードを選択する画面についてのユーザーインターフェース
 * Created by sekiguchikai on 2017/01/05.
 */
public class SelectMode {

    /**
     * ユーザーに遊ぶゲームを選択させる画面を表示するメソッド
     */
    public void showMode() {
        System.out.println("以下の中から遊びたいゲームの番号を入力して、[Enter]キーを入力してください");
        System.out.println("1: 三目並べ");
        System.out.println("2: 五目並べ");
    }


    /**
     * どのゲームを開始するかを選択する入力を受け取るメソッド
     *
     * @return 選択されたゲームのロジック
     */
    public GameLogic selectMode() {
        int selectedModeNumber = this.getUserInput();

        while (selectedModeNumber == Integer.MIN_VALUE) {
            selectedModeNumber = this.getUserInput();
        }
        return this.getGameLogic(selectedModeNumber);

    }

    /**
     * ユーザーがコマンドラインで入力した値（不適切な値を入力した場合は、Integer.MIN_VALUE）を返すメソッド
     *
     * @return ユーザーがコマンドラインで入力した値（不適切な値を入力した場合は、Integer.MIN_VALUE）
     */
    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String selectedMode = scanner.next();

        if (!Pattern.matches("^[1-2]$", selectedMode)) {
            System.out.println("不適切な入力です。表示されている番号を入力してください");
            return Integer.MIN_VALUE;
        }

        return Integer.parseInt(selectedMode);
    }

    /**
     * 選択されたゲームのロジックのインスタンスを返す
     *
     * @param id 各ゲームロジックのid
     * @return ゲームのロジック
     */
    private GameLogic getGameLogic(final int id) {
        Map<Integer, GameLogic> logicMap = new HashMap<>();
        logicMap.put(1, new TicTacToeGameLogic());
        logicMap.put(2, new GomokuGameLogic());

        return logicMap.get(id);
    }
}
