package urlexercise;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class UrlService {

    private final Random random = new Random();

    public String urlGenerator(String url, String seo) {
        if (seo.length() > 20) {
            throw new IllegalArgumentException();
        }
        try {
            URL newUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
        return "http://short.com/" + seo;
    }

    public String shortenString(String url) {
        String chars = "abcdefghjk12345";

        return "http://short.com/"
                + giveMeRandomChar(chars)
                + giveMeRandomChar(chars)
                + giveMeRandomChar(chars)
                + giveMeRandomChar(chars);
    }

    private char giveMeRandomChar(String chars) {
        return chars.charAt(random.nextInt(chars.length()));
    }
}
