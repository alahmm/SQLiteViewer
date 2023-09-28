package viewer;

import java.sql.SQLException;

public class ApplicationRunner {
    public static void main(String[] args) throws SQLException {
        new SQLiteViewer();
    }
}
