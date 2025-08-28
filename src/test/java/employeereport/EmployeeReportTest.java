package employeereport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeReportTest {
    private static final Employee EMPLOYEE_ALEXIS_17 = new Employee("Fabien", 17);
    private static final Employee EMPLOYEE_ANDRA_18 = new Employee("Andra", 18);
    private static final Employee EMPLOYEE_MATHIEU_19 = new Employee("Mathieu", 19);
    private static final Employee EMPLOYEE_JOSE_23 = new Employee("José", 23);

    @Test
    void shouldRetrieveAdultEmployees() {
        List<Employee> employees = List.of(EMPLOYEE_ALEXIS_17, EMPLOYEE_ANDRA_18, EMPLOYEE_MATHIEU_19);
        List<Employee> employeesWhoAre18OrOlder = EmployeeReport.retrieveAdults(employees);
        Assertions.assertEquals(2, employeesWhoAre18OrOlder.size());
        Assertions.assertTrue(employeesWhoAre18OrOlder.contains(EMPLOYEE_ANDRA_18));
        Assertions.assertTrue(employeesWhoAre18OrOlder.contains(EMPLOYEE_MATHIEU_19));
    }

    @Test
    void shouldSortAdultEmployeesByNameDescendant() {
        List<Employee> employees = List.of(EMPLOYEE_JOSE_23, EMPLOYEE_ALEXIS_17, EMPLOYEE_MATHIEU_19, EMPLOYEE_ANDRA_18);
        List<Employee> employeesWhoAre18OrOlder = EmployeeReport.retrieveAdults(employees);
        Assertions.assertEquals(3, employeesWhoAre18OrOlder.size());
        Assertions.assertEquals(EMPLOYEE_MATHIEU_19.name(), employeesWhoAre18OrOlder.get(0).name());
        Assertions.assertEquals(EMPLOYEE_JOSE_23.name(), employeesWhoAre18OrOlder.get(1).name());
        Assertions.assertEquals(EMPLOYEE_ANDRA_18.name(), employeesWhoAre18OrOlder.get(2).name());
    }

    @Test
    void shouldCapitalizedAdultEmployees() {
        List<Employee> employees = List.of(EMPLOYEE_JOSE_23);
        List<Employee> employeesWhoAre18OrOlder = EmployeeReport.retrieveAdults(employees);
        Assertions.assertEquals(1, employeesWhoAre18OrOlder.size());
        Assertions.assertEquals(EMPLOYEE_JOSE_23.name().toUpperCase(), employeesWhoAre18OrOlder.get(0).name());
    }
}