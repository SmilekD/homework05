import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Plant plant = new Plant("Fialka","fialová", LocalDateTime.of(2023,5,
                    20,15,20),LocalDateTime.of(2022,3,10,10,10),
                    5);
        } catch (PlantException e) {
            System.err.println("Nastala chyba při ukládání datumů:\n"+e.getLocalizedMessage());
        }
        try {
            Plant plant = new Plant("Fialka","fialová", LocalDateTime.of(2022,5,
                    20,15,20),LocalDateTime.of(2023,3,10,10,10),
                    0);
        } catch (PlantException e) {
            System.err.println("Nastala chyba při ukládání frekvence zalévání:\n"
                    +e.getLocalizedMessage());
        }

        PlantList plantList = new PlantList();
        ///////////// NAČÍTÁNÍ ZE SOUBORU - NEFUNKČNÍ /////////////
        //try {
          //  plantList.loadPlantsfromFile(Settings.getFileName());
        //} catch (PlantException e) {
          //  System.err.println("Nastala chyba při načítání dat ze souborů"+
            //        e.getLocalizedMessage());
        //}

        try {
            plantList.addPlant(new Plant("Růže","červená",
                    LocalDateTime.now(),LocalDateTime.now(),5));
            plantList.addPlant(new Plant("Orchidej","Bílá",
                    LocalDateTime.now(),LocalDateTime.now(),6));
            plantList.addPlant(new Plant("Bazalka","v kuchyni",
                    LocalDateTime.now(),LocalDateTime.now(),3));
            plantList.addPlant(new Plant("Vánoční hvězda","Vánoční",
                    LocalDateTime.now(),LocalDateTime.now(),4));
        } catch (PlantException e) {
            System.err.println("Chyba při přidávání květiny: "+e.getLocalizedMessage());
        }
        plantList.removePlant(0);
        plantList.printWateringInfo();

        try {
            plantList.exportToFile(Settings.getFileNameExport());
        } catch (PlantException e) {
            System.err.println("Chyba při nahrávání květin do souboru: "+
                    e.getLocalizedMessage());
        }
    }
}