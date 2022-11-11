import java.util.EventObject;

public class EndGameEvent extends EventObject {
    private String msg;

    public String getMsg() {
        return msg;
    }

    EndGameEvent(Object src, String msg){
        super(src);
        this.msg = msg;
    }
}
