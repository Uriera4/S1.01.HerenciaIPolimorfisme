package n2exercici2;

import n2exercici1.Restaurant;

import java.util.*;

public class Main {
    static HashSet<Restaurant> llistaRestaurants = new HashSet<>();

    public static void main (String[] args){

        llistaRestaurants.add(new Restaurant ("Abac", 10));
        ompleLlistaHash();

        ArrayList<Restaurant> llistaRestaurantsOrdenada = new ArrayList<>(llistaRestaurants);

        ordenaEimprimeixLlista(llistaRestaurantsOrdenada, new CompararNoms());
        System.out.println();
        ordenaEimprimeixLlista(llistaRestaurantsOrdenada, new CompararPuntuacio().reversed());

    }
    static void ompleLlistaHash (){
        afegeixSiNoExisteix(new Restaurant("Abac", 5));
        afegeixSiNoExisteix(new Restaurant("Enigma", 5));
        afegeixSiNoExisteix(new Restaurant("Xerta", 9));
        afegeixSiNoExisteix(new Restaurant("Abac", 10));
    }
    static void afegeixSiNoExisteix (Restaurant nouRestaurant){
        boolean existeix = comprovaSiExisteix(nouRestaurant);
        if (!existeix){
            llistaRestaurants.add(nouRestaurant);
        }
    }
    static boolean comprovaSiExisteix (Restaurant nouRestaurant){
        boolean existeix = false;
        for (Restaurant restaurant : llistaRestaurants){
            if (restaurant.equals(nouRestaurant)){
                existeix = true;
            }
        }
        return existeix;
    }

    static void ordenaEimprimeixLlista (ArrayList<Restaurant> llista, Comparator<Restaurant> restaurant){
        llista.sort(restaurant);
        imprimeixLlistaFinalOrdenada(llista);
    }
    static void imprimeixLlistaFinalOrdenada (ArrayList<Restaurant> llista){
        for (Restaurant restaurant : llista) {
            System.out.println("Nom: " + restaurant.getNom() + ", Puntuacio: " + restaurant.getPuntuacio() + ".");
        }
    }
}
