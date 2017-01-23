package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.minimax.Cell;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.player.InputState;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * コマンドラインとのやりとりを行うクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class CommandLineIO {

    /**
     * Cellクラスのインスタンス
     */
    private Cell cell;

    /**
     * コマンドライン上にゲーム盤を描くためのメソッド
     *
     * @param board Boardクラスのインスタンス
     */
    public void drawUI(final Board board) {

        final int rowSize = board.getRowSize();
        final int columnSize = board.getColumnSize();


        IntStream.range(0, columnSize).forEach(column -> System.out.print("  " + board.getColumnAlphabet(column)));
        System.out.println("  ");


        for (int row = 0; row < rowSize; row++) {
            System.out.print(row + "-");
            for (int column = 0; column < columnSize; column++) {

                Moves moves = board.getCellState(row, column);
                String movesString = moves.getMoves();

                System.out.print(movesString);
                if (column == columnSize - 1) {
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
    public InputState receiveCommand(final Board board) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String userInputColumnString = scanner.next();
        String userInputRowString = scanner.next();

        if (!Pattern.matches("^[a-z]$", userInputColumnString)) {
            return InputState.NOT_ALPHABET;
        } else if (!Pattern.matches("^\\d+$", userInputRowString)) {
            return InputState.NOT_NUMBER;
        }

        int userInputRow = Integer.parseInt(userInputRowString);
        int userInputColumn = board.getAlphabetindex(userInputColumnString);

        InputState inputStateRange = board.checkInputRange(userInputRow, userInputColumn);

        if (inputStateRange != InputState.APPROPRIATE) {
            return inputStateRange;
        }

        InputState inputStateEmpty = board.checkInputEmpty(userInputRow, userInputColumn);
        if (inputStateEmpty != InputState.APPROPRIATE) {
            return inputStateEmpty;
        }

        this.cell = new Cell(userInputRow, userInputColumn);

        return InputState.APPROPRIATE;

    }

    /**
     * ユーザーが不適切な数字を入力した場合に、その旨を表示するためのメソッド
     *
     * @param cation 列挙型InputStateの要素
     */
    public void drawInappropriateCaution(final InputState cation) {
        String cautionString = cation.getCautionString();
        System.out.println(cautionString);
    }


    /**
     * 本クラスのフィールド変数であるCellを取得するためのメソッド
     *
     * @return Cellクラスのインスタンス
     */
    public Cell getCell() {
        return this.cell;
    }


}