package framework;

import framework.utils.UserListGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow to read follow type data: SQL, XML, CSV
 *
 * @author Yaroslav Lazakovich
 * @version 1.2
 */
public class DataFactory {
    private static final String DATA_PROVIDER = PropertyReader.getProperty("dataProvider");

    public static List<User> getUserList() {
        List<User> users = new ArrayList<>();
        switch (DATA_PROVIDER.toLowerCase()) {
            case "sql":
                UserListGenerator.getUserListBySQL(users);
                break;
            case "xml":
                UserListGenerator.getUserListByXML(users);
                break;
            case "csv":
                UserListGenerator.getUserListByCSV(users);
                break;
            default:
                UserListGenerator.getUserListBySQL(users);
        }
        return users;
    }


}
