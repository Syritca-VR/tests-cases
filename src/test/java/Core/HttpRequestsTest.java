package Core;

import org.testng.annotations.*;

public class HttpRequestsTest {

    @Test(priority = 1, testName = "getAllEmployees")
    public void getAllEmployees() throws Exception {
        HttpRequests.getAllEmployees("admin", "admin123");
    }

    @Test(priority = 2, testName = "getEmployeeById")
    public void getEmployeeById() throws Exception {
        HttpRequests.getEmployeeById("admin", "admin123", 0);
    }

    @Test(priority = 1, testName = "createEmployee")
    public void createEmployee() throws Exception {
        HttpRequests.createEmployee("admin", "admin123", "John Snow", "Worthy employee");
    }

    @Test(priority = 1, testName = "createEmployeeById")
    public void createEmployeeById() throws Exception {
        HttpRequests.createEmployeeById("admin", "admin123", 1, "John Wick");
    }

    @Test(priority = 1, testName = "deleteEmployee")
    public void deleteEmployee() throws Exception {
        HttpRequests.deleteEmployeeById("admin", "admin123", "John Snow", 0);
    }
}

