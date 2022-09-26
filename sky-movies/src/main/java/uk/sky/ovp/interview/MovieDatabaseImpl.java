package uk.sky.ovp.interview;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieDatabaseImpl implements MovieDatabase {

    private final String filePath;

    public MovieDatabaseImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        Stream<Movie> movies = getMovieStream();
        return movies.filter(m -> m.getTitle().equals(title)).findFirst();
    }

    private Stream<Movie> getMovieStream() {
        try {
            return MovieReader.getMovies(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Movie> fuzzyMatch(String titleRegexp) {
        Stream<Movie> movies = getMovieStream();
        return movies.filter(movie -> isMatching(titleRegexp, movie.getTitle()))
            .collect(Collectors.toList());
    }

    private boolean isMatching(String regex, String title) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(title).find();
    }

    @Override
    public Collection<Movie> findByGenres(String... genres) {
        return null;
    }

    @Override
    public Collection<Movie> findByGenres(GenreQuery query) {
        return null;
    }
}
