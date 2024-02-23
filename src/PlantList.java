import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
public class PlantList {
    private List<Plant> plants = new ArrayList<>();
    public void addPlant(Plant plant){
        plants.add(plant);
    }
    public Plant getPlant(int index){
        return plants.get(index);
    }
    public void removePlant(int index){
        plants.remove(index);
    }
    public List<Plant> getPlants(){
        return new ArrayList<>(plants);
    }
    public void loadPlantsfromFile(String fileName) throws PlantException{
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                String notes = parts[1];
                int frequencyOfWatering = Integer.parseInt(parts[4]);
                LocalDateTime planted = LocalDateTime.parse(parts[2]);
                LocalDateTime watering = LocalDateTime.parse(parts[3]);
                Plant plant = new Plant(name, notes,planted, watering,frequencyOfWatering);
                plants.add(plant);
            }
        } catch (FileNotFoundException e){
            System.err.println("Nastala chyba při načítání dat "+e.getLocalizedMessage());
        }
    }
    public void exportToFile(String fileName) throws PlantException{
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))){
            for (Plant plant : plants){
                writer.println(plant.getName()+ ","
                + plant.getNotes()+","
                + plant.getPlanted()+","
                + plant.getWatering()+","
                + plant.getFrequencyOfWatering());
            }
        } catch (FileNotFoundException e){
            throw new PlantException("Soubor nebyl nalezen!\n"+e.getLocalizedMessage());
        } catch (IOException e){
            throw new PlantException("Chyba výstupu při zápisu do souboru\n"+e.getLocalizedMessage());
        }
    }
    public void printWateringInfo(){
        for (Plant plant : plants){
            System.out.println(plant.getWateringinfo());
        }
    }
}
