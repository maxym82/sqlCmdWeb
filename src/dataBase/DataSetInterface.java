package dataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DataSetInterface {
    public void put (String name, Object value);
    public int size ();
    public List<Object> getAllData ();
    public Set<String> getKeys();
    public Object getValue (String key);
    public void updateDataFrom(DataSetInterface newValue);
    public String toString ();
    Iterable<Map.Entry<String, Object>> entrySet();
}
