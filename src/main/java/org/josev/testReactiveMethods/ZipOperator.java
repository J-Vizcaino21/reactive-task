package org.josev.testReactiveMethods;

import io.reactivex.Observable;

public class ZipOperator {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<String> observable2 = Observable.just("A", "B", "C");

        Observable.zip(observable1, observable2, (num, letter) -> num + letter)  // Combina cada número con una letra
                .subscribe(System.out::println);
    }
}
