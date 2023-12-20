package n3exercici1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Cine {

    private int nombreFilesCinema;
    private int nombreSeientsCinema;
    private final GestioButaques novaGestio;

    public Cine (){
        demanarDadesInicials();
        novaGestio = new GestioButaques();
    }

    public void iniciar () {
        int opcio = 0;
        do {
            opcio = OpcioMenu(opcio);
            switch (opcio) {
                case 1:
                    opcioMostrarButaques();
                    break;
                case 2:
                    opcioMostrarButaquesPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    opcioAnularReserva();
                    break;
                case 5:
                    opcioAnularReservaPersona();
                    break;
            }
        } while (opcio != 0);
    }
    private int menu() throws ExcepcioOpcioNoValida {
        System.out.println("""
                MENÚ
                (1). Mostrar totes les butaques reservades
                (2). Mostrar les butaques reserves per una persona
                (3). Reservar una butaca
                (4). Anul·lar una reserva
                (5). Anul·lar les reserves d'una persona
                (0). Sortir""");
        int opcio = demanaInt("Introdueix una opció del menú: ");
        if (opcio<0 || opcio>5){
            throw new ExcepcioOpcioNoValida("Aquesta opció no existeix");
        }
        return opcio;
    }
    private void mostrarButaques () throws ExcepcioNoHiHaReserves{
        if (novaGestio.getButaques().isEmpty()){
            throw new ExcepcioNoHiHaReserves("Aquesta opció no està disponible, encara no hi ha reserves");
        } else {
            for (int i=0; i<novaGestio.getButaques().size(); i++){
                System.out.println(novaGestio.getButaques().get(i).toString());
            }
        }
    }
    private void mostrarButaquesPersona () throws ExcepcioNoHiHaReserves {
        if (novaGestio.getButaques().isEmpty()){
            throw new ExcepcioNoHiHaReserves("Aquesta opció no està disponible, encara no hi ha reserves");
        } else {
            String nomPersona = demanarIntroduirPersona();
            byte comptador = 0;
            for (int i=0; i<novaGestio.getButaques().size(); i++){
                if (novaGestio.getButaques().get(i).getNomPersona().equalsIgnoreCase(nomPersona)) {
                    System.out.println(novaGestio.getButaques().get(i).toString());
                    comptador++;
                }
            }
            if (comptador==0){
                System.out.println(nomPersona + " no té cap seient reservat");
            }
        }
    }
    private void reservarButaca (){
        int numeroFila;
        int numeroSeient;
        String nomPersona = demanarIntroduirPersona();
        boolean reservat;
        do {
            numeroFila = demanarIntroduirFila();
            numeroSeient = demanaIntroduirSeient();
            reservat = opcioAfegirButaca(numeroFila, numeroSeient, nomPersona);
        } while (!reservat);
    }
    private void anularReserva () throws ExcepcioNoHiHaReserves {
        int numeroFila;
        int numeroSeient;
        if (novaGestio.getButaques().isEmpty()){
            throw new ExcepcioNoHiHaReserves("Aquesta opció no està disponible, encara no hi ha reserves");
        } else {
            numeroFila = demanarIntroduirFila();
            numeroSeient = demanaIntroduirSeient();
            opcioEliminarButaca(numeroFila, numeroSeient);
        }
    }
    private void anularReservaPersona () throws ExcepcioNoHiHaReserves {
        if (novaGestio.getButaques().isEmpty()){
            throw new ExcepcioNoHiHaReserves("Aquesta opció no està disponible, encara no hi ha reserves");
        } else {
            String nomPersona = demanarIntroduirPersona();
            byte comptador = 0;
            for (int i=0; i<novaGestio.getButaques().size(); i++){
                if (novaGestio.getButaques().get(i).getNomPersona().equalsIgnoreCase(nomPersona)) {
                    opcioEliminarButacaPersona(i, nomPersona);
                    comptador++;
                }
            }
            if (comptador==0){
                System.out.println(nomPersona + " no té cap seient reservat");
            }
        }
    }
    private String introduirPersona () throws ExcepcioNomPersonaIncorrecte{
        String nomPersona = demanaString("Indiqui a quin nom estarà la reserva: ");
        for (int i=0; i<nomPersona.length(); i++)
            if (nomPersona.matches((".*[0-9].*"))){
                throw new ExcepcioNomPersonaIncorrecte("Introdueixi un nom real. Sense números");
            }
        return nomPersona;
    }
    private void demanarDadesInicials (){
        nombreFilesCinema = demanaIntMajorQue0("Indiqui el nombre de files del cinema: ");
        nombreSeientsCinema = demanaIntMajorQue0("Indiqui el nombre de seients dins cada fila del cinema: ") ;
    }
    private int introduirFila () throws ExcepcioFilaIncorrecte {
        int nombreFila = demanaInt("Introdueixi la fila del seient: ");
        if (nombreFila<=0 || nombreFila>nombreFilesCinema){
            throw new ExcepcioFilaIncorrecte("La fila introduïda no existeix");
        }
        return nombreFila;
    }
    private int introduirSeient () throws ExcepcioSeientIncorrecte {
        int nombreSeient = demanaInt("Introdueixi el nombre del seient: ");
        if (nombreSeient<=0 || nombreSeient>nombreSeientsCinema){
            throw new ExcepcioSeientIncorrecte("El seient introduït no existeix");
        }
        return nombreSeient;
    }

    //MÉTODES PER INTRODUIR DADES I VALIDARLES
    private String demanaString (String missatge) {
        Scanner input = new Scanner (System.in);
        System.out.print(missatge);
        return input.nextLine();
    }
    private int demanaInt (String missatge) throws InputMismatchException{
        Scanner input = new Scanner (System.in);
        int numero = 0;
        boolean correcte = false;
        do{
            System.out.print(missatge);
            try {
                numero = input.nextInt();
                correcte = true;
            } catch (InputMismatchException error) {
                System.out.println("Error de format. Introdueixi un número sencer.");
            }
            input.nextLine();
        } while (!correcte);
        return numero;
    }
    private int demanaIntMajorQue0 (String missatge) throws InputMismatchException{
        int numero;
        boolean correcte;
        do{
            correcte = true;
            numero = demanaInt(missatge);
            if (numero<=0){
                System.out.println("El nombre de files ha de ser major que 0");
                correcte = false;
            }
        } while (!correcte);
        return numero;
    }

    //MÉTODES AMB ELS TRY-CATCH
    private int OpcioMenu (int opcio){
        boolean correcte = false;
        do {
            try {
                opcio = menu();
                correcte = true;
            } catch (ExcepcioOpcioNoValida error) {
                System.out.println(error.getMessage());
            }
        } while (!correcte);
        return opcio;
    }
    private void opcioMostrarButaques(){
        try {
            mostrarButaques();
        } catch (ExcepcioNoHiHaReserves error) {
            System.out.println(error.getMessage());
        }
    }
    private void opcioMostrarButaquesPersona (){
        try {
            mostrarButaquesPersona();
        } catch (ExcepcioNoHiHaReserves error){
            System.out.println(error.getMessage());
        }
    }
    private void opcioAnularReserva (){
        try {
            anularReserva();
        } catch (ExcepcioNoHiHaReserves error){
            System.out.println(error.getMessage());
        }
    }
    private void opcioAnularReservaPersona (){
        try {
            anularReservaPersona();
        } catch (ExcepcioNoHiHaReserves error){
            System.out.println(error.getMessage());
        }
    }
    private String demanarIntroduirPersona (){
        String nomPersona = "";
        boolean correcte = false;
        do {
            try {
                nomPersona = introduirPersona();
                correcte = true;
            } catch (ExcepcioNomPersonaIncorrecte error) {
                System.out.println(error.getMessage());
            }
        }while(!correcte);
        return nomPersona;
    }
    private int demanarIntroduirFila (){
        int numeroFila = 1;
        boolean correcte = false;
        do {
            try {
                numeroFila = introduirFila();
                correcte = true;
            } catch (ExcepcioFilaIncorrecte error) {
                System.out.println(error.getMessage());
            }
        }while(!correcte);
        return numeroFila;
    }
    private int demanaIntroduirSeient (){
        int numeroSeient = 1;
        boolean correcte = false;
        do{
            try {
                numeroSeient = introduirSeient();
                correcte = true;
            } catch (ExcepcioSeientIncorrecte error) {
                System.out.println(error.getMessage());
            }
        }while(!correcte);
        return numeroSeient;
    }
    private boolean opcioAfegirButaca (int numeroFila, int numeroSeient, String nomPersona){
        boolean reservat = false;
        try {
            novaGestio.afegirButaca(new Butaca(numeroFila, numeroSeient, nomPersona));
            reservat = true;
        } catch (ExcepcioButacaOcupada error) {
            System.out.println(error.getMessage());
        }
        return reservat;
    }
    private void opcioEliminarButaca (int numeroFila, int numeroSeient){
        try {
            novaGestio.eliminarButaca(numeroFila, numeroSeient);
            avisEliminacio(numeroFila, numeroSeient);
        } catch (ExcepcioButacaBuida error) {
            System.out.println(error.getMessage());
        }
    }
    private void opcioEliminarButacaPersona (int i, String nomPersona){
        try{
            novaGestio.eliminarButaca(novaGestio.getButaques().get(i).getNombreDeFila(), novaGestio.getButaques().get(i).getNombreDeSeient());
            avisEliminacions(nomPersona);
        } catch (ExcepcioButacaBuida error) {
            System.out.println(error.getMessage());
        }
    }
    private void avisEliminacio (int numeroFila, int numeroSeient){
        System.out.println("La butaca amb Fila: " + numeroFila + ", i Seient: " + numeroSeient + ", s'ha alliberat");
    }
    private void avisEliminacions (String nomPersona){
        System.out.println("Les butaques amb reserva a nom de " + nomPersona + ", s'han alliberat");
    }
}
