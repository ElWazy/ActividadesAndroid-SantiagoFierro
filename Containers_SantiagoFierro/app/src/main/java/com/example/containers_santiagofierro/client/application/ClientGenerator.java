package com.example.containers_santiagofierro.client.application;

import com.example.containers_santiagofierro.client.domain.Client;
import com.example.containers_santiagofierro.client.domain.Salary;
import com.example.containers_santiagofierro.shared.domain.Id;
import com.example.containers_santiagofierro.shared.domain.Name;
import com.example.containers_santiagofierro.shared.domain.exceptions.UnhandledGenerationLimit;

import java.util.Random;

public final class ClientGenerator {
    private final int MAX_ITERATIONS = 3;

    private final String[] names = new String[] {
            "Santiago",
            "Pedro",
            "Juan",
            "Maria"
    };
    private final Client[] clients;

    public ClientGenerator(int iterations) throws UnhandledGenerationLimit {
        if (iterations > MAX_ITERATIONS) {
            throw new UnhandledGenerationLimit("Not have much names or salaries");
        }

        clients = new Client[iterations];

        for (int i = 0; i < clients.length; i++) {
            String randomName   = names[i];
            int    randomSalary = new Random().nextInt(1000000);

            clients[i] = new Client(
                    new Id(i),
                    new Name(randomName),
                    new Salary(randomSalary)
            );
        }
    }

    public Client[] clients() {
        return clients;
    }
}
