package me.dobest.state;

import me.dobest.Memento;
import me.dobest.command.Command;
import me.dobest.command.InsertCommand;
import me.dobest.document.Document;
import me.dobest.document.Line;

/**
 * Created by Eric on 15/11/4.
 */
public class InsertState implements State {
    private Document doc;
    public InsertState(Document doc) {
        this.doc = doc;
    }

    @Override
    public void handle(int line, String str) {
        Command cmd = new InsertCommand(
                doc.getLine(line),
                str
        );
        Memento.getInstance().setCommand(cmd);
        cmd.execute();
    }
}
