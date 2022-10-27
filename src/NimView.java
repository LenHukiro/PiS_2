import windows.ExplainWindow;
import windows.HelpWindow;

import javax.swing.*;
import java.awt.event.*;

public class NimView {
    NimController controller;
    private JPanel application;
    private JButton userSubmitBtn;
    private JTextField UserRowInput;
    private JTextArea gameField;
    private JButton helpBtn;
    private JTextField UserCountInput;
    private JButton newGameBtn;
    private JButton bestMoveBtn;
    private JButton howToPlayBtn;
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
        addActionListeners();
        UserCountInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    isInputValid(UserCountInput, UserCountInput.getText());
                    enableUserBtn();
                }
            }
        });
        UserRowInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    isInputValid(UserRowInput, UserRowInput.getText());
                    enableUserBtn();
                }
            }
        });
    }

    private void init() {
        controller = new NimController(this);
        helpWindow = new HelpWindow();
        explainWindow = new ExplainWindow();
        helpBtn.hide();
        howToPlayBtn.hide();
        bestMoveBtn.hide();
    }

    private void addActionListeners() {
        helpBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                helpWindow.setVisible(true);
            }
        });
        howToPlayBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                explainWindow.setVisible(true);
            }
        });
        bestMoveBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        userSubmitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (userSubmitBtn.isEnabled()) convertAndMakeMove();
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

    public void disableAndClearUserInputs() {
        UserCountInput.setText("");
        UserRowInput.setText("");
        UserCountInput.setEditable(false);
        UserRowInput.setEditable(false);
        userSubmitBtn.setEnabled(false);
    }

    private void convertAndMakeMove() {
        int row, count;

        try {
            count = Integer.parseInt(UserCountInput.getText());
            row = Integer.parseInt(UserRowInput.getText());
        } catch (Error e) {
            System.out.println(e);
            throw e;

        }
        controller.playerMove(row, count);
    }

    private void enableUserBtn() {
        String rowText = UserRowInput.getText();
        String countText = UserCountInput.getText();
        userSubmitBtn.setEnabled(!rowText.trim().equals("") && !countText.trim().equals(""));
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


    public void setText(String s) {
        gameField.setText(s);
    }

    public String getText() {
        return gameField.getText();
    }


    public void clearPlayingField() {
        gameField.setText("");
    }

    public void setRows(String rows) {
        gameField.setText(rows);
    }

    public void appendText(String s) {
        gameField.setText(gameField.getText() + "\n" + s);
    }
}
