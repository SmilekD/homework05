import java.time.LocalDateTime;

public class Plant implements Comparable<Plant>{
    private String name;
    private String notes;
    private LocalDateTime planted;
    private LocalDateTime watering;
    private int frequencyOfWatering;

    // KONSTRUKTORY //////////////////////////////////////
    public Plant(String name, String notes, LocalDateTime planted,
                 LocalDateTime watering, int frequencyOfWatering)
            throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        setWatering(watering);
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name,LocalDateTime planted,int frequencyOfWatering) throws PlantException {
        this(name,"",planted,LocalDateTime.now(),frequencyOfWatering);
    }

    public Plant(String name) throws PlantException {
        this(name,"",LocalDateTime.now(),LocalDateTime.now(),7);
    }

    // MOJE METODY ////////////////////////////////////////
    public String getWateringinfo(){
        LocalDateTime future = watering.plusDays(frequencyOfWatering);

        String wateringInfo = "Název květiny: "+name+"\n"+"Datum poslední zálivky: "
                +watering+"\n"+"Datum doporučené další zálivy: "+future;
        return wateringInfo;
    }

    // PŘÍSTUPOVÉ METODY ///////////////////////////////////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDateTime planted) {
        this.planted = planted;
    }

    public LocalDateTime getWatering() {
        return watering;
    }

    public void setWatering(LocalDateTime watering) throws PlantException {
        if (watering.isBefore(planted)){
            throw new PlantException("Datum poslední zálivky nemůže být starší než datum" +
                    " zasazení rostliny !");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0){
            throw new PlantException("Zadávaná frekvence zalévání" +
                    "musí být větší než 0 !!");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    @Override
    public int compareTo(Plant otherPlant) {
        return this.name.compareTo(otherPlant.name);
    }

    @Override
    public String toString() {
        return "Název: "+ name + '\n' +
                "poznámka: " + notes + '\n' +
                "zasazena: " + planted +"\n"+
                "zalita: " + watering +"\n"+
                "frekvence zalévání: " + frequencyOfWatering;
    }
}

