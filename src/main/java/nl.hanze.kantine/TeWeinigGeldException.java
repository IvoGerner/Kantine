package nl.hanze.kantine;

public class TeWeinigGeldException extends Exception {
    public TeWeinigGeldException(){
        super();
    }

    public TeWeinigGeldException(Exception ex){
        super(ex);
    }

    public TeWeinigGeldException(String message){
        super(message);
    }


}
