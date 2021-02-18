package Core;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HttpRequests {

    private static String getBase64(String username, String password) {
        return Base64.getEncoder()
                .encodeToString((username + ":" + password)
                        .getBytes());
    }

    public static void getAllEmployees(String username, String password) throws Exception {
        int code = 0;
        try {
            URL url = new URL("http://ec2-52-5-221-93.compute-1.amazonaws.com:8080/employees");

            String encoding = getBase64(username, password);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            code = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (code == 200) {
            System.out.println("All ok");
        } else {
            throw new Exception("Something went wrong");
        }
        System.out.println(code);
    }


    public static void createEmployee(String username, String password, String name, String description) throws Exception {
        int code = 0;
        try {
            URL url = new URL("http://ec2-52-5-221-93.compute-1.amazonaws.com:8080/employees");

            String encoding = getBase64(username, password);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setRequestProperty("Content Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");

            JsonObject employee = new JsonObject();
            employee.addProperty("in", "body");
            employee.addProperty("name", name);
            employee.addProperty("description", description);
            employee.addProperty("required", true);

            OutputStream stream = connection.getOutputStream();
            stream.write(employee.toString().getBytes(StandardCharsets.UTF_8));
            stream.close();

            code = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (code == 200) {
            System.out.println("All ok");
        } else {
            throw new Exception("Something went wrong " + code);
        }
    }

    public static void getEmployeeById(String username, String password, int id) throws Exception {
        int code = 0;
        try {
            URL url = new URL("http://ec2-52-5-221-93.compute-1.amazonaws.com:8080/employees/" + id);

            String encoding = getBase64(username, password);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            code = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (code == 200) {
            System.out.println("All ok");
        } else {

            throw new Exception("Something went wrong " + code);
        }
        System.out.println(code);
    }

    public static void createEmployeeById(String username, String password, int id, String name) throws Exception {
        int code = 0;
        try {
            URL url = new URL("http://ec2-52-5-221-93.compute-1.amazonaws.com:8080/employees");

            String encoding = getBase64(username, password);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setRequestProperty("Content Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            JsonObject employee = new JsonObject();
            employee.addProperty("name", id);
            employee.addProperty("in", name);
            employee.addProperty("description", "Employee object store in database table");
            employee.addProperty("required", true);
            employee.addProperty("type", "integer");

            OutputStream stream = connection.getOutputStream();
            stream.write(employee.toString().getBytes());
            stream.close();

            code = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (code == 200) {
            System.out.println("All ok");
        } else {
            throw new Exception("Something went wrong " + code);
        }
    }

    public static void deleteEmployeeById(String username, String password, String name, int id) throws Exception {
        int code = 0;
        try {
            URL url = new URL("http://ec2-52-5-221-93.compute-1.amazonaws.com:8080/employees");

            String encoding = getBase64(username, password);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setRequestProperty("Content Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            JsonObject employee = new JsonObject();
            employee.addProperty("name", name);
            employee.addProperty("in", id);
            employee.addProperty("description", "Employee object store in database table");
            employee.addProperty("required", true);

            OutputStream stream = connection.getOutputStream();
            stream.write(employee.toString().getBytes());
            stream.close();

            code = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (code == 200) {
            System.out.println("All ok");
        } else {
            throw new Exception("Something went wrong " + code);
        }
    }
}
