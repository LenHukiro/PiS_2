import javax.swing.*;

public class NimView {
    private JPanel application;
    private JButton userBtn;
    private JTextField userInput;
    private JTextArea game;
    private JButton helpBtn;
    private JTextField textField1;
    private JButton neuesSpielButton;
    private JButton besterZugButton;
    private JButton wieWirdGespieltButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NimView::new);
        JFrame frame = new JFrame("My First GUI");
        frame.setSize(600,600);
        frame.setContentPane(new NimView().application);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public NimView() {
        init();
    }

    private void init() {
        userBtn.addActionListener(new NimController(this));
    }

    public void setText(String s) {
        game.setText(s);
    }

    private int[] getRows() {
        String[] rows = userInput.getText().split(",");
        int[] intRows = new int[rows.length];
        for (int i = 0; i < rows.length; i++) {
            try {
                intRows[i] = Integer.parseInt(rows[i].trim());
            } catch (Error error) {
                System.out.println(error);
            }

        }
        return intRows;
    }

}
