package me.dobest;

import me.dobest.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 15/11/4.
 */
public class Memento {
    private static Memento instance;
    private List<Command> _stack = new ArrayList<Command>();
    private int ptr = -1;
    private int top = 0;

    public static Memento getInstance() {
        return instance == null
                ? instance = new Memento()
                : instance;
    }

    public void setCommand(Command cmd) {
        ++ptr;
        if (ptr >= _stack.size()) {
            _stack.add(ptr, cmd);
            ++top;
        } else {
            _stack.set(ptr, cmd);
            top = ptr;
        }
    }

    public Command getCommand() {
        return _stack.get(ptr);
    }

    public void undo() {
        if (ptr < 0)
            return;
        _stack.get(ptr--).undo();
    }

    public void redo() {
        if (ptr >= top)
            return;
        _stack.get(++ptr).execute();
    }

    @Override
    public String toString() {
        return _stack.toString() + "\n"
                + "Pointer: " + ptr;
    }

}
