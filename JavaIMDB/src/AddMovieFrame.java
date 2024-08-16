import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMovieFrame extends JFrame {
    public AddMovieFrame() {
        setTitle("Cadastrar Filme");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Nome do Filme:");
        nameLabel.setBounds(30, 30, 150, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 30, 150, 30);

        JLabel actorsLabel = new JLabel("Atores:");
        actorsLabel.setBounds(30, 70, 150, 30);
        JTextField actorsField = new JTextField();
        actorsField.setBounds(180, 70, 150, 30);

        JLabel releaseDateLabel = new JLabel("Data de Lançamento:");
        releaseDateLabel.setBounds(30, 110, 150, 30);
        JTextField releaseDateField = new JTextField();
        releaseDateField.setBounds(180, 110, 150, 30);

        JLabel genreLabel = new JLabel("Gênero:");
        genreLabel.setBounds(30, 150, 150, 30);
        JTextField genreField = new JTextField();
        genreField.setBounds(180, 150, 150, 30);

        JButton addButton = new JButton("Adicionar Filme");
        addButton.setBounds(100, 200, 150, 30);

        add(nameLabel);
        add(nameField);
        add(actorsLabel);
        add(actorsField);
        add(releaseDateLabel);
        add(releaseDateField);
        add(genreLabel);
        add(genreField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String actors = actorsField.getText();
                String releaseDate = releaseDateField.getText();
                String genre = genreField.getText();
                
                if (MovieManager.movieExists(name)) {
                    JOptionPane.showMessageDialog(null, "Filme já cadastrado");
                } else {
                    MovieManager.addMovie(new Movie(name, actors, releaseDate, genre));
                    JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso");
                    dispose();
                }
            }
        });

        setVisible(true);
    }
}
