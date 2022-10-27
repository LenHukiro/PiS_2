import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class NimController implements ActionListener {

    NimView view;
    Nim game;

    NimController(NimView view) {
        this.view = view;
    }

    public void newGame(){
        String[][] rows = getRows();
        int[] rowCount= getRowCount(rows);
        game = Nim.of(rowCount);
        view.setRows(rows);
        view.clearPlayingField();
    }

    private int[] getRowCount(String[][] rows) {
        int[] rowCount = new int[rows.length];
        for (int i = 0; i <rowCount.length; i++) {
            rowCount[i] = rows[i].length;
        }
        return rowCount;
    }

    private String[][] getRows() {
        Random r = new Random();
        int rowCount = r.nextInt(3,7);
        String[][] rows = new String[7][rowCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j <= i; j++) {
                rows[j][i] = "I ";
            }
        }

        return rows;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // view.setRows(game.toString());

    }
}
