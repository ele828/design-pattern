/**
 * Created by Eric on 15/10/29.
 */
public class Decorator extends DB{
    private DB db;

    public Decorator(DB db) {
        this.db = db;
    }

    @Override
    public DBTable getTable(String name) {
        return db.getTable(name);
    }

    @Override
    public void createTable(String name, int columns) {
        db.createTable(name, columns);
    }

    @Override
    public void insert(String tableName, String[] row) {
        db.insert(tableName, row);
    }

    @Override
    public DBTable select(String tabName, int col, String selector) {
        return db.select(tabName, col, selector);
    }

    @Override
    public DBTable join(String tab1Name, String tab2Name, int tab1Col, int tab2Col) {
        return db.join(tab1Name, tab2Name, tab1Col, tab2Col);
    }
}
