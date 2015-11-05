package me.dobest.state;

/**
 * Created by Eric on 15/11/4.
 */
public interface State {
    void handle(int line, String str);
}
