package de.exxcellent.challenge;

public class CategorizedColumns extends Columns<CategorizedColumn<?>> {
    public CategorizedColumns() {
        super();
    }

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
}
