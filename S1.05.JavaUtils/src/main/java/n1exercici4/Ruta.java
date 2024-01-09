package n1exercici4;

import java.io.File;
import java.util.Scanner;

public class Ruta {
    private File ruta;
    private File rutaArxiu;

    public Ruta (File ruta){
        this.ruta = ruta;
    }
    public Ruta (String missatge){
        demanaRutaDirectori(missatge);
    }

    private void demanaRutaDirectori (String missatge){
        do{
            ruta = new File(demanaString(missatge));
            if (!ruta.isDirectory()){
                System.out.println("La ruta indicada no existeix o no correspon a un directori.");
                ruta = null;
            }
        }while (ruta==null);
    }
    private void demanaRutaFitxer (String missatge){
        rutaArxiu = new File(ruta.getAbsolutePath() + "/" +demanaString(missatge));
        if (!rutaArxiu.isFile() && !rutaArxiu.getName().toLowerCase().endsWith(".txt")){
            System.out.println("La ruta indicada no existeix o no correspon a un fitxer TXT.");
            rutaArxiu=null;
        }
    }

    public File getRuta(){
        return ruta;
    }
    public File getRutaArxiu(){
        return rutaArxiu;
    }
    public void afageixRutaArxiu (String missatge){
        demanaRutaFitxer(missatge);
    }

    private String demanaString (String missatge) {
        Scanner input = new Scanner (System.in);
        System.out.print(missatge);
        return input.nextLine();
    }
}
