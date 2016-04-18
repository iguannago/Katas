import java.math.BigDecimal;
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
        List<Art> recentArts = new ArrayList<Art>();
        for (Art art: arts) {
            if (isArtFromPreviousYear(today, art)) {
                recentArts.add(art);
            }
        }
        return recentArts;
    }

    @Override
    public List<Art> getArtByPrice(BigDecimal upperPrice, BigDecimal lowerPrice) {
        List<Art> artByPrice = new ArrayList<Art>();
        for (Art art: arts) {
            if ((art.getAskingPrice() != null)&&
                    IsArtPriceBetweenUpperAndLowerPrice(upperPrice, lowerPrice, art.getAskingPrice())) {
                artByPrice.add(art);
            }
        }
        return artByPrice;
    }

    private boolean IsArtPriceBetweenUpperAndLowerPrice(BigDecimal upperPrice, BigDecimal lowerPrice,
                                                        BigDecimal artPrice) {
        return (artPrice.compareTo(lowerPrice) == 1)&&(artPrice.compareTo(upperPrice) == -1);
    }

    private boolean isArtFromPreviousYear(LocalDate today, Art art) {
        return today.getYear() - art.getCreated().getYear() == 1;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "arts=" + arts +
                '}';
    }
}
