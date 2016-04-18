import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by davicres on 18/04/2016.
 */
public class GalleryTest {

    private Gallery gallery = new GalleryImpl();
    private Art art1 = new Art.Builder("Guernica", ArtType.PAINTING, "Pablo Picasso", LocalDate.of(2015, 01, 14)).build();
    private Art art2 = new Art.Builder("Guernica fake", ArtType.PAINTING, "David Crespo", LocalDate.of(2015, 01, 10)).
            askingPrice(new BigDecimal("14.00")).build();
    private Art art3 = new Art.Builder("Guernica fake 2", ArtType.PAINTING, "David Crespo", LocalDate.now()).
            askingPrice(new BigDecimal("19.00")).build();

    @Test
    public void addArtTest() {
        assertEquals(0, gallery.getAllArts().size());
        System.out.println(gallery);
        gallery.addArt(art1);
        assertEquals(1, gallery.getAllArts().size());
        System.out.println(gallery);
        //assert that i cannot add the same piece of art twice.
        gallery.addArt(art1);
        assertEquals(1, gallery.getAllArts().size());
        System.out.println(gallery);
    }

    @Test
    public void getAllArtsTest() {
        Set<Art> artList = gallery.getAllArts();
        assertNotNull(artList);
    }

    @Test
    public void deleteArtTest() {
        gallery.addArt(art1);
        assertEquals(1, gallery.getAllArts().size());
        gallery.deleteArt(art1);
        assertEquals(0, gallery.getAllArts().size());
        //Assert that I cannot remove a piece of art that does not exit.
        gallery.addArt(art1);
        assertEquals(1, gallery.getAllArts().size());
        gallery.deleteArt(art2);
        assertEquals(1, gallery.getAllArts().size());
    }

    @Test
    public void getArtistsTest() {
        initGallery();
        Set<String> artistNames = gallery.getArtists();
        System.out.println(artistNames);
        Set<String> expected = new HashSet<String>(Arrays.asList("David Crespo", "Pablo Picasso"));
        assertEquals(expected, artistNames);
    }

    @Test
    public void getArtByArtistTest() {
        initGallery();
        List<Art> expectedArtByArtistList = Arrays.asList(art2, art3);
        assertTrue(gallery.getArtByArtist("David Crespo").containsAll(expectedArtByArtistList));
        System.out.println(gallery.getArtByArtist("David Crespo"));
    }

    @Test
    public void getRecentArtTest() {
        initGallery();
        List<Art> expected = Arrays.asList(art1);
        assertTrue(gallery.getRecentArt().containsAll(expected));
        System.out.println(gallery.getRecentArt());
    }

    @Test
    public void getArtByPriceTest(){
        initGallery();
        BigDecimal upperPrice = new BigDecimal("20.00");
        BigDecimal lowerPrice = new BigDecimal("10.00");
        List<Art> arts = gallery.getArtByPrice(upperPrice, lowerPrice);
        System.out.println(arts);
        List<Art> expected = Arrays.asList(art2, art3);
        assertTrue(arts.containsAll(expected));
        //optional parameters
        arts = gallery.getArtByPrice();
        System.out.println(arts);
        assertTrue(arts.containsAll(expected));
    }

    private void initGallery() {
        gallery.addArt(art1);
        gallery.addArt(art2);
        gallery.addArt(art3);
    }



}
