import java.util.*;
import java.util.stream.IntStream;


/**
 * 打ち手のシミュレーションを行うためのクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class Simulator {


    /**
     * 勝敗を判断するためのメソッド
     * 勝敗によって返す点数が異なる
     * <p>
     * CPUが勝利した場合 : 100
     * USERが勝利した場合 : -100
     * 引き分けの場合 : 50
     * 未決の場合 : 0
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    int calcScore(MOVES[][] gameBoard) {
        int score = 0;

        // 横
        score += this.calcRowScore(gameBoard);
        // 縦
        score += this.calcColumnScore(gameBoard);
        // 斜め
        score += this.calcSlanting(gameBoard);

        // 全部埋まった（引き分け）
        List<MOVES> checkList = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> checkList.add(gameBoard[i][j])));

        if (!checkList.contains(MOVES.EMPTY)) {
            score += 50;
        }
        return score;
    }


    /**
     * 横のラインで勝敗が決定したか確認するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果の点数
     */
    int calcRowScore(MOVES[][] gameBoard) {
        if ((gameBoard[0][0] == MOVES.USER_MOVE && gameBoard[1][0] == MOVES.USER_MOVE && gameBoard[2][0] == MOVES.USER_MOVE) ||
                (gameBoard[0][1] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[2][1] == MOVES.USER_MOVE) ||
                (gameBoard[0][2] == MOVES.USER_MOVE && gameBoard[1][2] == MOVES.USER_MOVE && gameBoard[2][2] == MOVES.USER_MOVE)) {
            return -100;
        } else if ((
                gameBoard[0][0] == MOVES.CPU_MOVE && gameBoard[1][0] == MOVES.CPU_MOVE && gameBoard[2][0] == MOVES.CPU_MOVE) ||
                (gameBoard[0][1] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[2][1] == MOVES.CPU_MOVE) ||
                (gameBoard[0][2] == MOVES.CPU_MOVE && gameBoard[1][2] == MOVES.CPU_MOVE && gameBoard[2][2] == MOVES.CPU_MOVE)) {
            return 100;
        }
        return 0;
    }

    /**
     * 縦のラインで勝敗が決定したか確認するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果の点数
     */
    int calcColumnScore(MOVES[][] gameBoard) {

        if ((gameBoard[0][0] == MOVES.USER_MOVE && gameBoard[0][1] == MOVES.USER_MOVE && gameBoard[0][2] == MOVES.USER_MOVE) ||
                (gameBoard[1][0] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[1][2] == MOVES.USER_MOVE) ||
                (gameBoard[2][0] == MOVES.USER_MOVE && gameBoard[2][1] == MOVES.USER_MOVE && gameBoard[2][2] == MOVES.USER_MOVE)) {
            return -100;
        } else if ((gameBoard[0][0] == MOVES.CPU_MOVE && gameBoard[0][1] == MOVES.CPU_MOVE && gameBoard[0][2] == MOVES.CPU_MOVE) ||
                (gameBoard[1][0] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[1][2] == MOVES.CPU_MOVE) ||
                (gameBoard[2][0] == MOVES.CPU_MOVE && gameBoard[2][1] == MOVES.CPU_MOVE && gameBoard[2][2] == MOVES.CPU_MOVE)) {
            return 100;
        }
        return 0;
    }

    /**
     * 斜めのラインで勝敗が決定したか確認するメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果の点数
     */
    int calcSlanting(MOVES[][] gameBoard) {
        if ((gameBoard[0][0] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[2][2] == MOVES.USER_MOVE) ||
                (gameBoard[0][2] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[2][0] == MOVES.USER_MOVE)) {
            return -100;
        } else if ((gameBoard[0][0] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[2][2] == MOVES.CPU_MOVE) ||
                (gameBoard[0][2] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[2][0] == MOVES.CPU_MOVE)) {
            return 100;
        }
        return 0;
    }


}




