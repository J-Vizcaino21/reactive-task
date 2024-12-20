package org.josev;

import io.reactivex.Observable;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 2500),
                new Employee("Bob", 1800),
                new Employee("Charlie", 3000),
                new Employee("Diana", 2200),
                new Employee("Eve", 1500)
        );

        // Observable de incrementos (incrementos porcentuales: 10%, 20%, 15%)
        Observable<Double> increments = Observable.just(1.10, 1.20, 1.15);

        // 1. Filtramos empleados con salario mayor a 2000
        // 2.Convertimos el salario mensual en salario anual (mensual * 12)
        // 3. Ahora combinamos (zip) con el Observable de incrementos.
        //    zip emitirá pares: (salarioAnual, incremento)
        //    y calculamos el salario incrementado: salarioAnual * incremento
        // 4. flatMap: supongamos que por cada salario incrementado queremos
        //    simular que emitimos dos valores (por ejemplo, el salario y la mitad del salario)
        // 5. Usamos reduce para sumar todos los valores generados.

        Observable.fromIterable(employees)
                .filter(e -> e.getMonthlySalary() > 2000)
                .map(e -> e.getMonthlySalary() * 12)
                .zipWith(increments, (annualSalary, increment) -> annualSalary * increment)
                .flatMap(finalSalary -> Observable.just(finalSalary, finalSalary / 2))
                .reduce(Double::sum)
                .subscribe(total -> System.out.println("Total suma de los salarios incrementados con sus mitades " + total));
    }
}