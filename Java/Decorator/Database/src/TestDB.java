public class TestDB {

	public static void main(String ...args) {
		DB db = new DBConcrete();
		DB insertionLogDecorator = new InsertionLogDecorator(db);
		insertionLogDecorator.createTable("MyTable", 3);
		String row1[] = {"1A", "1B", "1C"};
		String row2[] = {"2A", "2B", "2C"};
		String row3[] = {"3A", "2B", "3C"};
		insertionLogDecorator.insert("MyTable", row1);
		insertionLogDecorator.insert("MyTable", row2);
		insertionLogDecorator.insert("MyTable", row3);
		DBTable tab = insertionLogDecorator.select("MyTable", 1, "2B");
		System.out.println(tab.get(0,0));
	}

}
