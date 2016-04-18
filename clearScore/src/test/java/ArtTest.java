import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by davicres on 18/04/2016.
 */
public class ArtTest {
    @Test
    public void artClassTest() {
        String name = "Art name";
        String artist = "Artist name";
        LocalDate created = LocalDate.now();
        BigDecimal price = new BigDecimal("0.00");
        Art artInstantWithMandatoryParameters = new Art.Builder(name, ArtType.PAINTING, artist, created).build();
        assertNotNull(artInstantWithMandatoryParameters);
        Art artInstantWithMandatoryAndOptional = new Art.Builder(name, ArtType.PAINTING, artist, created).
                askingPrice(price).build();
        assertNotNull(artInstantWithMandatoryAndOptional);
    }

    @Test
    public void twoPiecesOfArtEquivalenceTest() {
        Art art1 = new Art.Builder("Guernica", ArtType.PAINTING, "Pablo Picasso", LocalDate.now()).build();
        Art art2  = new Art.Builder("Guernica", ArtType.PAINTING, "Pablo Picasso", LocalDate.now()).build();
        assertEquals(art1, art2);
        Art art3 = new Art.Builder("Guernica", ArtType.PAINTING, "Pablo Picasso", LocalDate.now()).
                askingPrice(new BigDecimal("100.00")).build();
        assertEquals(art1, art3);
        Art art4  = new Art.Builder("Guernica Draft", ArtType.PAINTING, "Pablo Picasso", LocalDate.now()).build();
        assertNotEquals(art1, art4);
    }
}
