import java.util.*;

/**
 * Created by davicres on 18/04/2016.
 */
public class GalleryImpl implements Gallery {
    Set<Art> arts = new HashSet<Art>();

    @Override
    public void addArt(Art art) {
        arts.add(art);
    }

    @Override
    public Set<Art> getAllArts() {
        return arts;
    }

    @Override
    public void deleteArt(Art art) {
        arts.remove(art);
    }

    @Override
    public List<String> getArtists() {
        List<String> artists = new ArrayList<String>();
        for (Art art: arts) {
            artists.add(art.getArtist());
        }
        Collections.sort(artists);
        return artists;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "arts=" + arts +
                '}';
    }
}
