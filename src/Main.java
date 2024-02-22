import java.time.LocalDateTime;

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
    }
}