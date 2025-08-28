package employeereport;

import java.util.Comparator;
import java.util.List;

public class EmployeeReport {
    public static List<Employee> retrieveAdults(List<Employee> employees) {
        return employees.stream()
                .filter(Employee::isAdult)
                .sorted(Comparator.comparing(Employee::name).reversed())
                .toList();
    }
}
