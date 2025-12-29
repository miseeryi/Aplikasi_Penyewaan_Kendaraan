package ui;

import dao.RentalDAO;
import dao.VehicleDAO;
import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class RentalPanel extends JPanel {
    private JTextField tfCustomerId = new JTextField(5);
    private JTextField tfVehicleId = new JTextField(5);
    private JTextField tfStart = new JTextField(10); // format: YYYY-MM-DD
    private JTextField tfEnd = new JTextField(10);
    private JTable tblAvailable = new JTable(new DefaultTableModel(new Object[]{"ID","Plate","Brand","Rate"}, 0));
    private VehicleDAO vdao = new VehicleDAO();
    private RentalDAO rdao = new RentalDAO();

    public RentalPanel() {
        setLayout(new BorderLayout(8,8));

        JPanel form = new JPanel(new GridLayout(2,5,8,8));
        form.add(new JLabel("Customer ID")); form.add(tfCustomerId);
        form.add(new JLabel("Vehicle ID"));  form.add(tfVehicleId);
        JButton btnRent = new JButton("Create Rental"); form.add(btnRent);

        form.add(new JLabel("Start (YYYY-MM-DD)")); form.add(tfStart);
        form.add(new JLabel("End (YYYY-MM-DD)"));   form.add(tfEnd);
        JButton btnLoad = new JButton("Load Available"); form.add(btnLoad);

        btnLoad.addActionListener(e -> loadAvailable());
        btnRent.addActionListener(e -> createRental());

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tblAvailable), BorderLayout.CENTER);
        loadAvailable();
    }

    private void loadAvailable() {
        try {
            DefaultTableModel m = (DefaultTableModel) tblAvailable.getModel();
            m.setRowCount(0);
            List<Vehicle> list = vdao.getAvailable();
            for (Vehicle v : list) {
                m.addRow(new Object[]{v.getId(), v.getPlateNumber(), v.getBrand(), v.getDailyRate()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createRental() {
        try {
            int cid = Integer.parseInt(tfCustomerId.getText());
            int vid = Integer.parseInt(tfVehicleId.getText());
            LocalDate s = LocalDate.parse(tfStart.getText());
            LocalDate e = LocalDate.parse(tfEnd.getText());
            BigDecimal dailyRate = vdao.getAvailable().stream()
                    .filter(v -> v.getId() == vid)
                    .findFirst()
                    .map(Vehicle::getDailyRate)
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle rate not found"));

            boolean ok = rdao.createRental(cid, vid, s, e, dailyRate);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Rental dibuat");
                loadAvailable();
            } else {
                JOptionPane.showMessageDialog(this, "Kendaraan tidak tersedia", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}