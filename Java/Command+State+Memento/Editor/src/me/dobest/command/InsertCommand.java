package me.dobest.command;

import me.dobest.Range;
import me.dobest.document.Line;

/**
 * Created by Eric on 15/11/4.
 */
public class InsertCommand implements Command {

    private Line line;
    private Range range;
    private String str;

    public InsertCommand(Line line, String str) {
        this.line = line;
        this.str = str;
    }

    @Override
    public void execute() {
        int originLen = line.getLength();
        range = new Range(originLen, str.length() + originLen);
        line.append(str);
    }

    @Override
    public void undo() {
        System.out.println("removing" + range);
        line.undoInsert(range);
    }

    @Override
    public String toString() {
        return "{Command: Insert" +
                    "[" + range.getStart() +
                    "," + range.getEnd() + "] =>" +
                    str +
                "}";
    }
}
