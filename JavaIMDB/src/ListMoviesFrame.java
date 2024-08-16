import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListMoviesFrame extends JFrame {
    public ListMoviesFrame() {
        setTitle("Listar Filmes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JTextArea moviesArea = new JTextArea();
        moviesArea.setBounds(30, 70, 400, 250);
        moviesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(moviesArea);
        scrollPane.setBounds(30, 70, 400, 250);

        JLabel searchLabel = new JLabel("Buscar:");
        searchLabel.setBounds(30, 30, 100, 30);
        JTextField searchField = new JTextField();
        searchField.setBounds(80, 30, 200, 30);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(290, 30, 100, 30);

        add(searchLabel);
        add(searchField);
        add(searchButton);
        add(scrollPane);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().toLowerCase();
                List<Movie> movies = MovieManager.listMovies();
                StringBuilder sb = new StringBuilder();
                for (Movie movie : movies) {
                    if (movie.getName().toLowerCase().contains(searchTerm)) {
                        sb.append(movie).append("\n");
                    }
                }
                moviesArea.setText(sb.toString());
            }
        });

        setVisible(true);
    }
}
