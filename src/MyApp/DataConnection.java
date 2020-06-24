package MyApp;

import java.io.IOException;

public interface DataConnection {
    int loadData(int sum) throws Exception;
    void saveData(int year, double qq) throws IOException;
}
