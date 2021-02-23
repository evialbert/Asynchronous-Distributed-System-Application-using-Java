package gui;

import entities.DVD;
import start.EmitLog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {

    private Admin admin;
    private EmitLog emitLog;

    public AdminController() {
        this.admin = new Admin();
        this.emitLog = new EmitLog();
        admin.setVisible(true);
    }

    public void setupControl() {
        admin.getSendButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = admin.getTitleField().getText();
                String year = admin.getYearField().getText();
                String price = admin.getPriceField().getText();
                DVD dvd = new DVD (title, Integer.parseInt(year), Double.parseDouble(price));
                try {
                    String reply = emitLog.emitMessage(dvd.toString());
                    admin.getMessageAree().setText(reply);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
