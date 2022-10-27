package windows;

import javax.swing.*;
import java.awt.event.*;

public class HelpWindow extends JDialog {
    private JPanel contentPanel;
    private JButton okBtn;
    private JButton cancelBtn;

    public HelpWindow() {
        setContentPane(contentPanel);
        setModal(true);
        getRootPane().setDefaultButton(okBtn);
        setSize(200,300);
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        HelpWindow dialog = new HelpWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
