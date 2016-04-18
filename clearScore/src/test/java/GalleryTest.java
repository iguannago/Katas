import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 18/04/2016.
 */
public class GalleryTest {

    private Gallery gallery = new GalleryImpl();
    private Art art1 = new Art.Builder("Guernica", ArtType.PAINTING, "Pablo Picasso", LocalDateTime.now()).build();
    private Art art2 = new Art.Builder("Guernica fake", ArtType.PAINTING, "David Crespo", LocalDateTime.now()).build();

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
        gallery.addArt(art1);
        gallery.addArt(art2);
        List<String> artistNames = gallery.getArtists();
        assertEquals("[David Crespo, Pablo Picasso]", artistNames.toString());
    }





}
