package org.josev.testReactiveMethods;

import io.reactivex.Observable;

public class FilterOperator {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item % 2 == 0)  // Filtrar solo los números pares
                .subscribe(System.out::println);
    }
}
