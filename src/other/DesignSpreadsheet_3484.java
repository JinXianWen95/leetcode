package other;

public class DesignSpreadsheet_3484 {

    public static void main(String[] args) {
        DesignSpreadsheet_3484 spreadsheet = new DesignSpreadsheet_3484(3); // Initializes a spreadsheet with 3 rows and 26 columns
        spreadsheet.getValue("=5+7"); // returns 12 (5+7)
        spreadsheet.setCell("A1", 10); // sets A1 to 10
        spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
        spreadsheet.setCell("B2", 15); // sets B2 to 15
        spreadsheet.getValue("=A1+B2"); // returns 25 (10+15)
        spreadsheet.resetCell("A1"); // resets A1 to 0
        spreadsheet.getValue("=A1+B2"); // returns 15 (0+15)
    }

    private int[][] spreedSheet;
    public DesignSpreadsheet_3484(int rows) {
        spreedSheet = new int[rows+1][26];
    }

    public void setCell(String cell, int value) {
        spreedSheet[getRow(cell)][getColumn(cell)] = value;
    }

    public void resetCell(String cell) {
        this.spreedSheet[getRow(cell)][getColumn(cell)] = 0;
    }

    public int getValue(String formula) {
        String[] cellValue = formula.substring(1).split("\\+");
        return getCellValue(cellValue[0]) + getCellValue(cellValue[1]);
    }

    private int getColumn(String cell) {
        return cell.toCharArray()[0] - 'A';
    }

    private int getRow(String cell) {
        return Integer.parseInt(cell.substring(1));
    }

    private int getCellValue(String cell) {
        int value;
        if (cell.matches("[A-Z]+[0-9]+")) {
            value = spreedSheet[getRow(cell)][getColumn(cell)];
        } else {
            value = Integer.parseInt(cell);
        }
        return value;
    }
}
