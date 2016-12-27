

import java.util.*;


/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogic implements GameLogic {

    // とりあえず user= ○, cpu= ×

    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    public void playGame() {
        Board board = new Board();
        Terminal terminal = new Terminal();
        MinMaxLogic minMaxLogic = new MinMaxLogic();
        Player user = new User(board, minMaxLogic, terminal);
        Player cpu = new Cpu(board, minMaxLogic, terminal);


        terminal.drawBoard(board.getGameBoard());

        int depthCount = 2;


        while (this.judgeResult(board.getGameBoard()) == RESULT.PENDING) {

            user.doMove(depthCount);


            if (this.judgeResult(board.getGameBoard()) == RESULT.PENDING) {
                cpu.doMove(depthCount);
            }


        }

        // ここターミナルにすること
        terminal.drawResult(this.judgeResult(board.getGameBoard()));


    }


    RESULT judgeResult(MOVES[] gameBoard) {

        if (gameBoard[0] == MOVES.CPU_MOVE && gameBoard[1] == MOVES.CPU_MOVE && gameBoard[2] == MOVES.CPU_MOVE ||
                gameBoard[3] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[5] == MOVES.CPU_MOVE ||
                gameBoard[6] == MOVES.CPU_MOVE && gameBoard[7] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[0] == MOVES.CPU_MOVE && gameBoard[3] == MOVES.CPU_MOVE && gameBoard[6] == MOVES.CPU_MOVE ||
                gameBoard[1] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[7] == MOVES.CPU_MOVE ||
                gameBoard[2] == MOVES.CPU_MOVE && gameBoard[5] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[0] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[2] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[6] == MOVES.CPU_MOVE
                ) {
            return RESULT.LOSE;
        } else if (gameBoard[0] == MOVES.USER_MOVE && gameBoard[1] == MOVES.USER_MOVE && gameBoard[2] == MOVES.USER_MOVE ||
                gameBoard[3] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[5] == MOVES.USER_MOVE ||
                gameBoard[6] == MOVES.USER_MOVE && gameBoard[7] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[0] == MOVES.USER_MOVE && gameBoard[3] == MOVES.USER_MOVE && gameBoard[6] == MOVES.USER_MOVE ||
                gameBoard[1] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[7] == MOVES.USER_MOVE ||
                gameBoard[2] == MOVES.USER_MOVE && gameBoard[5] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[0] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[2] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[6] == MOVES.USER_MOVE
                ) {
            return RESULT.WIN;
        }

        List<MOVES> gameBoardList = Arrays.asList(gameBoard);

        if (!gameBoardList.contains(MOVES.NO_MOVE)) {
            return RESULT.DRAW;
        }

        return RESULT.PENDING;
    }
}




