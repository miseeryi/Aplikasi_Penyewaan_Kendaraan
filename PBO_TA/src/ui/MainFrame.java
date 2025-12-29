package ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Rental Kendaraan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Customer", new CustomerPanel());
        tabs.addTab("Vehicle", new VehiclePanel());
        tabs.addTab("Rental", new RentalPanel());
        add(tabs);
    }
}