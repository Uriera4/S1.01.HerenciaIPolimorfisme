package n2exercici1;

import java.util.HashSet;

public class Main {
    static HashSet<Restaurant> llistaRestaurants = new HashSet<>();
    public static void main (String[] args){

        llistaRestaurants.add(new Restaurant ("Abac", 10));
        afegeixSiNoExisteix(new Restaurant("Abac", 5));
        afegeixSiNoExisteix(new Restaurant("Enigma", 10));
        afegeixSiNoExisteix(new Restaurant("Xerta", 9));
        afegeixSiNoExisteix(new Restaurant("Abac", 10)); //NO S'HA AFEGIT
        imprimeixLlistaFinal();
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
    static void imprimeixLlistaFinal (){
        for (Restaurant restaurant : llistaRestaurants) {
            System.out.println(restaurant.getNom() + " " + restaurant.getPuntuacio());
        }
    }

}
