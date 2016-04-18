import java.time.LocalDate;
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
    public Set<String> getArtists() {
        Set<String> artists = new TreeSet<String>();
        for (Art art: arts) {
            artists.add(art.getArtist());
        }
        return artists;
    }

    @Override
    public List<Art> getArtByArtist(String artist) {
        List<Art> artByArtist = new ArrayList<Art>();
        for (Art art: arts) {
            if (art.getArtist().equals(artist)) {
                artByArtist.add(art);
            }
        }
        return artByArtist;
    }

    @Override
    public List<Art> getRecentArt() {
        LocalDate today = LocalDate.now();
        List<Art> artByArtist = new ArrayList<Art>();
        for (Art art: arts) {
            if (today.getYear() - art.getCreated().getYear() == 1) {
                artByArtist.add(art);
            }
        }
        return artByArtist;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "arts=" + arts +
                '}';
    }
}
