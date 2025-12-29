package ui;

import dao.CustomerDAO;
import model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class CustomerPanel extends JPanel {
    private JTextField tfName = new JTextField(15);
    private JTextField tfPhone = new JTextField(12);
    private JTextField tfEmail = new JTextField(15);
    private JTextField tfAddress = new JTextField(20);
    private JTable table = new JTable(new DefaultTableModel(new Object[]{"ID","Name","Phone","Email","Address"}, 0));
    private CustomerDAO dao = new CustomerDAO();

    public CustomerPanel() {
        setLayout(new BorderLayout(8,8));
        JPanel form = new JPanel(new GridLayout(2,5,8,8));
        form.add(new JLabel("Name")); form.add(tfName);
        form.add(new JLabel("Phone")); form.add(tfPhone);
        form.add(new JLabel());       JButton btnAdd = new JButton("Add");
        form.add(new JLabel("Email")); form.add(tfEmail);
        form.add(new JLabel("Address")); form.add(tfAddress);
        JButton btnRefresh = new JButton("Refresh");
        form.add(btnAdd); form.add(btnRefresh);

        btnAdd.addActionListener(e -> addCustomer());
        btnRefresh.addActionListener(e -> loadData());

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        loadData();
    }

    private void addCustomer() {
        try {
            Customer c = new Customer(0, tfName.getText(), tfPhone.getText(), tfEmail.getText(), tfAddress.getText());
            dao.insert(c);
            clearForm();
            loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() {
        try {
            DefaultTableModel m = (DefaultTableModel) table.getModel();
            m.setRowCount(0);
            List<Customer> list = dao.getAll();
            for (Customer c : list) {
                m.addRow(new Object[]{c.getId(), c.getName(), c.getPhone(), c.getEmail(), c.getAddress()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        tfName.setText(""); tfPhone.setText(""); tfEmail.setText(""); tfAddress.setText("");
    }
}