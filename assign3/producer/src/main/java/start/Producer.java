package start;

import gui.AdminController;

public class Producer {
    public static void main(String[] argv) throws Exception {
        AdminController adminController = new AdminController();
        adminController.setupControl();
    }
}
