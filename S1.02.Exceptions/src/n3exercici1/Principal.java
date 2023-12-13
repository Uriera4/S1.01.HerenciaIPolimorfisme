package n3exercici1;

public class Principal {

    public static void main (String[] args)  {

        titolPrograma();
        (new Cine()).iniciar();
        sortirPrograma();

    }
    static void titolPrograma(){
        System.out.println("APLICACIO PER GESTIONAR RESERVES DE SEIENTS DEL CINEMA");
    }
    static void sortirPrograma(){
        System.out.println("Finalitzant aplicació. Adéu.");
    }

}
