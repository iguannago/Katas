package uk.sky.ovp.interview;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Contract for interactions with the movie database service that provides us with enriched and filtered information
 * about sets of movies
 */
public interface MovieDatabase {
    /**
     * Retrieves the first movie whose name matches the name parameter exactly.  There may be no movies that match by
     * this name.
     */
    Optional<Movie> findByTitle(String title);

    /**
     * Retrieves all movies whose name matches the titleRegexp parameter according to the regular expression defined in
     * that parameter.  If no movies are found, this collection will be empty.
     */
    Collection<Movie> fuzzyMatch(String titleRegexp);

    /**
     * Retrieves all movies that have been assigned at least one of the provided genres, ordered in descending order
     * by the number of matching genres.
     */
    Collection<Movie> findByGenres(String... genres);

    /**
     * Retrieves all movies that match the genre query provided, ordered in descending order by the number of
     * matching genres.
     */
    Collection<Movie> findByGenres(GenreQuery query);

    /**
     * Represents a set of genres and the operand that applies to the set, eg. 'categoryA AND categoryB' or
     * 'NOT categoryA categoryB'.
     */
    class GenreQuery {
        private final Set<String> genres;
        private final Operand operand;

        public GenreQuery(Set<String> genres, Operand operand) {
            this.genres = genres;
            this.operand = operand;
        }

        public Set<String> getGenres() {
            return genres;
        }

        public Operand getOperand() {
            return operand;
        }
    }

    enum Operand {
        AND,
        OR,
        NOT,
        XOR
    }
}
