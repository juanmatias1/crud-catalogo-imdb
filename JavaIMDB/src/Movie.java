public class Movie {
    private String name;
    private String actors;
    private String releaseDate;
    private String genre;

    public Movie(String name, String actors, String releaseDate, String genre) {
        this.name = name;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getActors() {
        return actors;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Atores: %s, Data de Lançamento: %s, Gênero: %s",
                             name, actors, releaseDate, genre);
    }
}
