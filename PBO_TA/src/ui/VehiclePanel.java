package ui;

import dao.VehicleDAO;
import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class VehiclePanel extends JPanel {
    private JTextField tfPlate = new JTextField(10);
    private JTextField tfBrand = new JTextField(10);
    private JTextField tfModel = new JTextField(10);
    private JTextField tfYear = new JTextField(4);
    private JTextField tfRate = new JTextField(8);
    private JTable table = new JTable(new DefaultTableModel(new Object[]{"ID","Plate","Brand","Model","Year","Rate","Status"}, 0));
    private VehicleDAO dao = new VehicleDAO();

    public VehiclePanel() {
        setLayout(new BorderLayout(8,8));
        JPanel form = new JPanel(new GridLayout(2,6,8,8));
        form.add(new JLabel("Plate")); form.add(tfPlate);
        form.add(new JLabel("Brand")); form.add(tfBrand);
        form.add(new JLabel("Model")); form.add(tfModel);
        form.add(new JLabel("Year"));  form.add(tfYear);
        form.add(new JLabel("Rate"));  form.add(tfRate);
        JButton btnAdd = new JButton("Add Vehicle");
        JButton btnRefresh = new JButton("Refresh");
        form.add(btnAdd); form.add(btnRefresh);

        btnAdd.addActionListener(e -> addVehicle());
        btnRefresh.addActionListener(e -> loadData());

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        loadData();
    }

    private void addVehicle() {
        try {
            Vehicle v = new Vehicle();
            v.setPlateNumber(tfPlate.getText());
            v.setBrand(tfBrand.getText());
            v.setModel(tfModel.getText());
            v.setYear(tfYear.getText().isBlank() ? null : Integer.parseInt(tfYear.getText()));
            v.setDailyRate(new BigDecimal(tfRate.getText()));
            v.setStatus("AVAILABLE");
            dao.insert(v);
            clear();
            loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Year/Rate tidak valid", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadData() {
        try {
            // untuk demo, ambil semua via SQL sederhana
            // gunakan method getAvailable() bila perlu filter
            // ... 
        } catch (Exception ignored) {}
    }

    private void clear() { tfPlate.setText(""); tfBrand.setText(""); tfModel.setText(""); tfYear.setText(""); tfRate.setText(""); }
}