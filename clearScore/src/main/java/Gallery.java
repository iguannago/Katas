import java.util.List;
import java.util.Set;

/**
 * Created by davicres on 18/04/2016.
 */
public interface Gallery {
    void addArt(Art art);

    Set<Art> getAllArts();

    void deleteArt(Art art);

    List<String> getArtists();


    List<Art> getArtByArtist(String artist);
}
