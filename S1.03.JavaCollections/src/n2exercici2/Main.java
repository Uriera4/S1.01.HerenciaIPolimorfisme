package n2exercici2;

import n2exercici1.Restaurant;

import java.util.*;

public class Main {
    static HashSet<Restaurant> llistaRestaurants = new HashSet<>();
    public static void main (String[] args){

        llistaRestaurants.add(new Restaurant ("Abac", 10));
        afegeixSiNoExisteix(new Restaurant("Abac", 5));
        afegeixSiNoExisteix(new Restaurant("Enigma", 5));
        afegeixSiNoExisteix(new Restaurant("Xerta", 9));
        afegeixSiNoExisteix(new Restaurant("Abac", 10));

        TreeSet<Restaurant> llistaRestaurantsOrdenada = new TreeSet<>(new CompararNoms());
        llistaRestaurantsOrdenada.addAll(llistaRestaurants);
        imprimeixLlistaFinalOrdenada(llistaRestaurantsOrdenada); //ORDENADA PER NOMS
        System.out.println();
        TreeSet<Restaurant> llistaRestaurantsOrdenada2 = new TreeSet<>(new CompararPuntuacio());
        llistaRestaurantsOrdenada2.addAll(llistaRestaurants);
        imprimeixLlistaFinalOrdenada((TreeSet) llistaRestaurantsOrdenada2.descendingSet()); //ORDENADA PER PUNTUACIO

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
            if ((restaurant.comparaNoms(nouRestaurant)) && restaurant.comparaPuntuacions(nouRestaurant)){
                existeix = true;
            }
        }
        return existeix;
    }
    static void imprimeixLlistaFinalOrdenada (TreeSet<Restaurant> llistaRestaurantsOrdenada){
        for (Restaurant restaurant : llistaRestaurantsOrdenada) {
            System.out.println("Nom: " + restaurant.getNom() + ", Puntuacio: " + restaurant.getPuntuacio() + ".");
        }
    }
}
