package uk.sky.ovp.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;

class MovieDatabaseTest {
    private final MovieDatabase movieDatabase = new MovieDatabaseImpl("src/main/resources/movies.json");

    @Test
    void givenExistingMovie_ShouldFindByNameWorkScenario() {
        Optional<Movie> movie = movieDatabase.findByTitle("Matrix Interest Civility");
        Assertions.assertTrue(movie.isPresent());
        Assertions.assertEquals("Matrix Interest Civility", movie.get().getTitle());
    }

    @Test
    void givenNonExistingMovieName_ShouldReturnEmptyOptional() {
        Optional<Movie> movie = movieDatabase.findByTitle("non-existing movie title");
        Assertions.assertFalse(movie.isPresent());
    }

    @Test
    void whenFilePathIsIncorrect_ShouldThrowIOException() {
        MovieDatabase movieDatabase = new MovieDatabaseImpl("/non-existing/path");
        Assertions.assertThrows(RuntimeException.class, () -> movieDatabase.findByTitle("Matrix Interest Civility"));
    }


    @Test
    void givenFuzzyRegExp_ShouldFindAllMovieMatchingSuccessfully() {
        String regExp = "/^(.*?(\\bMatrix\\b)[^$]*)$/gm";
        Collection<Movie> movies = movieDatabase.fuzzyMatch(regExp);
        Assertions.assertFalse(movies.isEmpty());
        System.out.println(movies);
    }
}
