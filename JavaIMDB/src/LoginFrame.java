import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
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

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(30, 110, 100, 30);
        JButton registerButton = new JButton("Cadastrar");
        registerButton.setBounds(160, 110, 100, 30);

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                if (UserManager.authenticate(username, password)) {
                    new PostLoginFrame();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame();
            }
        });

        setVisible(true);
    }
}
