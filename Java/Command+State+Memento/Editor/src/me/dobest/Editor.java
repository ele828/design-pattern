package me.dobest;

import com.sun.javafx.fxml.ParseTraceElement;
import me.dobest.document.Document;
import me.dobest.document.Line;
import me.dobest.state.InsertState;
import me.dobest.state.State;

/**
 * Created by Eric on 15/11/4.
 */
public class Editor {

    private State currentState;
    private Document doc;

    public static void main(String ...args) {

        Editor editor = new Editor();
        editor.test();

    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getState() {
        return this.currentState;
    }

    /**
     * Runtime cycle.
     */
    public void run() {
        State currentState = null;
        // Read commands
        String cmd = "10i";
        // Parse
        boolean isCmd = Parser.parse(cmd);
        if ( isCmd ) {

            State state = new InsertState(doc);

            // Switch command process.

            currentState = state;

        } else {
            // Input
            currentState.handle(0, "testing1...");
        }

    }

    public void test() {
        doc = new Document();

        State state = new InsertState(doc);
        currentState = state;

        state.handle(0, "testing1...");
        state.handle(0, "testing2...");
        state.handle(0, "testing3...");

        System.out.println(doc.getFullDoc());

        Memento.getInstance().undo();
        Memento.getInstance().undo();

        System.out.println(Memento.getInstance());
//        Memento.getInstance().redo();

        state.handle(0, "testing4...");

        Memento.getInstance().redo();

        System.out.println(doc.getFullDoc());

        System.out.println(Memento.getInstance());


    }
}
