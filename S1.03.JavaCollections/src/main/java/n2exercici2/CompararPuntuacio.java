package n2exercici2;

import n2exercici1.Restaurant;
import java.util.Comparator;

public class CompararPuntuacio implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant r1, Restaurant r2) {
        return r1.getPuntuacio()-r2.getPuntuacio();
    }
}
