package n2exercici1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface SerialitzaJSON {
    String rutaDirectori() default "src/main/java/n3exercici1/ElMeuObjecte.json";

}
