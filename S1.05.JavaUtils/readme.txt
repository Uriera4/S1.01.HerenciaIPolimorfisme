El primer pas és posicionar-nos en el directori on està el arxiu pom.xml del nostre programa.
	Exemple: C:\Users\urier>cd Desktop\IT ACADEMY\CURSO JAVA SPRING FRAMEWORKS\Sprint1.JavaLanguage\S1.05.JavaUtils

El segón pas es compil·lar el projecte.  Per fer-ho utilitem les següents comandes: mvn clean, compile i install. No obstant, abans haurem de modificar unes dades del pom.xml. Haurem de canviar el valor de packaging de pom a jar:
	Exemple: <packaging>jar</packaging>

1. Eliminem els .class generats en cas que existeixin (situats a la carpeta target) --> COMANDA mvn clean
	Exemple:	C:\Users\urier>cd Desktop\IT ACADEMY\CURSO JAVA SPRING FRAMEWORKS\Sprint1.JavaLanguage\S1.05.JavaUtils> mvn clean

2. Compil·lem el codi. Generant els .class basats en els arxius .java --> COMANDA mvn compile
	Exemple: C:\Users\urier>cd Desktop\IT ACADEMY\CURSO JAVA SPRING FRAMEWORKS\Sprint1.JavaLanguage\S1.05.JavaUtils> mvn compile

3. Generem els arxius jar segons el que s'hagi definit en el pom.xml --> COMANDA mvn install
	Exemple: C:\Users\urier>cd Desktop\IT ACADEMY\CURSO JAVA SPRING FRAMEWORKS\Sprint1.JavaLanguage\S1.05.JavaUtils> mvn install

Amb això tindrem una carpeta target amb les classes creades i un arxiu amb el nom del projecte i la versió amb extensió .jar.

El pas intermig abans de executar el programa, haurem de fer una modificació al pom.xml per assegurar que inclou el pluguin org.codehaus.mojo de la versió corresponent segons el que indiqui la consola (si s'intenta fer el pas següent, apareixerà l'error on indica el pluguin concret). Afegim el pluguin al pom.xml i el configurem per a que la mainClass correspongui al nostre arxiu Main.
	Exemple:
		<plugin>
      		      <groupId>org.codehaus.mojo</groupId>
        		      <artifactId>exec-maven-plugin</artifactId>
        		      <version>1.5.0</version>
        		      <configuration>
          			<mainClass>n1exercici1.Main</mainClass>
        		      </configuration>
     		</plugin>

Ara l'últim pas és exectuar el programa. Per fer-ho seguim en la mateixa ubicació on està el pom.xml i utilitzem: --> COMANDA mvn exec:java 
	Exemple: C:\Users\urier>cd Desktop\IT ACADEMY\CURSO JAVA SPRING FRAMEWORKS\Sprint1.JavaLanguage\S1.05.JavaUtils> mvn exec:java

El programa s'executarà correctament.