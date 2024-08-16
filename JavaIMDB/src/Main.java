import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BuscaFilmes-AdaB3");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 200, 100, 30);
        JButton registerButton = new JButton("Cadastrar");
        registerButton.setBounds(200, 200, 100, 30);

        frame.add(loginButton);
        frame.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame();
            }
        });

        frame.setVisible(true);
    }
}
