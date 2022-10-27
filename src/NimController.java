import java.util.Random;

class NimController {

    NimView view;
    Nim game;

    private enum Turn {PLAYER_MOVE, COMPUTER_MOVE}

    ;

    Turn turn = Turn.PLAYER_MOVE;

    NimController(NimView view) {
        this.view = view;
    }


    public void newGame() {
        view.clearPlayingField();
        game = Nim.of(createRowCount());
        view.setRows(game.toString());
    }

    private int[] createRowCount() {
        Random r = new Random();
        int[] filledRowCount = new int[r.nextInt(5, 7)];
        for (int i = 1; i <= filledRowCount.length; i++) {
            filledRowCount[i - 1] = i;
        }
        return filledRowCount;
    }

    public void playerMove(int row, int count) {
        game = game.play(Move.of(row - 1, count));
        view.setRows(game.toString());
        turn = Turn.COMPUTER_MOVE;
        if (!checkIfGameOver()) computerMove();
        checkIfGameOver();

    }

    private boolean checkIfGameOver() {
        if (game.isGameOver()) {
            displayWinner();
            view.disableAndClearUserInputs();
            return true;
        }
        return false;
    }

    private void displayWinner() {
        if (turn == Turn.PLAYER_MOVE) playerWon();
        else computerWon();
    }

    private void computerWon() {
        view.setText(view.getText() + "\n" + "Der Computer hat gewonnen.");
    }

    private void playerWon() {
        view.setText(view.getText() + "\n" + "Sie haben gewonnen.");
    }

    private void computerMove() {
        Move m = game.randomMove();
        game = game.play(m);
        checkIfGameOver();
        turn = Turn.PLAYER_MOVE;
        view.setRows(game.toString());
        view.appendText("Der Computer hat " + m.number + " Holzstäbchen aus der Reihe " + (m.row + 1) + " genommen.");
    }
}
