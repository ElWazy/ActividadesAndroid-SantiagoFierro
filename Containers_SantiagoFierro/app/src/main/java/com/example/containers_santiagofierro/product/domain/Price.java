package com.example.containers_santiagofierro.product.domain;

public final class Price {

    private final int value;

    public Price(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isValid() {
        return value < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        return value == price.value;
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
