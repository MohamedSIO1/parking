package fr.mouz;

public class App {
    
    public static void main(String[] args) {
        Vehicule vehicule1 = new Vehicule("ABC-123");

        Parking parking = new Parking(500);
        parking.ajouterVehiculeAutorisee("DCE-123");
    }
    
}
