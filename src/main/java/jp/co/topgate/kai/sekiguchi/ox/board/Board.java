package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.player.InputState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ゲーム盤
 * Created brow sekiguchikai on 2017/01/05.
 */
public class Board {

    /**
     * ゲーム盤の列を表す
     */
    private int columnSize;

    /**
     * columnを表すアルファベットを表す
     */
    private List<String> columnAlphabetList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");

    /**
     * ゲーム盤の行を表す
     */
    private int rowSize;

    /**
     * ゲーム盤を表す二次元配列
     */
    private Moves[][] gameBoard;

    /**
     * コンストラクタ
     * columnSize、rowSize、配列の大きさを初期化する
     *
     * @param columnSize columnの長さ
     * @param rowSize    rowの長さ
     */
    public Board(final int columnSize, final int rowSize) {
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        this.gameBoard = new Moves[rowSize][columnSize];
        IntStream.range(0, rowSize).forEach(row -> IntStream.range(0, columnSize).forEach(column -> gameBoard[row][column] = Moves.EMPTY));
    }


    /**
     * ゲーム盤の指定した場所に打ち手を打つためのメソッド
     *
     * @param row    ゲーム盤のrow座標
     * @param column ゲーム盤のcolumn座標
     * @param moves  打ち手
     */
    public void putMoves(final int row, final int column, final Moves moves) {
        this.gameBoard[row][column] = moves;
    }


    /**
     * ゲーム盤の指定されたマスの打ち手を返す
     *
     * @param row    ゲーム盤のrow座標
     * @param column ゲーム盤のcolumn座標
     * @return 打ち手
     */
    public Moves getCellState(final int row, final int column) {
        return this.gameBoard[row][column];
    }

    /**
     * ゲーム盤の現在の状態を取得するためのメソッド
     *
     * @return ゲーム盤のコピー
     */
    public Moves[][] getGameBoardState() {
        final Moves[][] copyArray = new Moves[rowSize][columnSize];
        IntStream.range(0, rowSize).forEach(i -> IntStream.range(0, columnSize).forEach(j -> copyArray[i][j] = gameBoard[i][j]));
        return copyArray;

    }

    /**
     * ゲーム盤の列の長さを返す
     *
     * @return ゲーム盤の行の長さ
     */
    public int getRowSize() {
        return this.rowSize;
    }

    /**
     * ゲーム盤のX軸の長さを返す
     *
     * @return ゲーム盤の列の長さ
     */
    public int getColumnSize() {
        return this.columnSize;
    }

    /**
     * 指定されたインデックスのcolumnのアルファベットを返す
     * @param index アルファベットのリストのインデックス
     * @return アルファベット
     */
    public String getColumnAlphabet(final int index) {
        return this.columnAlphabetList.get(index);
    }

    /**
     * 指定されたアルファベットのインデックスを返す
     * @param alphabet アルファベット
     * @return アルファベットのインデックス
     */
    public int getAlphabetindex(final String alphabet) {
        return this.columnAlphabetList.indexOf(alphabet);
    }



    /**
     * 指定されたrowとcolumnの数字が、gameBoardの内で有効な範囲にあるかどうかを返すためのメソッド
     *
     * @param specifiedRow    指定されたrow
     * @param specifiedColumn 指定されたcolumn
     * @return 指定されたrowとcolumnの数字が、gameBoardの内で有効な範囲にあるかどうか
     */
    public InputState checkInputRange(final int specifiedRow, final int specifiedColumn) {
        if (!checkInputRangeHelper(specifiedRow, rowSize)) {
            return InputState.OUT_OF_RANGE;
        } else if (!checkInputRangeHelper(specifiedColumn, columnSize)) {
            return InputState.OUT_OF_RANGE;
        }
        return InputState.APPROPRIATE;
    }


    /**
     * 0 <= 指定された数字 < 実際のサイズかどうかの真偽値を返すためのメソッド
     *
     * @param specifiedNum 指定された数字
     * @param numSize      実際のサイズ
     * @return0 <= 指定された数字 < 実際のサイズかどうかの真偽値
     */
    private boolean checkInputRangeHelper(final int specifiedNum, final int numSize) {
        if (0 > specifiedNum) {
            return false;
        } else if (specifiedNum >= numSize) {
            return false;
        }
        return true;
    }

    /**
     * 指定されたrowとcolumnのせるの中に打ち手が入っているかどうかを確認するためのメソッド
     *
     * @param specifiedRow    指定されたrow
     * @param specifiedColumn 指定されたcolumn
     * @return 指定されたrowとcolumnのせるの中に打ち手が入っているかどうか
     */
    public InputState checkInputEmpty(final int specifiedRow, final int specifiedColumn) {
        if (this.gameBoard[specifiedRow][specifiedColumn] != Moves.EMPTY) {
            return InputState.NOT_EMPTY;
        }
        return InputState.APPROPRIATE;
    }

}