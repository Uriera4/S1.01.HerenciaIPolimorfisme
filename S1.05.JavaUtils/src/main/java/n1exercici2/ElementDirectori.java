package n1exercici2;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ElementDirectori {

    final protected String nom;
    final protected String dataModificacio;
    final private String alias;

    public ElementDirectori(File arxiu, String alias){
        nom = arxiu.getName();
        dataModificacio = retornaDataModificacio(new Date (arxiu.lastModified()));
        this.alias = alias;
    }

    private String retornaDataModificacio (Date dataModificacio){
        Calendar c = new GregorianCalendar();
        c.setTime(dataModificacio);
        return c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR);
    }

    public String getAlias (){
        return alias;
    }

    public String toString (){
        return alias + " " + nom + " darrera modificació " + dataModificacio;
    }

}
