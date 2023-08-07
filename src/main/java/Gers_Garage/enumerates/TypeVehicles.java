package Gers_Garage.enumerates;

public enum TypeVehicles {

    SEDAN("Sedan"),
    HATCH("Hatch"),
    CONVERTIBLE("Convertible"),
    MINIVAN("Minivan"),
    MINIBUS ("Minibus"),
    MOTORBIKE ("Motorbike");

    private String displayType;

    private TypeVehicles(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }
}
