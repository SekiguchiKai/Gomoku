package jp.co.topgate.kai.sekiguchi.ox;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Games;
import jp.co.topgate.kai.sekiguchi.ox.logic.GameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.GomokuGameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.TicTacToeGameLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 最初のモードを選択する画面についてのユーザーインターフェース
 * Created by sekiguchikai on 2017/01/05.
 */
public class SelectGameMode {

    /**
     * ユーザーに遊ぶゲームを選択させる画面を表示するメソッド
     */
    public void showGameTitle() {
        System.out.println("以下の中から遊びたいゲームの番号を入力して、[Enter]キーを入力してください");
        System.out.println("1: 三目並べ");
        System.out.println("2: 五目並べ");
    }


    /**
     * どのゲームを開始するかを選択する入力を受け取るメソッド
     *
     * @return 選択されたゲームのロジック
     */
    public GameLogic selectGame() {
        Games selectedGame = this.getUserInput();

        while (selectedGame == Games.NO_EXIST) {
            selectedGame = this.getUserInput();
        }
        return this.getGameLogic(selectedGame);

    }

    /**
     * ユーザーがコマンドラインで入力した値（不適切な値を入力した場合は、Integer.MIN_VALUE）を返すメソッド
     *
     * @return ユーザーがコマンドラインで入力した値（不適切な値を入力した場合は、Integer.MIN_VALUE）
     */
    private Games getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String selectedMode = scanner.next();

        final String ticTacToe = "1";
        final String gomoku = "2";

        switch (selectedMode) {
            case ticTacToe:
                return Games.TIC_TAC_TOE;
            case gomoku:
                return Games.GOMOKU;
        }

        System.out.println("不適切な入力です。表示されている番号を入力してください");

        return Games.NO_EXIST;
    }

    /**
     * 選択されたゲームのロジックのインスタンスを返す
     *
     * @param games 各ゲームロジックのid
     * @return ゲームのロジック
     * @throws java.util.NoSuchElementException 要求されたLogicのサブクラスが存在しません
     */
    private GameLogic getGameLogic(final Games games) throws NoSuchElementException {

        if (games == Games.TIC_TAC_TOE) {
            return new TicTacToeGameLogic();
        } else if (games == Games.GOMOKU) {
            return new GomokuGameLogic();
        }

        throw new NoSuchElementException("要求されたLogicのサブクラスが存在しません");

    }
}