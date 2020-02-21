package net.bytebutcher.burpsendtoextension.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import net.bytebutcher.burpsendtoextension.gui.util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendToPreviewDialog {

    private JTextArea txtCommandPreview;
    private JButton cancelButton;
    private JButton okButton;
    private JCheckBox alwaysShowThisDialogCheckBox;
    private JPanel formPanel;

    private SendToTableListener sendToTableListener;
    private AbstractAction onOkAction;
    private AbstractAction onCancelAction;
    private final JDialog dialog;
    private boolean success = false;

    public SendToPreviewDialog(JFrame parent, String title, final String command) {
        this.dialog = initDialog(parent, title);
        this.txtCommandPreview.setText(command);
        initEventListener();
        initKeyboardShortcuts();
    }

    public SendToPreviewDialog(JFrame parent, String title, final String command, final String commandId, final SendToTableListener sendToTableListener) {
        this(parent, title, command);
        this.sendToTableListener = sendToTableListener;
        initEventListener(commandId, sendToTableListener);
    }

    private void initEventListener() {
        onOkAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success = true;
                dialog.dispose();
            }
        };
        okButton.addActionListener(onOkAction);
        onCancelAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success = false;
                dialog.dispose();
            }
        };
        cancelButton.addActionListener(onCancelAction);
    }

    private void initEventListener(final String commandId, final SendToTableListener sendToTableListener) {
        alwaysShowThisDialogCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendToTableListener.onShowPreviewChange(e, commandId, alwaysShowThisDialogCheckBox.isSelected());
            }
        });
        alwaysShowThisDialogCheckBox.setVisible(true);
    }

    private JDialog initDialog(JFrame parent, String title) {
        JDialog dialog = new JDialog(parent, title, true);
        dialog.getContentPane().add(this.getRootPanel());
        dialog.pack();
        dialog.setSize(540, 200);
        int x = DialogUtil.getX(parent, dialog);
        int y = DialogUtil.getY(parent, dialog);
        dialog.setLocation(x, y);
        return dialog;
    }

    private void initKeyboardShortcuts() {
        bindKeyStrokeToAction("ESCAPE", onCancelAction);
        bindKeyStrokeToAction("ENTER", onOkAction);
    }

    private void bindKeyStrokeToAction(String keyStroke, Action action) {
        KeyStroke stroke = KeyStroke.getKeyStroke(keyStroke);
        InputMap inputMap = formPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, keyStroke);
        formPanel.getActionMap().put(keyStroke, action);
    }

    public boolean run() {
        this.dialog.setVisible(true);
        return this.success;
    }

    public String getCommand() {
        return this.txtCommandPreview.getText().replace("\r", "");
    }

    private Component getRootPanel() {
        return formPanel;
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
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayoutManager(3, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Do you really want to execute the following command(s)?");
        formPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        formPanel.add(panel1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setMnemonic('C');
        cancelButton.setDisplayedMnemonicIndex(0);
        panel1.add(cancelButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        okButton = new JButton();
        okButton.setText("Ok");
        okButton.setMnemonic('O');
        okButton.setDisplayedMnemonicIndex(0);
        panel1.add(okButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        alwaysShowThisDialogCheckBox = new JCheckBox();
        alwaysShowThisDialogCheckBox.setSelected(true);
        alwaysShowThisDialogCheckBox.setText("Always show this dialog");
        alwaysShowThisDialogCheckBox.setVisible(false);
        panel1.add(alwaysShowThisDialogCheckBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        formPanel.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        txtCommandPreview = new JTextArea();
        scrollPane1.setViewportView(txtCommandPreview);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return formPanel;
    }
}
