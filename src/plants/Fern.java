
package plants;

import java.time.LocalDate;

public class Fern extends Plant {

    public Fern(String name, LocalDate lastWateredDate) {
        super(name, lastWateredDate, 2);
    }

    @Override
    public boolean checkNeedsWatering() {
        return LocalDate.now().isAfter(getNextDueDate())
                || LocalDate.now().isEqual(getNextDueDate());
    }
}
