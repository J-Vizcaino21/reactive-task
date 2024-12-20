package org.josev.testReactiveMethods;

import io.reactivex.Observable;

public class MergeOperator {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 3, 5);
        Observable<Integer> observable2 = Observable.just(2, 4, 6);

        Observable.merge(observable1, observable2)  // Combinamos ambos flujos
                .subscribe(System.out::println);
    }
}
