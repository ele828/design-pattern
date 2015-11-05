package me.dobest.document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 15/11/4.
 */
public class Document {

    private List<Line> doc = new ArrayList<Line>();

    public Document() {}

    public List<Line> getDoc() {
        return doc;
    }

    public Line getLine(int lineNum) {
        return doc.get(lineNum);
    }

    public boolean append(Line line) {
        return doc.add(line);
    }

    public boolean insertTo(int lineNum, Line line) {
        doc.add(lineNum, line);
        return true;
    }

    public String getFullDoc() {
        StringBuilder sb = new StringBuilder();
        for (Line line : doc) {
            sb.append(line.getContents());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return doc.toString();
    }
}
