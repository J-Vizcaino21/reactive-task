package org.josev.testReactiveMethods;

import io.reactivex.Observable;

public class MapOperator {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }
}
