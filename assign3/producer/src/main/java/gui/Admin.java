package gui;

import javax.swing.*;
import java.awt.*;

public class Admin extends JFrame{
    private JPanel panel;
    private JLabel mainLbl;
    private JLabel titleLbl;
    private JTextField titleField;
    private JTextField yearField;
    private JLabel yearLbl;
    private JLabel priceLbl;
    private JTextField priceField;
    private JButton sendButton;
    private JTextArea messageAree;

    public Admin() throws HeadlessException {
        this.add(panel);
        this.setSize(400, 300);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getMainLbl() {
        return mainLbl;
    }

    public void setMainLbl(JLabel mainLbl) {
        this.mainLbl = mainLbl;
    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    public void setTitleLbl(JLabel titleLbl) {
        this.titleLbl = titleLbl;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public void setTitleField(JTextField titleField) {
        this.titleField = titleField;
    }

    public JTextField getYearField() {
        return yearField;
    }

    public void setYearField(JTextField yearField) {
        this.yearField = yearField;
    }

    public JLabel getYearLbl() {
        return yearLbl;
    }

    public void setYearLbl(JLabel yearLbl) {
        this.yearLbl = yearLbl;
    }

    public JLabel getPriceLbl() {
        return priceLbl;
    }

    public void setPriceLbl(JLabel priceLbl) {
        this.priceLbl = priceLbl;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public void setPriceField(JTextField priceField) {
        this.priceField = priceField;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public void setSendButton(JButton sendButton) {
        this.sendButton = sendButton;
    }

    public JTextArea getMessageAree() {
        return messageAree;
    }

    public void setMessageAree(JTextArea messageAree) {
        this.messageAree = messageAree;
    }
}
