
package manager;

import java.io.*;
import plants.Plant;
import java.util.ArrayList;
import java.util.List;

public class PlantManager {
    private final String FILE_NAME = "plants.dat";
    private List<Plant> plants;
    private static PlantManager instance;
    private PlantManager() {
    loadPlants();
}
    public static PlantManager getInstance() {

    if (instance == null) {
        instance = new PlantManager();
    }

    return instance;
}
    public void savePlants() {

    try {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME)
        );

        out.writeObject(plants);

        out.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}


@SuppressWarnings("unchecked")
public void loadPlants() {

    try {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(FILE_NAME)
        );

        plants = (List<Plant>) in.readObject();

        in.close();

    } catch (FileNotFoundException e) {
        
        plants = new ArrayList<>();

    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
        plants = new ArrayList<>();
    }
}

    public void addPlant(Plant plant) {

    plants.add(plant);

    savePlants();
}

    public void removePlant(Plant plant) {

    plants.remove(plant);

    savePlants();
}
    public List<Plant> getAllPlants() {
        return plants;
    }

    public List<Plant> searchPlant(String keyword) {

        List<Plant> result = new ArrayList<>();

        for (Plant plant : plants) {

            if (plant.getName().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                result.add(plant);
            }
        }

        return result;
    }
}
