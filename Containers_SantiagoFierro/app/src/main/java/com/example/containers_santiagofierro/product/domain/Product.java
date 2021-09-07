package com.example.containers_santiagofierro.product.domain;

import com.example.containers_santiagofierro.shared.domain.Id;
import com.example.containers_santiagofierro.shared.domain.Name;

public final class Product {
    private final Id id;
    private final Name name;
    private final Price price;

    public Product(Id id, Name name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Price price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!name.equals(product.name)) return false;
        return price.equals(product.price);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public String showWithPrice() {
        return name.toString() + " : " + price.toString();
    }
}
