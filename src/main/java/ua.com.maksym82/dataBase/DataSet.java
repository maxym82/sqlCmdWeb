package ua.com.maksym82.dataBase;

import java.util.*;

public class DataSet implements DataSetInterface {
    private Map<String, Object> dataSet = new LinkedHashMap<>();

    @Override
    public void put(String key, Object value) {
        dataSet.put(key, value);
    }

//    @Override
//    public int size() {
//        return dataSet.size();
//    }

    @Override
    public List<Object> getAllData() {
        return new ArrayList<>(dataSet.values());
    }

    @Override
    public Set<String> getKeys() {
        return dataSet.keySet();
    }

//    @Override
//    public Object getValue(String key) {
//        return dataSet.get(key);
//    }

//    @Override
//    public void updateDataFrom(DataSetInterface newValue) {
//        Set<String> columns = newValue.getKeys();
//        for (String name : columns) {
//            Object data = newValue.getValue(name);
//            put(name, data);
//        }
//    }

    @Override
    public Iterable<Map.Entry<String, Object>> entrySet() {
        return dataSet.entrySet();
    }

}
