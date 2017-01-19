package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.minimax.Cell;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import jp.co.topgate.kai.sekiguchi.ox.player.IoCaution;

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
     * ユーザーの入力によって、Userが行うことを決める
     *
     * @param userInput ユーザの入力の値
     */
    private void choiceDO(final Cell userInput) {
        if (userInput.getCellRow() == Integer.MAX_VALUE && userInput.getCellColumn() == Integer.MAX_VALUE) {
            this.drawExistingCaution();
        } else if (userInput.getCellRow() == Integer.MIN_VALUE && userInput.getCellColumn() == Integer.MIN_VALUE) {
            this.drawInappropriateCaution();
        }

    }


    /**
     * コマンドライン上にゲーム盤を描くためのメソッド
     *
     * @param board Boardクラスのインスタンス
     */
    public void drawUI(final Board board) {

        final int rowSize = board.getRowSize();
        final int columnSize = board.getColumnSize();

        IntStream.range(0, columnSize).forEach(column -> System.out.print("  " + column));
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
    public Cell receiveCommand(final Board board) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String userInputRowString = scanner.next();
        String userInputColumnString = scanner.next();

        Cell cell = new Cell();

        if (!Pattern.matches("^\\d$", userInputRowString)) {
            cell.setInvalidSpecified(IoCaution.NOT_NUMBER);
            return cell;
        } else if (!Pattern.matches("^\\d$", userInputColumnString)) {
            return cell;
        }

        int userInputRow = Integer.parseInt(userInputRowString);
        int userInputColumn = Integer.parseInt(userInputColumnString);

        IoCaution ioCautionRange = board.checkInputRange(userInputRow, userInputColumn);
        IoCaution ioCautionEmpty = board.checkInputEmpty(userInputRow, userInputColumn);

        if (ioCautionRange != IoCaution.APPROPRIATE) {
            cell.setInvalidSpecified(ioCautionRange);
            return cell;
        } else if (ioCautionEmpty != IoCaution.APPROPRIATE) {
            cell.setInvalidSpecified(ioCautionEmpty);
            return cell;
        }

        cell.setCellRow(userInputRow);
        cell.setCellColumn(userInputColumn);

        return cell;
    }

    /**
     * ユーザーが不適切な数字を入力した場合に、その旨を表示するためのメソッド
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

    /**
     * ユーザーが半角数字以外を入力した場合に、その旨を表示するためのメソッド
     */
    public void drawhalfWidthDigitCaution() {
        System.out.println("半角数字以外の文字が入力されています");
        System.out.println("半角数字を入力してください");
    }


}