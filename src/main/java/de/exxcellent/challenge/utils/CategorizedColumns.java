package de.exxcellent.challenge.utils;

/**
 * List of CategorizedColumns
 */
public class CategorizedColumns extends Columns<CategorizedColumn<?>> {
    public CategorizedColumns() {
        super();
    }

    /**
     * Gets the CategorizedColumn corresponding to the given category
     * @param category category of the column to be returned
     * @return CategorizedColumn of the given category
     * @throws Exception if CategorizedColumns is empty or does not contain the given category
     */
    public CategorizedColumn<?> getColumn(String category) throws Exception {
        for (CategorizedColumn<?> column : columns) {
            if (column.category.equals(category)) {
                return column;
            } else {
                throw new Exception("No such category found");
            }
        }
        throw new Exception("No categories found");
    }

    /**
     * Adds a column, overriding an existing column if the category already exists and appending it at the end
     * otherwise
     * @param newColumn column to add
     */
    @Override
    public void addColumn(CategorizedColumn<?> newColumn) {
        int index = 0;
        for (CategorizedColumn<?> column : columns) {
            if (column.category.equals(newColumn.category)) {
                columns.set(index, newColumn);
            }
            index++;
        }
        super.addColumn(newColumn);
    }
}
