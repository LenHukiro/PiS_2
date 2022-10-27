import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NimController implements ActionListener {

    NimView view;
    Nim game;

    NimController(NimView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // view.setRows(game.toString());
    }
}
