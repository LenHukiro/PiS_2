import windows.ExplainWindow;
import windows.HelpWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class NimView {
    NimController controller;
    private JPanel application;
    private JButton userBtn;
    private JTextField UserRowInput;
    private JTextArea game;
    private JButton helpBtn;
    private JTextField UserCountInput;
    private JButton newGameBtn;
    private JButton besterZugButton;
    private JButton wieWirdGespieltButton;
    private HelpWindow helpWindow;
    private ExplainWindow explainWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NimView::new);
        JFrame frame = new JFrame("NimGame");
        frame.setSize(600, 600);
        frame.setContentPane(new NimView().application);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public NimView() {
        init();
        helpBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                helpWindow.setVisible(true);
            }
        });
        wieWirdGespieltButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                explainWindow.setVisible(true);
            }
        });
        newGameBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        besterZugButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        userBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        newGameBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controller.newGame();
                UserRowInput.setEditable(true);
                UserCountInput.setEditable(true);
            }
        });
        UserRowInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInputValid(UserRowInput, UserRowInput.getText());
                enableUserBtn();
            }

        });
        UserCountInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInputValid(UserCountInput, UserCountInput.getText());
                enableUserBtn();
            }
        });
    }

    private void enableUserBtn() {
        String rowText = UserRowInput.getText();
        String countText = UserCountInput.getText();
        userBtn.setEnabled(!rowText.trim().equals("") && !countText.trim().equals(""));
    }

    private void isInputValid(JTextField component, String text) {
        int number;
        try {
            number = Integer.parseInt(text);
        } catch (Error e) {
            throw new Error(e);
        }
        if (number <= 0) component.setText("");
    }

    private void init() {
        controller = new NimController(this);
        helpWindow = new HelpWindow();
        explainWindow = new ExplainWindow();
    }

    public void setText(String s) {
        game.setText(s);
    }

    private int[] getRows() {
        String[] rows = UserRowInput.getText().split(",");
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

    public void clearPlayingField() {
        game.setText("");
    }

    public void setRows(String[][] rows) {
        String stringRows = "";
        for (String[] row : rows) {
            stringRows = Arrays.toString(row) + "\n";
        }
        game.setText(stringRows);
    }
}
