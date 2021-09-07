package com.example.containers_santiagofierro.shared.domain;

import androidx.annotation.NonNull;

public final class Name {

    private final String value;

    public Name(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @NonNull
    @Override
    public String toString() {
        return value;
    }
}
