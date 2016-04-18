import java.util.HashSet;
import java.util.Set;

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
    public String toString() {
        return "Gallery{" +
                "arts=" + arts +
                '}';
    }
}
