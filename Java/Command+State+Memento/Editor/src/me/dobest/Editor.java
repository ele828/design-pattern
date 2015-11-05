package me.dobest;

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

    public void test() {
        doc = new Document();


        doc.append(new Line("hi, I'm Eric"));
        String str = "testing....";
        int line = 0;

        State state = new InsertState(doc);
        currentState = state;
        state.handle(line, str);
        str = "12312321";
        state.handle(line, str);

        System.out.println(doc.getFullDoc());

        Memento.getInstance().undo();
        System.out.println(doc.getFullDoc());
        Memento.getInstance().undo();
        System.out.println(doc.getFullDoc());

        str = "88888888";
        state.handle(line, str);
        System.out.println(doc.getFullDoc());
        state.handle(line, str);
        System.out.println(doc.getFullDoc());

        System.out.println(Memento.getInstance());
        System.out.println(doc.getFullDoc());

        Memento.getInstance().redo();
        System.out.println(doc.getFullDoc());

        Memento.getInstance().redo();
        System.out.println(doc.getFullDoc());

    }
}
