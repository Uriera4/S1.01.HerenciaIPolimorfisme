package n1exercici2;
public class Main {
    public static void main(String[] args) {

        Cotxe cotxe1 = new Cotxe("Corsa", 50);
        System.out.println(cotxe1);

        Cotxe cotxe2 = new Cotxe("Astra", 250);
        System.out.println(cotxe2);
        System.out.println(cotxe1);
        /*COMPROVAMOS QUE AL SER UN 'MODELO' STATIC, AL INSTANCIAR UN OBJETO CON UN VALOR DISTINTO A LOS ANTERIORES,
        EL VALOR DE LOS ANTERIORES TAMBIÉN SE VE MODIFICADO*/

        cotxe1.setModel("Mokka");
        System.out.println(cotxe2);
        System.out.println(cotxe1);
        /*VOLVEMOS A COMPROVAR LA DIFERENCIA ENTRE STATIC Y NO STATIC
         PERO ESTA VEZ MODIFICANDOLO DESDE EL SETTER EN LUGAR DE INSTANCIAR UN NUEVO OBJETO
         EN EL CASO DE LA 'POTENCIA' AL SER FINAL NO PUEDE MODIFICARSE NUNCA.
         EN EL CASO DE LA MARCA 'OPEL' NI SIQUIERA PUEDE INSTANCIARSE EN EL CONSTRUCTOR*/

        cotxe1.accelerar();
        Cotxe.frenar();
        /*PARA ACELERAR LO LLAMAMOS DESDE EL OBJETO INSTANCIADO YA QUE ES NO STATIC
        EN EL CASO DE EL FRENAR, COMO ES STATIC, NO LLAMAMOS DESDE LA PROPIA CLASE*/


    }
}
