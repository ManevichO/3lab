package lab;

import javax.swing.table.AbstractTableModel;

public class FunctionTableModel extends AbstractTableModel{

    private Double from, to, step, parameter;

    public FunctionTableModel(Double from, Double to, Double step, Double parameter) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.parameter = parameter;
    }

    public Double getParameter() { return parameter; }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    @Override
    public int getRowCount() {
        return (int)(Math.ceil((to - from) / step)) + 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Double x = from + step * rowIndex;
        Double y = x + x * (-parameter / 2) + Math.pow(x, 2) * (-parameter);
        Boolean z = y < 0;
        switch (columnIndex){
            case 0: return x;
            case 1: return y;
            case 2: return z;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 2) return Boolean.class;
        return Double.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Значение Х";
            case 1: return "Значение многочлена";
            case 2: return "Значение многочлена < 0?";
        }
        return "";
    }
}