
package plants;


import java.time.LocalDate;

public class Succulent extends Plant {

    public Succulent(String name, LocalDate lastWateredDate) {
        super(name, lastWateredDate, 7);
    }

    @Override
    public boolean checkNeedsWatering() {
        return LocalDate.now().isAfter(getNextDueDate())
                || LocalDate.now().isEqual(getNextDueDate());
    }
}