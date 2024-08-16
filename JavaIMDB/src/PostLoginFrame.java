import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostLoginFrame extends JFrame {
    public PostLoginFrame() {
        setTitle("Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton listMoviesButton = new JButton("Listar Filmes");
        listMoviesButton.setBounds(50, 50, 150, 30);
        JButton addMovieButton = new JButton("Cadastrar Filme");
        addMovieButton.setBounds(50, 100, 150, 30);

        add(listMoviesButton);
        add(addMovieButton);

        listMoviesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListMoviesFrame();
            }
        });

        addMovieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddMovieFrame();
            }
        });

        setVisible(true);
    }
}
