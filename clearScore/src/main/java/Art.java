import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by davicres on 18/04/2016.
 */
public class Art {
    private final BigDecimal askingPrice;
    private final String name;
    private final ArtType type;
    private final String artist;
    private final LocalDateTime created;

    private Art(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.artist = builder.artist;
        this.created = builder.created;
        this.askingPrice = builder.askingPrice;
    }

    public static class Builder {
        //mandatory parameters
        private final String name;
        private final ArtType type;
        private final String artist;
        private final LocalDateTime created;
        //Optional parameters
        private BigDecimal askingPrice;

        public Builder(String name, ArtType type, String artist, LocalDateTime created) {
            this.name = name;
            this.type = type;
            this.artist = artist;
            this.created = created;
        }

        public Builder askingPrice(BigDecimal askingPrice) {
            this.askingPrice = askingPrice;
            return this;
        }

        public Art build() {
            return new Art(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Art art = (Art) o;

        if (!name.equals(art.name)) return false;
        if (type != art.type) return false;
        return artist.equals(art.artist);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + artist.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Art{" +
                "askingPrice=" + askingPrice +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", artist='" + artist + '\'' +
                ", created=" + created +
                '}';
    }
}
