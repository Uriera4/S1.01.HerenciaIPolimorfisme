package n3exercici1;

public class ExcepcioNomPersonalIncorrecte extends Exception{

    public ExcepcioNomPersonalIncorrecte(){}
    public ExcepcioNomPersonalIncorrecte (String message){
        super(message);
    }
}
