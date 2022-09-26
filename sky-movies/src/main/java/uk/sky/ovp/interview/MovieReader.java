package uk.sky.ovp.interview;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MovieReader {
    public static Stream<Movie> getMovies(final InputStream movieData) throws IOException {
        final JsonFactory factory = new JsonFactory();
        final JsonParser parser = factory.createParser(movieData);
        if (parser.nextToken() != JsonToken.START_ARRAY) {
            throw new IOException("expected file to contain JSON array");
        }
        parser.nextToken();

        final JsonMapper mapper = JsonMapper.builder(factory).build();

        final MappingIterator<Movie> movieIterator = mapper.readerFor(Movie.class).readValues(parser);
        final Spliterator<Movie> movieSpliterator = Spliterators.spliterator(movieIterator, 1, Spliterator.SIZED | Spliterator.IMMUTABLE);

        return StreamSupport.stream(movieSpliterator, false);
    }
}
