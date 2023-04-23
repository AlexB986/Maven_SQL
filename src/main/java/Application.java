import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//    Получить и вывести в консоль полные данные об одном из работников(имя, фамилия, пол, город) по id.
        final String user = "postgres";
        final String password = "frostasecs1688";
        final String url = "jdbc:postgresql://localhost:5432/postgres";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT*FROM city FULL OUTER JOIN emplovee ON city.city_id = emplovee.employee_id WHERE  ID = 2;")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfCity = resultSet.getInt("city_id");

                String cityOfName = resultSet.getString("city_name");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                System.out.println("ID города: " + idOfCity);
                System.out.println("Имя: " + first_name);
                System.out.println("Фамилия: " + last_name);
                System.out.println("Пол: " + gender);
                System.out.println("Город: " + cityOfName);
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
//        Получение списка всех объектов Employee из базы.
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employeeList = employeeDAO.getAllEmployee();
        System.out.println(employeeList);
//        Получение конкретного объекта по id
        System.out.println(employeeDAO.getEmployeeById(1));
//        Создание сущности Employee в таблицу.
        employeeDAO.createEmployee(new Employee(7, "Kiano", "Amson", "m", 300, 2));
//        Изменение конкретного объекта
        employeeDAO.updateEmployee(1, new Employee(1,"Murano","Nissano","m",300,1));
        employeeDAO.deleteEmployee(1);
    }
}
