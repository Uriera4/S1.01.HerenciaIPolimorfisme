package n1exercici1;

public class NoGenericMethod {

    private String s1, s2, s3;

    public NoGenericMethod (String s1, String s2, String s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public void setS1 (String s1){
        this.s1=s1;
    }
    public void setS2 (String s2){
        this.s2=s2;
    }
    public void setS3 (String t3){
        this.s3=s3;
    }
    public String getT1 (){
        return s1;
    }
    public String getT2 (){
        return s2;
    }
    public String getT3 (){
        return s3;
    }
    public String toString (){
        return s1 + " " + s2 + " " +s3;
    }

}
