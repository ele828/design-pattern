package me.dobest.command;

/**
 * Created by Eric on 15/11/4.
 */
public interface Command {
    void execute();
    void undo();
}
