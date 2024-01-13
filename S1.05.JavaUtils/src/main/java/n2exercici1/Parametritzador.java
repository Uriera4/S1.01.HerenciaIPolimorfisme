package n2exercici1;

import n1exercici1.ContingutDirectori;
import n1exercici4.Ruta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Parametritzador {

    private static Properties propietats = new Properties();
    private static File file = new File ("");
    private static boolean parametritzacio = false;

    private ContingutDirectori contingut;

    public Parametritzador (){
        try{
            propietats.load(new FileInputStream("src/main/java/n2exercici1/configuracio.properties"));
            contingut = new ContingutDirectori(file.getAbsolutePath()+propietats.getProperty("ruta"));
            parametritzacio = true;
        } catch (IOException e) {
            contingut = new ContingutDirectori((new Ruta("Introdueixi la ruta de l'arbre de directoris a mostrar: ")));
        }
    }

    public ContingutDirectori getContingut (){
        return contingut;
    }
    public File getFile (){
        return file;
    }
    public Properties getPropietats (){
        return propietats;
    }
    public boolean getParametritzacio (){
        return parametritzacio;
    }

}
