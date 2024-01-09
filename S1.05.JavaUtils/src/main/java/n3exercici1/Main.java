package n3exercici1;

import java.io.File;

public class Main {

    public static void main (String[] args){

        EncriptadorAES encriptador = new EncriptadorAES();

        encriptador.encriptaFitxer("src/main/java/n1exercici3/contingutDirectori", ".txt", "Encriptat.txt");
        encriptador.desencriptaFitxer("src/main/java/n1exercici3/contingutDirectori","Encriptat.txt", "Desencriptat.txt");

        encriptador.encriptaFitxer("src/main/java/n1exercici5/contingut", ".ser", "Encriptat.txt");
        encriptador.desencriptaFitxer("src/main/java/n1exercici5/contingut","Encriptat.txt","Desencriptat.ser");

        encriptador.encriptaFitxer("src/main/java/n2exercici1/configuracio", ".properties", "Encriptat.txt");
        encriptador.desencriptaFitxer("src/main/java/n2exercici1/configuracio","Encriptat.txt","Desencriptat.properties");

        encriptador.encriptaFitxer("src/main/java/n2exercici1/contingutDirectoriParametritzat",".txt", "Encriptat.txt");
        encriptador.desencriptaFitxer("src/main/java/n2exercici1/contingutDirectoriParametritzat","Encriptat.txt","Desencriptat.txt");
    }
}
