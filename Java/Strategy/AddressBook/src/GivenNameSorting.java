import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Eric on 15/10/27.
 */
public class GivenNameSorting implements SortStrategy<Contact> {

    @Override
    public void sort(ArrayList<Contact> list) {
        list.sort((Contact o1, Contact o2) ->
                o1.getGivenName().compareTo(o2.getGivenName())
        );
    }
}
