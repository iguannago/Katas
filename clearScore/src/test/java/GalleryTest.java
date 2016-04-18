import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 18/04/2016.
 */
public class GalleryTest {

    private Gallery gallery = new GalleryImpl();

    @Test
    public void addArtTest() {
        Art art = new Art.Builder("Guernica", ArtType.PAINTING, "Pablo Picasso", LocalDateTime.now()).build();
        assertEquals(0, gallery.getAllArts().size());
        System.out.println(gallery);
        gallery.addArt(art);
        assertEquals(1, gallery.getAllArts().size());
        System.out.println(gallery);
        gallery.addArt(art);
        assertEquals(1, gallery.getAllArts().size());
        System.out.println(gallery);
    }

    @Test
    public void getAllArtsTest() {
        Set<Art> artList = gallery.getAllArts();
        assertNotNull(artList);
    }

}
