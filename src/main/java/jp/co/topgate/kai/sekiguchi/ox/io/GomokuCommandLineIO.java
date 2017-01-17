package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.Cell;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Signal;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * 五目並べのゲーム盤を並べる
 * Created by sekiguchikai on 2017/01/05.
 */
public class GomokuCommandLineIO extends CommandLineIO {

    /**
     * コマンドライン上にゲーム盤を描くためのメソッド
     *
     * @param gomokuBoard Boardクラスのインスタンス
     */
    public void drawUI(final Board gomokuBoard) {


        IntStream.range(0, gomokuBoard.getColumnSize() - 1).forEach(x -> System.out.print("  " + x));
        System.out.println("  8");


        final int limitNumber = 8;

        final int rowSize = gomokuBoard.getRowSize();
        final int columnSize = gomokuBoard.getColumnSize();

        for (int row = 0; row < rowSize; row++) {
            System.out.print(row + "-");
            for (int column = 0; column < columnSize; column++) {
                System.out.print(this.changeMovesToSignal(gomokuBoard.getCellState(row, column)));
                if (column == limitNumber) {
                    break;
                }
                System.out.print("--");
            }
            System.out.println("-");
        }


        System.out.println("\n");

        System.out.println("自分の打ち手を入力するにはゲーム盤上に表示されている数字を入力し、Enterキーを押してください");
        System.out.println("縦の数字を入力しEnterキーを押してください。　その次に横の数字を入力しEnterキーを押してください。");

    }


    /**
     * 列挙型MOVESの各要素を○や×の記号に変換するためのメソッド
     *
     * @param moves      プレーヤーの打ち手
     * @return 打ち手を表す印の文字列
     */
    String changeMovesToSignal(final Moves moves) {
        if (moves == Moves.USER_MOVE) {
            return Signal.CIRCLE.getSignal();
        } else if (moves == Moves.CPU_MOVE) {
            return Signal.CROSS.getSignal();
        }
        return ("|");

    }

    /**
     * 勝敗結果をコマンドライン上に描くためのメソッド
     *
     * @param result 勝敗結果
     */
    public void drawResult(final Result result) {
        System.out.println(result.getResult());
    }

    /**
     * コマンドラインからの入力を受け取り、受け取った入力を加工してプログラム上のゲーム盤の位置を返すメソッド
     *
     * @return 盤の場所（ユーザーからの入力がすでに石が置いてある場合場所だった場合:MAX_VALUE、ユーザーからの入力が不適切な数字だった場合 : MIN_VALUEを返す)
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    public Cell receiveCommand(final Board board) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String userInputY = scanner.next();
        String userInputX = scanner.next();

        System.out.println("スタート");


        if (!(Pattern.matches("^[.0-8]$", userInputY)) || !(Pattern.matches("^[.0-8]$", userInputX))) {
            return new Cell(Integer.MIN_VALUE, Integer.MIN_VALUE);

        } else if ((board.getGameBoardState()[Integer.parseInt(userInputY)][Integer.parseInt(userInputX)] != Moves.NO_MOVE)) {
            return new Cell(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }


        System.out.println("受け取った数字は" + userInputX + "と" + userInputY);

        return new Cell(Integer.parseInt(userInputY), Integer.parseInt(userInputX));
    }




}