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

    /**
     * Return the content of the specific line.
     * @param lineNum
     * @return
     */
    public Line getLine(int lineNum) {
        Line retLine = null;
        try {
            retLine = doc.get(lineNum);
        } catch(IndexOutOfBoundsException e) {
            // Line not found or out of ranges.
            // If doc is empty then create a new line and return the last line.
            if (doc.size() == 0) {
                this.append(new Line(""));
            }
            retLine = doc.get(doc.size()-1);
        }
        return retLine;
    }

    /**
     * Append to the end of the document.
     * @param line
     * @return
     */
    public boolean append(Line line) {
        return doc.add(line);
    }

    public boolean insertTo(int lineNum, Line line) {
        doc.add(lineNum, line);
        return true;
    }

    /**
     * Return the while document.
     * @return
     */
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
