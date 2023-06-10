package com.una.views;

import com.una.controllers.client.UserController;
import com.una.models.user.UserContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    UserContainer userContainer = new UserContainer();
    UserController userController = new UserController();
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPanel jPanel;
    private JButton loginButton;
    private JButton EXitButton;
    private int loginAttempts = 3;

    public Login() throws Exception {
        setTitle("Login");
        setSize(new Dimension(500, 360));
        setLocationRelativeTo(null);
        setResizable(false);

        setContentPane(jPanel);
        UserContainer userContainer = new UserContainer(); // Inicializar userContainer

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                try {
                    if (userContainer.login(username, password)) {
                        MainWindow window = new MainWindow();
                        window.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Inicio exitoso");
                    } else {
                        loginAttempts--;
                        if (loginAttempts <= 0) {

                            dispose(); // Cerrar la aplicación después de tres intentos fallidos
                        } else {
                            JOptionPane.showMessageDialog(null, "Error " + loginAttempts + " intentos restantes");
                        }
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setVisible(true);
    }
}
