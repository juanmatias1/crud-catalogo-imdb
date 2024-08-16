import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        setTitle("Cadastrar Usuário");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Nome:");
        userLabel.setBounds(30, 30, 100, 30);
        JTextField userField = new JTextField();
        userField.setBounds(130, 30, 130, 30);

        JLabel passLabel = new JLabel("Senha:");
        passLabel.setBounds(30, 70, 100, 30);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(130, 70, 130, 30);

        JLabel confirmPassLabel = new JLabel("Confirme Senha:");
        confirmPassLabel.setBounds(30, 110, 100, 30);
        JPasswordField confirmPassField = new JPasswordField();
        confirmPassField.setBounds(130, 110, 130, 30);

        JButton registerButton = new JButton("Cadastrar");
        registerButton.setBounds(90, 160, 120, 30);

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(confirmPassLabel);
        add(confirmPassField);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                String confirmPassword = new String(confirmPassField.getPassword());
                if (password.equals(confirmPassword)) {
                    if (UserManager.authenticate(username, password)) {
                        JOptionPane.showMessageDialog(null, "Usuário já existe");
                    } else {
                        UserManager.registerUser(username, password);
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senhas não coincidem");
                }
            }
        });

        setVisible(true);
    }
}
