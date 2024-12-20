package org.josev.testReactiveMethods;

import io.reactivex.Observable;

public class FlatMapOperator {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .flatMap(item -> Observable.just(item * 10, item * 20))  // Crear dos nuevos valores para cada item
                .subscribe(System.out::println);
    }
}
