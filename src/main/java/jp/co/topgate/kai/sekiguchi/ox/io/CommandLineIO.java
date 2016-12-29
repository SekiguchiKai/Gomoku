package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.constantset.MOVES;
import jp.co.topgate.kai.sekiguchi.ox.constantset.RESULT;
import jp.co.topgate.kai.sekiguchi.ox.constantset.SIGNAL;

import java.io.*;
import java.util.*;

/**
 * コマンドラインとのやりとりを行うクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class CommandLineIO {


    /**
     * コマンドライン上にゲーム盤を描くためのメソッド
     *
     * @param gameBoard ゲーム盤
     */
    public void drawBoard(MOVES[] gameBoard) {


        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToSignal(gameBoard[0], 1) + " |");
        System.out.print("| " + this.changeMovesToSignal(gameBoard[1], 2) + " |");
        System.out.println("| " + this.changeMovesToSignal(gameBoard[2], 3) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToSignal(gameBoard[3], 4) + " |");
        System.out.print("| " + this.changeMovesToSignal(gameBoard[4], 5) + " |");
        System.out.println("| " + this.changeMovesToSignal(gameBoard[5], 6) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToSignal(gameBoard[6], 7) + " |");
        System.out.print("| " + this.changeMovesToSignal(gameBoard[7], 8) + " |");
        System.out.println("| " + this.changeMovesToSignal(gameBoard[8], 9) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.println("自分の打ち手を入力するにはゲーム盤上に表示されている数字を入力し、Enterキーを押してください");

    }


    /**
     * 列挙型MOVESの各要素を○や×の記号に変換するためのメソッド
     *
     * @param moves      プレーヤーの打ち手
     * @param spotNumber ゲーム盤の場所
     * @return 打ち手を表す印の文字列
     */
    String changeMovesToSignal(MOVES moves, int spotNumber) {
        if (moves == MOVES.USER_MOVE) {
            return SIGNAL.CIRCLE.getSignal();
        } else if (moves == MOVES.CPU_MOVE) {
            return SIGNAL.CROSS.getSignal();
        }
        return String.valueOf(spotNumber);

    }

    /**
     * 勝敗結果をコマンドライン上に描くためのメソッド
     *
     * @param result 勝敗結果
     */
    public void drawResult(RESULT result) {
        System.out.println(result.getResult());
    }

    /**
     * コマンドラインからの入力を受け取り、受け取った入力を加工してプログラム上のゲーム盤の位置を返すメソッド
     *
     * @return 盤の場所（ユーザーからの入力がすでに石が置いてある場合場所だった場合:MAX_VALUE、ユーザーからの入力が不適切な数字だった場合 : MIN_VALUEを返す)
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    public int receiveCommand(MOVES[] gameBoard) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput > 9 || userInput <= 0) {
            return Integer.MIN_VALUE;
        } else if (!(gameBoard[userInput - 1] == MOVES.NO_MOVE)) {
            return Integer.MAX_VALUE;
        }
        return userInput - 1;
    }


    /**
     * ユーザーが既に打ち手の存在する場所選択した場合に、その旨を表示するためのメソッド
     */
    public void drawExistingCaution() {
        System.out.println("すでに打ち手が入力されています");
        System.out.println("再度数字を入力してください");
    }

    /**
     * ユーザーが不適切な数字(0未満、10以上)を入力した場合に、その旨を表示するためのメソッド
     */
    public void drawInappropriateCaution() {
        System.out.println("不適切な数字です");
        System.out.println("再度数字を入力してください");
    }


}
