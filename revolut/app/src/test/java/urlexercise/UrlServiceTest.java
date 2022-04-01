package urlexercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UrlServiceTest {

    private final UrlService urlService = new UrlService();

    public static Stream<Arguments> scenarioProvider() {
        return Stream.of(
                Arguments.of("MY-NEW-WS", "http://short.com/MY-NEW-WS"),
                Arguments.of("POTATO", "http://short.com/POTATO")
        );
    }

    @ParameterizedTest
    @MethodSource("scenarioProvider")
    void givenUrlAndSeo_whenGenerateUrl_thenUrlAsExpected(String seo, String expectedUrl) {
        String actualUrl = urlService.urlGenerator("http://looooong.com/somepath", seo);

        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    void givenUrlIsNull_whenGenerateUrl_thenThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> urlService.urlGenerator(null, "POTATO"));
    }

    @Test
    void givenInvalidUrl_whenGenerateUrl_thenThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> urlService.urlGenerator("/some-url", "POTATO"));
    }

    @Test
    void givenSeoWithMoreThan20Chars_whenGenerateUrl_thenThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> urlService.urlGenerator("http://looooong.com/somepath",
                        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }

    @Test
    void givenUrlAndSeo_whenShortenUrl_thenPathHasToBe4CharsLong() {
        String actualUrl = urlService.shortenString("http://looooong.com/somepath");

        String path = actualUrl.substring(actualUrl.lastIndexOf("/") + 1);
        Assertions.assertEquals(4, path.length());
    }


    @Test
    void givenUrlAndSeo_whenShortenUrl_thenPathHasToBeAlphanumeric() {
        String actualUrl = urlService.shortenString("http://looooong.com/somepath");
        System.out.println(actualUrl);

        String path = actualUrl.substring(actualUrl.lastIndexOf("/") + 1);

        Assertions.assertTrue(path.matches("^[a-zA-Z0-9]{4}$"));
    }


}
