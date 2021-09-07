package com.example.containers_santiagofierro.product.infrastructure;

import com.example.containers_santiagofierro.product.domain.Price;
import com.example.containers_santiagofierro.product.domain.Product;
import com.example.containers_santiagofierro.shared.domain.Id;
import com.example.containers_santiagofierro.shared.domain.Name;
import com.example.containers_santiagofierro.shared.domain.exceptions.UnhandledGenerationLimit;

import java.util.Random;

public final class ProductGenerator {
    private final int MAX_ITERATIONS = 5;

    private final String[] names = new String[] {
            "Cereals",
            "Rice",
            "Noodles",
            "Crunchies",
            "Lemon Pie"
    };

    private final Product[] products;

    public ProductGenerator(int iterations) throws UnhandledGenerationLimit {
        if (iterations > MAX_ITERATIONS) {
            throw new UnhandledGenerationLimit("Not have much names or salaries");
        }

        products = new Product[iterations];

        for (int i = 0; i < products.length; i++) {
            String randomName   = names[i];
            int    randomPrice = new Random().nextInt(10000);

            products[i] = new Product(
                    new Id(i),
                    new Name(randomName),
                    new Price(randomPrice)
            );
        }
    }

    public Product[] products() {
        return products;
    }
}
