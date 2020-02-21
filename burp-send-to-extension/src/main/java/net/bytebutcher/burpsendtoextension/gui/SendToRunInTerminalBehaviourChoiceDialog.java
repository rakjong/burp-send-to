package net.bytebutcher.burpsendtoextension.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import net.bytebutcher.burpsendtoextension.gui.util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SendToRunInTerminalBehaviourChoiceDialog extends JDialog {

    private EChoice choice;

    public enum EChoice {
        RUN_IN_SINGLE_TERMINAL,
        RUN_IN_SEPARATE_TERMINALS,
        REVIEW_COMMANDS,
        CANCEL
    }

    private final JFrame parent;
    private JPanel contentPane;
    private JButton btnRunInSingleTerminal;
    private JButton btnCancel;
    private JButton btnRunInSeparateTerminals;
    private JLabel lblCommandCount;
    private JButton btnReviewCommands;

    public SendToRunInTerminalBehaviourChoiceDialog(JFrame parent, int nrOfCommands) {
        this.parent = parent;
        this.choice = EChoice.CANCEL; // Default
        this.lblCommandCount.setText(String.valueOf(nrOfCommands));
        setContentPane(contentPane);
        setTitle("Select execution behaviour");
        setModal(true);
        getRootPane().setDefaultButton(btnRunInSingleTerminal);

        btnRunInSeparateTerminals.addActionListener(e -> onButtonPress(EChoice.RUN_IN_SEPARATE_TERMINALS));
        btnRunInSingleTerminal.addActionListener(e -> onButtonPress(EChoice.RUN_IN_SINGLE_TERMINAL));
        btnReviewCommands.addActionListener(e -> onButtonPress(EChoice.REVIEW_COMMANDS));
        btnCancel.addActionListener(e -> onButtonPress(EChoice.CANCEL));

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        this.pack();
    }

    public EChoice run() {
        int x = DialogUtil.getX(parent, this);
        int y = DialogUtil.getY(parent, this);
        this.setLocation(x, y);
        this.setVisible(true);
        return choice;
    }

    private void onButtonPress(EChoice choice) {
        this.choice = choice;
        dispose();
    }

    private void onCancel() {
        this.choice = EChoice.CANCEL;
        dispose();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(2, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnRunInSeparateTerminals = new JButton();
        btnRunInSeparateTerminals.setText("Run in separate terminals");
        btnRunInSeparateTerminals.setMnemonic('S');
        btnRunInSeparateTerminals.setDisplayedMnemonicIndex(7);
        panel1.add(btnRunInSeparateTerminals, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnRunInSingleTerminal = new JButton();
        btnRunInSingleTerminal.setText("Run in single terminal");
        btnRunInSingleTerminal.setMnemonic('I');
        btnRunInSingleTerminal.setDisplayedMnemonicIndex(8);
        panel1.add(btnRunInSingleTerminal, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        panel1.add(btnCancel, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnReviewCommands = new JButton();
        btnReviewCommands.setText("Review commands");
        btnReviewCommands.setMnemonic('O');
        btnReviewCommands.setDisplayedMnemonicIndex(8);
        panel1.add(btnReviewCommands, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Please select how the commands should be executed.");
        panel2.add(label1, new GridConstraints(1, 0, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("You are going to execute ");
        panel2.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblCommandCount = new JLabel();
        lblCommandCount.setText("0");
        panel2.add(lblCommandCount, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText(" commands.");
        panel2.add(label3, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel2.add(spacer3, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
