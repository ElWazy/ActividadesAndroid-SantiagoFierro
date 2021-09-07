package com.example.containers_santiagofierro.client.application;

import com.example.containers_santiagofierro.client.domain.Client;
import com.example.containers_santiagofierro.product.domain.Product;
import com.example.containers_santiagofierro.shared.domain.exceptions.NegativeValue;

public final class CalculateSalary {

    private final int discount;

    public CalculateSalary(Client client, Product product) throws NegativeValue {
        client.discountSalary(
                product.price().value()
        );

        if (!client.salary().isValid()) {
            throw new NegativeValue(
                    client.salary().toString(),
                    client.getClass().getName()
            );
        }

        discount = client.salary().value();
    }

    @Override
    public String toString() {
        return String.valueOf(discount);
    }
}
