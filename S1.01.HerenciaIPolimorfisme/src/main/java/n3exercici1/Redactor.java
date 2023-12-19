package n3exercici1;

import java.util.ArrayList;
public class Redactor {

    public String nom;
    final private String DNI;
    static int sou;
    public ArrayList<Noticia> llistaNoticies;

    public Redactor (String nom, String DNI){
        this.nom = nom;
        this.DNI = DNI;
        sou = 1500;
        llistaNoticies = new ArrayList<>();
    }

    public void afegeixNoticia (Noticia novaNoticia){
        llistaNoticies.add(novaNoticia);
    }
    public void eliminaNoticia (int index){
        llistaNoticies.remove(index);
    }
    public int tamanyLlistaNoticies (){
        return llistaNoticies.size();
    }
    public Noticia seleccionaNoticia(int i){
        return llistaNoticies.get(i);
    }
    public String seleccionaTitularNoticia(int i){
        return llistaNoticies.get(i).getTitular();
    }

    public boolean compararDNI (String DNI) {
        return this.DNI.equalsIgnoreCase(DNI);
    }
    public int retornaIndexNoticia (String titular){
        int index = 0;
        while (index<llistaNoticies.size() && !llistaNoticies.get(index).comparaTitulars(titular)) {
            index++;
        }
        return index;
    }

    public String getNom (){
        return nom;
    }
    public double getSou (){
        return sou;
    }
    public void setSou (int sou){
        Redactor.sou = sou;
    }
}

