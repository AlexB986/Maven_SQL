import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    void createEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);


}

