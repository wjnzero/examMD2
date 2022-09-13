package storage;

import java.util.List;

public interface IGenericReadWriteData<O> {
    List<O> readData();
    void writeData(List<O> list);
}
