import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by davicres on 18/04/2016.
 */
public interface Gallery {
    void addArt(Art art);

    Set<Art> getAllArts();

    void deleteArt(Art art);

    Set<String> getArtists();


    List<Art> getArtByArtist(String artist);

    List<Art> getRecentArt();

    List<Art> getArtByPrice(BigDecimal upperPrice, BigDecimal lowerPrice);

    List<Art> getArtByPrice();
}
