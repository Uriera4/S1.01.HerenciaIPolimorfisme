package n1exercici2;

public class CalculDni {

    private final int numerosDNI;
    private final char lletraDNI;
    private final String dni;

    public CalculDni (String dni){
        numerosDNI = Integer.parseInt(dni.substring(0,8));
        lletraDNI = retornaLletraDNI();
        this.dni= String.valueOf(numerosDNI)+lletraDNI;
    }

    public char retornaLletraDNI (){
        final String [] lletresDNI = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int residu = numerosDNI % 23;
        return lletresDNI[residu].charAt(0);
    }
    public String getDni() {
        return dni;
    }

}
