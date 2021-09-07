package com.example.containers_santiagofierro.client.domain;

public final class Salary {

    private final int value;

    public Salary(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isValid() {
        return value > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salary salary = (Salary) o;

        return value == salary.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
