package dataBase;

import java.util.*;

public class DataSet implements DataSetInterface {
    private Map<String, Object> dataSet = new LinkedHashMap<>();

    @Override
    public void put(String key, Object value) {
        dataSet.put(key, value);
    }

    @Override
    public int size() {
        return dataSet.size();
    }

    @Override
    public List<Object> getAllData() {
        return new ArrayList<>(dataSet.values());
    }

    @Override
    public Set<String> getKeys() {
        return dataSet.keySet();
    }

    @Override
    public Object getValue(String key) {
        return dataSet.get(key);
    }

    @Override
    public void updateDataFrom(DataSetInterface newValue) {
        Set<String> columns = newValue.getKeys();
        for (String name : columns) {
            Object data = newValue.getValue(name);
            put(name, data);
        }
    }

    @Override
    public String deepToString() {
        ArrayList columnNames = new ArrayList<String>(this.getKeys());
        ArrayList<ArrayList<String>> tableToString = new ArrayList<ArrayList<String>>();
        tableToString.add(columnNames);
        for(Object column: this.getAllData()) {
            if (column instanceof List) {
                for(Object element: (List)column) {
                    if (element instanceof String) {
                        
                    } else {}
                }
            } else {}
        }
        int[] maxLengths = new int[tableToString.get(0).size()];
        for (List<String> row : tableToString)
        {
            for (int i = 0; i < row.size(); i++)
            {
                maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : maxLengths)
        {
            formatBuilder.append("%-").append(maxLength + 2).append("s");
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : tableToString)
        {
            result.append(String.format(format, row.toArray(new String[0]))).append("\n");
        }
        return result.toString();
    }

    @Override
    public Iterable<Map.Entry<String, Object>> entrySet() {
        return dataSet.entrySet();
    }

}
