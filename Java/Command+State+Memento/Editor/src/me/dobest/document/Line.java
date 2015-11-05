package me.dobest.document;

import me.dobest.Range;

/**
 * Created by Eric on 15/11/4.
 */
public class Line {
    private String contents;

    public Line(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getLength() {
        return contents.length();
    }

    public String append(String c) {
        return contents = new StringBuilder(contents)
                                .append(c)
                                    .toString();
    }

    public String insertTo(int pos, String c) {
        return contents = new StringBuffer(contents)
                                .insert(pos, c)
                                    .toString();
    }

    public void undo(Range range) {
        contents = new StringBuilder(contents)
                        .delete(range.getStart(), range.getEnd())
                            .toString();
    }

    @Override
    public String toString() {
        return contents;
    }
}
