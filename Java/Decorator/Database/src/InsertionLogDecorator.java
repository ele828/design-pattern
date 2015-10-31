/**
 * Created by Eric on 15/10/29.
 */
public class InsertionLogDecorator extends Decorator {

    public InsertionLogDecorator(DB db) {
        super(db);
    }

    @Override
    public void insert(String tableName, String[] row) {
        super.insert(tableName, row);
        System.out.println(tableName + " was inserted successfully to the row " + row);
    }

}
