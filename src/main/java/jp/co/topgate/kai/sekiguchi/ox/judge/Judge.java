package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;


/**
 * 五目並べの勝敗結果を審査するためのクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class Judge {

    /**
     * rowのサイズ
     */
    private int rowSize;

    /**
     * columnSize columnのサイズ
     */
    private int columnSize;

    /**
     * 勝敗が決定する連続する打ち手の長さ
     */
    private int judgeCriteriaSequence;

    /**
     * 連続するrowの値を調べる際に使用する操作開始値の限界値
     */
    private int rowMax;

    /**
     * 連続するcolumnの値を調べる際に使用する操作開始値の限界値
     */
    private int columnMax;

    /**
     * @param rowSize               rowのサイズ
     * @param columnSize            columnのサイズ
     * @param judgeCriteriaSequence 勝敗が決定する連続する打ち手の長さ
     */
    public Judge(final int rowSize, final int columnSize, final int judgeCriteriaSequence) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.judgeCriteriaSequence = judgeCriteriaSequence;
        this.rowMax = this.rowSize - this.judgeCriteriaSequence + 1;
        this.columnMax = this.columnSize - this.judgeCriteriaSequence + 1;
    }


    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param board Boardクラスのインスランス
     * @return 勝敗の結果
     */
    public Result judgeResult(final Board board) {
        Moves[][] gameBoard = board.getGameBoardState();

        if (this.judgeWin(gameBoard)) {
            return Result.WIN;
        } else if (this.judgeLose(gameBoard)) {
            return Result.LOSE;
        } else if (this.judgeDraw(gameBoard)) {
            return Result.DRAW;
        }
        return Result.PENDING;
    }

    /**
     * ユーザーが勝利したかどうかを確認するためのメソッド
     * 縦、横、左斜め、右斜めを走査する
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利したかどうかの真偽値
     */
    private boolean judgeWin(final Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.CIRCLE)
                || this.judgeColumn(gameBoard, Moves.CIRCLE)
                || this.judgeLeftSlanting(gameBoard, Moves.CIRCLE)
                || this.judgeRightSlanting(gameBoard, Moves.CIRCLE);
    }


    /**
     * ユーザーが敗北したかどうかを確認するためのメソッド
     * 縦、横、左斜め、右斜めを走査する
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが敗北したかどうかの真偽値
     */
    private boolean judgeLose(final Moves[][] gameBoard) {
        return this.judgeRow(gameBoard, Moves.CROSS)
                || this.judgeColumn(gameBoard, Moves.CROSS)
                || this.judgeLeftSlanting(gameBoard, Moves.CROSS)
                || this.judgeRightSlanting(gameBoard, Moves.CROSS);


    }


    /**
     * 引き分けかどうかを確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 引き分けかどうかの真偽値
     */
    private boolean judgeDraw(final Moves[][] gameBoard) {
        for (int row = 0; row < this.rowSize; row++) {
            for (int column = 0; column < this.columnSize; column++) {
                if (this.judgeWin(gameBoard)) {
                    return false;
                } else if (this.judgeLose(gameBoard)) {
                    return false;
                } else if (gameBoard[row][column] == Moves.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * row(横のライン)が引数で指定されたMoveで5連が達成されているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean judgeRow(final Moves[][] gameBoard, final Moves moves) {
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < this.columnMax; column++) {
                if (this.checkARow(gameBoard, moves, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * rowにおいて指定された打ち手が、ゲーム盤上の指定された範囲内で勝敗を決定する数分連続しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     打ち手
     * @param row       rowのインデックス
     * @param column    columnのインデックス
     * @return 指定された打ち手が、ゲーム盤上の指定された範囲内で勝敗を決定する数分連続しているかの真偽値
     */
    private boolean checkARow(final Moves[][] gameBoard, final Moves moves, final int row, final int column) {
        for (int difference = 0; difference < this.judgeCriteriaSequence; difference++) {
            if (gameBoard[row][column + difference] != moves) {
                return false;
            }
        }
        return true;
    }


    /**
     * column(縦のライン)が引数で指定されたMoveで5連が達成されているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean judgeColumn(final Moves[][] gameBoard, final Moves moves) {
        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < this.rowMax; row++) {
                if (this.checkAColumn(gameBoard, moves, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * columnにおいて指定された打ち手が、ゲーム盤上の指定された範囲内で勝敗を決定する数分連続しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     打ち手
     * @param row       rowのインデックス
     * @param column    columnのインデックス
     * @return 指定された打ち手が、ゲーム盤上の指定された範囲内で勝敗を決定する数分連続しているかの真偽値
     */
    private boolean checkAColumn(final Moves[][] gameBoard, final Moves moves, final int row, final int column) {
        for (int difference = 0; difference < this.judgeCriteriaSequence; difference++) {
            if (gameBoard[row + difference][column] != moves) {
                return false;
            }
        }
        return true;
    }


    /**
     * 左斜めのラインにおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     打ち手
     * @return 右斜めのラインにおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     */
    public boolean judgeLeftSlanting(final Moves[][] gameBoard, final Moves moves) {

        // centerAxis
        int column = 0;

        for (int row = 0; row < rowMax; row++) {
            // 1回あたりの5連
            boolean oneTermCheck = this.checkOneTermLeftSlanting(gameBoard, moves, row, column);
            if (oneTermCheck) {
                return true;
            }
            column++;
        }


        // rowシフト
        for (int rowStart = 1; rowStart < this.judgeCriteriaSequence; rowStart++) {
            boolean rowShiftCheck = this.leftSlantingRowShift(gameBoard, moves, rowStart);
            if (rowShiftCheck) {
                return true;
            }
        }

        // columnシフト
        for (int columnStart = 0; columnStart < this.columnMax; columnStart++) {
            boolean columnShiftCheck = this.leftSlantingColumnShift(gameBoard, moves, columnStart);
            if (columnShiftCheck) {
                return true;
            }
        }


        return false;
    }


    /**
     * 左ラインのROWがスライドした時の審査を行うためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean leftSlantingRowShift(final Moves[][] gameBoard, final Moves moves, final int rowStart) {
        int column = 0;

        // for文1回で、1つの連を表す
        for (int row = rowStart; row < rowMax; row++) {
            boolean oneTermCheck = checkOneTermLeftSlanting(gameBoard, moves, row, column);
            if (oneTermCheck) {
                return true;
            }

            column++;
        }
        return false;
    }


    /**
     * 左ラインのROWがスライドした時の審査を行うためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     検査対象のプレーヤーの打ち手
     * @return 勝敗が決定したか真偽値
     */
    private boolean leftSlantingColumnShift(final Moves[][] gameBoard, final Moves moves, final int columnStart) {
        int row = 0;

        // for文1回で、1つの連を表す
        for (int column = columnStart; column < columnMax; column++) {
            boolean oneTermCheck = checkOneTermLeftSlanting(gameBoard, moves, row, column);
            if (oneTermCheck) {
                return true;
            }

            row++;
        }
        return false;
    }


    /**
     * 左斜めのラインの1回あたりおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     打ち手
     * @param row       rowのインデックス
     * @param column    columnのインデックス
     * @return 1回あたりおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値
     */
    public boolean checkOneTermLeftSlanting(final Moves[][] gameBoard, final Moves moves, final int row, final int column) {

        for (int difference = 0; difference < this.judgeCriteriaSequence; difference++) {
            if (gameBoard[row + difference][column + difference] != moves) {
                return false;
            }
        }
        return true;

    }


    /**
     * 右斜めのラインにおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     打ち手
     * @return 右斜めのラインにおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     */
    public boolean judgeRightSlanting(final Moves[][] gameBoard, final Moves moves) {

        // centerAxis
        int column = columnSize - 1;

        for (int row = 0; row < rowMax; row++) {
            // 1回あたりの5連
            boolean oneTermCheck = this.checkOneTermRightSlanting(gameBoard, moves, row, column);
            if (oneTermCheck) {
                return true;
            }
            column--;
        }

        // rowシフト
        for (int rowStart = 1; rowStart < this.judgeCriteriaSequence; rowStart++) {
            boolean rowShiftCheck = this.rightSlantingRowShift(gameBoard, moves, rowStart);
            if (rowShiftCheck) {
                return true;
            }
        }
        // columnシフト
        final int start = gameBoard.length - 1;
        for (int columnStart = start; columnStart > this.rowSize - this.judgeCriteriaSequence - 1; columnStart--) {
            boolean columnShiftCheck = this.rightSlantingColumnShift(gameBoard, moves, columnStart);
            if (columnShiftCheck) {
                return true;
            }
        }

        return false;
    }

    /**
     * 右斜めのラインがrowにおいてシフトする時(row1~row4)、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     打ち手
     * @param rowStart  rowの調査開始値
     * @return 右斜めのラインがrowにおいてシフトする時(row1~row4)、引数で受け取った打ち手が5連揃っているかどうかの真偽値
     */
    private boolean rightSlantingRowShift(final Moves[][] gameBoard, final Moves moves, final int rowStart) {
        int column = columnSize - 1;

        for (int row = rowStart; row < rowMax; row++) {
            // 1回あたりの5連
            boolean oneTermCheck = this.checkOneTermRightSlanting(gameBoard, moves, row, column);
            if (oneTermCheck) {
                return true;
            }
            column--;
        }
        return false;
    }

    /**
     * 右斜めのラインがrowにおいてシフトする時(row1~row4)、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     *
     * @param gameBoard   ゲーム盤
     * @param moves       打ち手
     * @param columnStart rowの調査開始値
     * @return 右斜めのラインがrowにおいてシフトする時(row1~row4)、引数で受け取った打ち手が5連揃っているかどうかの真偽値
     */
    private boolean rightSlantingColumnShift(final Moves[][] gameBoard, final Moves moves, final int columnStart) {
        int row = 0;

        final int columnEnd = this.judgeCriteriaSequence - 2;
        for (int column = columnStart; column > columnEnd; column--) {
            // 1回あたりの5連
            boolean oneTermCheck = this.checkOneTermRightSlanting(gameBoard, moves, row, column);
            if (oneTermCheck) {
                return true;
            }
            row++;
        }
        return false;
    }


    /**
     * 右斜めのライン1回あたりおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値を確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     打ち手
     * @param row       rowのインデックス
     * @param column    columnのインデックス
     * @return 1回あたりおいて、引数で受け取った打ち手が5連揃っているかどうかの真偽値
     */
    public boolean checkOneTermRightSlanting(final Moves[][] gameBoard, final Moves moves, final int row, final int column) {

        for (int difference = 0; difference < this.judgeCriteriaSequence; difference++) {
            if (gameBoard[row + difference][column - difference] != moves) {
                return false;
            }
        }
        return true;

    }
}
