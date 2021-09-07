package com.example.containers_santiagofierro.client.domain;

import com.example.containers_santiagofierro.shared.domain.Id;
import com.example.containers_santiagofierro.shared.domain.Name;

public final class Client {
    private final Id id;
    private final Name name;
    private Salary salary;

    public Client(Id id, Name name, Salary salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Salary salary() {
        return salary;
    }

    public void discountSalary(int difference) {
        salary = new Salary(salary.value() - difference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!name.equals(client.name)) return false;
        return salary.equals(client.salary);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + salary.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
