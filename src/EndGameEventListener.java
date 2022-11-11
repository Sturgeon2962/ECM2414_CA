import java.io.IOException;
import java.util.EventListener;

public interface EndGameEventListener extends EventListener{
    public void eventOccured(EndGameEvent event) throws IOException;
}
