package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.Cell;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Signal;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * コマンドラインとのやりとりを行うクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class TicTacToeCommandLineIO extends CommandLineIO {


    /**
     * コマンドライン上にゲーム盤を描くためのメソッド
     *
     * @param ticTacToeBoard Boardクラスのインスタンス
     */
    public void drawUI(Board ticTacToeBoard) {


        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + " |");
        System.out.print("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(0, 1), 2) + " |");
        System.out.println("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(0, 2), 3) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(1, 0), 4) + " |");
        System.out.print("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(1, 1), 5) + " |");
        System.out.println("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(1, 2), 6) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(2, 0), 7) + " |");
        System.out.print("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(2, 1), 8) + " |");
        System.out.println("| " + this.changeMovesToSignal(ticTacToeBoard.getCellState(2, 2), 9) + " |");
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
    String changeMovesToSignal(Moves moves, int spotNumber) {
        if (moves == Moves.USER_MOVE) {
            return Signal.CIRCLE.getSignal();
        } else if (moves == Moves.CPU_MOVE) {
            return Signal.CROSS.getSignal();
        }
        return String.valueOf(spotNumber);

    }

    /**
     * 勝敗結果をコマンドライン上に描くためのメソッド
     *
     * @param result 勝敗結果
     */
    public void drawResult(Result result) {
        System.out.println(result.getResult());
    }

    /**
     * コマンドラインからの入力を受け取り、受け取った入力を加工してプログラム上のゲーム盤の位置を返すメソッド
     *
     * @return 盤の場所（ユーザーからの入力がすでに石が置いてある場合場所だった場合:MAX_VALUE、ユーザーからの入力が不適切な数字だった場合 : MIN_VALUEを返す)
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    public Cell receiveCommand(Board board) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String userInputY = scanner.next();
        String userInputX = scanner.next();

        Moves[][] gameBoard = board.getGameBoardState();

        if (!(Pattern.matches("^[.0-2]$", userInputY)) || !(Pattern.matches("^[.0-2]$", userInputX))) {
            return new Cell(Integer.MIN_VALUE, Integer.MIN_VALUE);

        } else if (!(gameBoard[Integer.parseInt(userInputY)][Integer.parseInt(userInputX)] == Moves.NO_MOVE)) {
            return new Cell(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }


        return new Cell(Integer.parseInt(userInputY), Integer.parseInt(userInputX));
    }


    /**
     * ユーザーが不適切な数字(0未満、10以上)を入力した場合に、その旨を表示するためのメソッド
     */
    public void drawInappropriateCaution() {
        System.out.println("不適切な入力です");
        System.out.println("再度数字を入力してください");
    }

    /**
     * ユーザーが既に打ち手の存在する場所選択した場合に、その旨を表示するためのメソッド
     */
    public void drawExistingCaution() {
        System.out.println("すでに打ち手が入力されています");
        System.out.println("再度数字を入力してください");
    }


}
