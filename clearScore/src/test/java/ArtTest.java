import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 18/04/2016.
 */
public class ArtTest {
    @Test
    public void artClassTest() {
        String name = "Art name";
        String artist = "Artist name";
        LocalDateTime created = LocalDateTime.now();
        BigDecimal price = new BigDecimal("0.00");
        Art artInstantWithMandatoryParameters = new Art.Builder(name, ArtType.PAINTING, artist, created).build();
        assertNotNull(artInstantWithMandatoryParameters);
        Art artInstantWithMandatoryAndOptional = new Art.Builder(name, ArtType.PAINTING, artist, created).
                askingPrice(price).build();
        assertNotNull(artInstantWithMandatoryAndOptional);
    }
}
