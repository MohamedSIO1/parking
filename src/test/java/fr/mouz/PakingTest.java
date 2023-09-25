package fr.mouz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PakingTest {

    @Test
    // le paterne : contexte_methodeSousTest_resultat()
    public void vehiculeAutorisesVide_ajouterVehiculeAutorisee_devraitAjouterLeVehicule() {
        // AAA : Arrange(préparer), Act(agir), Assert(vérifier)

        // Arrange : je mets en place mon test, notamment en instaciant et initialisant
        // le ou les objets concernés

        Parking parking = new Parking(0);

        // Act : j'appelle la méthode qui est sous test

        parking.ajouterVehiculeAutorisee("ABC-123");

        // Assert: je vérifie que tout s'est passé comme prévu

        assertEquals(1, parking.getTailleVehiculesAutorises(), "Je devrais avoir exactement un véhicule autorisé");
    }

    @Test
    public void vehiculeAutoriseDansLaliste_ajouterLeMemeVehiculeAutorise_devraitNePasEtreAjouter() {
        Parking parking = new Parking(0);
        parking.ajouterVehiculeAutorisee("ABC-123");

        parking.ajouterVehiculeAutorisee("ABC-123");

        assertEquals(1, parking.getTailleVehiculesAutorises(), "Je devrais avoir exactement un véhicule autorisé");

    }

    @Test
    public void vehiculeAutorise_enregistrerEntreeVehicule_devraitRentrer() {
        Parking parking = new Parking(1);
        parking.ajouterVehiculeAutorisee("ABC-123");

        parking.enregistrerEntreeVehicule("ABC-123");

        assertEquals(1, parking.getTailleVehiculesStationnes(), "Le véhicule devrait pouvoir rentrer");

    }

    @Test
    public void parkingVide_getNombreVehiculesStationnes_AfficheUn() {
        Parking parking = new Parking(1);
        parking.ajouterVehiculeAutorisee("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");
        assertEquals(1, parking.getNombreVehiculesStationnes());

    }

    @Test
    public void deuxVehiculesDansParking_getNombreVehiculesStationnes_AfficheDeux() {
        Parking parking = new Parking(2); // Crée un parking avec une capacité de 2
        parking.ajouterVehiculeAutorisee("ABC-123"); // Ajoute la première Vehicule autorisée
        parking.ajouterVehiculeAutorisee("XYZ-789"); // Ajoute la deuxième Vehicule autorisée

        parking.enregistrerEntreeVehicule("ABC-123"); // Enregistre l'entrée du premier véhicule
        parking.enregistrerEntreeVehicule("XYZ-789"); // Enregistre l'entrée du deuxième véhicule

        assertEquals(2, parking.getNombreVehiculesStationnes()); // Vérifie que le nombre de véhicules
                                                                 // stationnés est égal à 2
    }

    /**
     * 
     */
    @Test
    public void testAfficherTauxDeRemplissageParkingVide() {
        Parking parking = new Parking(0); // Parking vide parking.afficherTauxDeRemplissage();
        parking.ajouterVehiculeAutorisee("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");
        parking.ajouterVehiculeAutorisee("EDC-789");
        parking.enregistrerEntreeVehicule("EDC-789");

        parking.afficherTauxDeRemplissage();

        assertEquals(100.0, parking.afficherTauxDeRemplissage());
    }

    @Test
    public void testAfficherTauxDeRemplissageParkingPlein() {
        Parking parking = new Parking(2); // Parking plein (capacité de 100)
        parking.ajouterVehiculeAutorisee("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");
        parking.ajouterVehiculeAutorisee("EDC-789");
        parking.enregistrerEntreeVehicule("EDC-789");

        parking.afficherTauxDeRemplissage();

        assertEquals(100.0, parking.afficherTauxDeRemplissage());
    }

}
