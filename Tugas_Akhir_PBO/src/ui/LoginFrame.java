package ui;

import dao.AdminDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
    private JTextField tfUser = new JTextField(15);
    private JPasswordField pfPass = new JPasswordField(15);

    public LoginFrame() {
        setTitle("Admin Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 180);
        setLocationRelativeTo(null);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> doLogin());

        JPanel p = new JPanel(new GridLayout(3,2,8,8));
        p.add(new JLabel("Username:")); p.add(tfUser);
        p.add(new JLabel("Password:")); p.add(pfPass);
        p.add(new JLabel());            p.add(btnLogin);
        add(p);
    }

    private void doLogin() {
        try {
            boolean ok = new AdminDAO().login(tfUser.getText(), new String(pfPass.getPassword()));
            if (ok) {
                new MainFrame().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Login gagal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}