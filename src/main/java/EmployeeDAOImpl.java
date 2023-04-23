import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final String user = "postgres";
    private final String password = "frostasecs1688";
    private final String url = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    //TODO Получение списка всех объектов Employee из базы.
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT*FROM city FULL OUTER JOIN emplovee ON city.city_id = emplovee.city_id ;")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int employvee_id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int city_id = resultSet.getInt("city_id");
//                String city_name = resultSet.getString("city_name");
                employees.add(new Employee(employvee_id, first_name, last_name, gender, age, city_id));
//                employees.add(new Employee(employvee_id, first_name, last_name, gender, age, new City(city_id,city_name)));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    //TODO Получение конкретного объекта по id
    public Employee getEmployeeById(int id) {
        Employee employees = null;
        try (final Connection connection = DriverManager.getConnection(url, user, password);

             PreparedStatement statement = connection.prepareStatement("SELECT*FROM city FULL OUTER JOIN emplovee ON city.city_id = emplovee.city_id WHERE id=(?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int empol_id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int city_id = resultSet.getInt("city_id");
//                String city_name = resultSet.getString("city_name");
                employees = new Employee(empol_id, first_name, last_name, gender, age, city_id);
//                employees = new Employee(empol_id, first_name, last_name, gender, age, new City(id,city_name));

            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employees;
    }


    @Override
    //TODO Создание сущности Employee в таблицу.
    public void createEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);

             PreparedStatement statement = connection.prepareStatement("INSERT INTO emplovee(id,first_name,last_name,gender,age,city_id)VALUES (?,?,?,?,?,?);")) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirst_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getId_city());
            statement.executeUpdate();
            System.out.println("Create employee");


        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    //TODO Изменение конкретного объекта
    public void updateEmployee(int id, Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE emplovee SET id=(?),first_name=(?),last_name=(?),gender=(?),age=(?),city_id=(?) WHERE id = (?);")) {
            statement.setInt(1, employee.getId());

            statement.setString(2, employee.getFirst_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getId_city());
            statement.setInt(7, id);
            statement.executeUpdate();
            System.out.println("Update employee");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

    }

    @Override
    //TODO Удаление конкретного объекта
    public void deleteEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM emplovee WHERE id =(?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Delete employee");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

    }
}
