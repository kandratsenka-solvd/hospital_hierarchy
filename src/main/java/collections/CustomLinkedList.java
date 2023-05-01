package collections;

import exceptions.IndexLargerListSizeException;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;

import java.util.LinkedList;


public class CustomLinkedList<T> extends LinkedList<T> {

    private static final Logger LOGGER = LoggerUtil.getLogger();

    public void printList() {
        for (T item : this) {
            LOGGER.info(item);
        }
    }

    public void insertAt(int index, T item) {
        if (index < 0 || index > size()) {
            throw new IndexLargerListSizeException();
        }
        add(index, item);
    }

    public T deleteAt(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexLargerListSizeException();
        }
        return remove(index);
    }
}