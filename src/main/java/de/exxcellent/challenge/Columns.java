package de.exxcellent.challenge;

import java.util.ArrayList;

/**
 * List of columns
 * @param <T> type of column in the list
 */
public abstract class Columns<T extends Column> {
    private ArrayList<T> columns;

    Columns() {
        columns = new ArrayList<>();
    }

    public void addColumn(T column) {
        columns.add(column);
    }

    public abstract T getColumn();
}
