
package plants;



import java.io.Serializable;
import java.time.LocalDate;

public abstract class Plant implements Serializable {

    private String name;
    private LocalDate lastWateredDate;
    private int wateringInterval;

    public Plant(String name, LocalDate lastWateredDate, int wateringInterval) {
        this.name = name;
        this.lastWateredDate = lastWateredDate;
        this.wateringInterval = wateringInterval;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastWateredDate() {
        return lastWateredDate;
    }

    public void setLastWateredDate(LocalDate lastWateredDate) {
        this.lastWateredDate = lastWateredDate;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public LocalDate getNextDueDate() {
        return lastWateredDate.plusDays(wateringInterval);
    }

    public void water() {
        lastWateredDate = LocalDate.now();
    }

    public abstract boolean checkNeedsWatering();
}