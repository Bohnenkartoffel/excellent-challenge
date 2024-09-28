package de.exxcellent.challenge;

import java.util.ArrayList;

/**
 * List of columns
 * @param <T> type of column in the list
 */
public abstract class Columns<T extends Column> {
    private ArrayList<T> columns;

    /**
     * Creates a new, empty list of columns
     */
    Columns() {
        columns = new ArrayList<>();
    }

    /**
     * Adds a column to the list of columns, appending it at the end
     * @param column column to add
     */
    public void addColumn(T column) {
        columns.add(column);
    }

    /**
     * retrieves a column from the list of columns
     * @return a column
     */
    public abstract T getColumn();
}
