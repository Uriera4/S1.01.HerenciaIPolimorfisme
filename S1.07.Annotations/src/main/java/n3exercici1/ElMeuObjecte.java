package n3exercici1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ElMeuObjecte {

    private String atribut1;
    private int atribut2;
    private String atribut3;

    public ElMeuObjecte(){
        atribut1 = "valor1";
        atribut2 = 0;
        atribut3 = "valor3";
    }

    public String getAtribut1() {
        return atribut1;
    }
    public void setAtribut1(String atribut1) {
        this.atribut1 = atribut1;
    }
    public int getAtribut2() {
        return atribut2;
    }
    public void setAtribut2(int atribut2) {
        this.atribut2 = atribut2;
    }
    public String getAtribut3() {
        return atribut3;
    }
    public void setAtribut3(String atribut3) {
        this.atribut3 = atribut3;
    }

    @SerialitzaJSON(rutaDirectori = "src/main/java/n3exercici1/ElMeuObjecte.json")
    public void serialitzaObjecte (){
        try {
            File arxiu = new File (this.getClass().getMethod("serialitzaObjecte",null).getAnnotation(SerialitzaJSON.class).rutaDirectori());
            ObjectOutputStream escriureFitxer = new ObjectOutputStream(new FileOutputStream(arxiu));
            escriureFitxer.writeObject(arxiu);
            escriureFitxer.close();
            System.out.println("L'objecte ha estat serialitzat");
        } catch (IOException | NoSuchMethodException e) {
            System.out.println("Error al serialitzar l'objecte");
        }
    }
}
