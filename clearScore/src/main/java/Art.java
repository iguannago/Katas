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

}
