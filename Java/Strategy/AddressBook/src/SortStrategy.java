import java.util.ArrayList;

/**
 * Created by Eric on 15/10/27.
 */
public interface SortStrategy<T> {
    void sort(ArrayList<T> list);
}
