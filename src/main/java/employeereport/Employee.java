package employeereport;

public record Employee(String name, int years) {
    public Employee {
        name = name.toUpperCase();
    }

    public boolean isAdult() {
        return this.years >= 18;
    }
}
