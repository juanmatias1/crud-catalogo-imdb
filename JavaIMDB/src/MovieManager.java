import java.io.*;
import java.util.*;

public class MovieManager {
    private static final String MOVIES_FILE = "filmes.txt";

    public static void addMovie(Movie movie) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(MOVIES_FILE, true))) {
            writer.println(movie.getName() + ";" + movie.getActors() + ";" + movie.getReleaseDate() + ";" + movie.getGenre());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Movie> listMovies() {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MOVIES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                movies.add(new Movie(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        movies.sort(Comparator.comparing(Movie::getName));
        return movies;
    }

    public static boolean movieExists(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(MOVIES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equals(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
