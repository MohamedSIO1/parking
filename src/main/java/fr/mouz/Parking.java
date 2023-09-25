package fr.mouz;

import java.util.ArrayList;

public class Parking {
    private int capaciteMaximale; // La capacité maximale du parking
    private ArrayList<String> vehiculesAutorises; // Un ensemble de véhicules autorisés à stationner
    private ArrayList<String> vehiculesStationnes; // Une liste des véhicules actuellement stationnés

    // Constructeur de la classe Parking
    public Parking(int capacite) {
        capaciteMaximale = capacite; // Initialise la capacité maximale avec la valeur passée en paramètre
        vehiculesAutorises = new ArrayList<>(); // Initialise l'ensemble des véhicules autorisés
        vehiculesStationnes = new ArrayList<>(); // Initialise la liste des véhicules stationnés
    }

    public Parking(double d) {
    }

    public ArrayList<String> getVehiculesAutorises() {
        return vehiculesAutorises;
    }

    public int getTailleVehiculesAutorises() {
        return vehiculesAutorises.size();
    }

    // Méthode pour ajouter un vehicule à la liste des véhicules autorisés
    // public void ajouterVehiculeAutorisee(String immatriculation) {
    // vehiculesAutorises.add(immatriculation); // Ajoute l'immatriculation à
    // l'ensemble des véhicules autorisés
    // }
    public boolean ajouterVehiculeAutorisee(String immatriculation) {
        if (!vehiculesAutorises.contains(immatriculation)) {
            vehiculesAutorises.add(immatriculation);
            return true;
        }
        return false;
    }

    // Méthode pour enregistrer l'entrée d'un véhicule dans le parking
    // public void enregistrerEntreeVehicule(String immatriculation) {
    // Vérifie si l'immatriculation est autorisée et si le parking est plein
    // if (estImmatriculationAutorisee(immatriculation) && !estParkingPlein()) {
    // vehiculesStationnes.add(immatriculation); // Ajoute l'immatriculation à la
    // liste des véhicules stationnés
    // }
    // }
    public boolean enregistrerEntreeVehicule(String immatriculation) {
        // Vérifie si l'immatriculation est autorisée et si le parking est plein
        if (estImmatriculationAutorisee(immatriculation) && !estPlein()) {
            vehiculesStationnes.add(immatriculation); // Ajoute l'immatriculation à la liste des véhicules stationnés
            return true; // Le véhicule a été enregistré avec succès
        }
        return false; // Le véhicule n'a pas été enregistré
    }

    // Méthode pour enregistrer la sortie d'un véhicule du parking
    public void enregistrerSortieVehicule(String immatriculation) {
        vehiculesStationnes.remove(immatriculation); // Supprime l'immatriculation de la liste des véhicules stationnés
    }

    // Méthode pour vérifier si une immatriculation est autorisée à stationner
    public boolean estImmatriculationAutorisee(String immatriculation) {
        return vehiculesAutorises.contains(immatriculation); // Vérifie si l'immatriculation est dans l'ensemble des
                                                             // autorisations

    }

    // Méthode pour vérifier si le parking est plein
    public boolean estPlein() {
        return vehiculesStationnes.size() == capaciteMaximale; // Vérifie si le nombre de véhicules stationnés atteint
                                                               // la capacité maximale

    }

    public int getTailleVehiculesStationnes() {
        return vehiculesStationnes.size();
    }

    // Méthode pour connaître le nombre de véhicules actuellement sur le parking
    public int getNombreVehiculesStationnes() {
        return vehiculesStationnes.size();
    }

    // Méthode pour afficher la liste des véhicules actuellement sur le parking
    public void afficherVehiculesStationnes() {
        System.out.println("Vehicules actuellement stationnés dans le parking: ");
        for (String immatriculation : vehiculesStationnes) {
            System.out.println(immatriculation);
        }
    }

    public void afficherVehiculesAutorises() {
        System.out.println("Vehicules actuellement autorisés: ");
        for (String immatriculation : vehiculesAutorises) {
            System.out.println(immatriculation);
        }
    }

    public float afficherTauxDeRemplissage() {

        if (capaciteMaximale == 0) {

            // psk si le parking a 0 place, forcément il sera au moins rempli à 100%
            return 100;

        } else {

            float tauxDeRemplissage = ((float) vehiculesStationnes.size() / (float) capaciteMaximale) * 100;
            return tauxDeRemplissage;

        }

    }
}
