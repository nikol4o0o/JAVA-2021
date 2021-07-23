package com.test;

import com.iterator.SelectorBackward;
import com.iterator.SelectorForward;
import com.iterator.SelectorTwoWay;
import com.iterator.Sequence;

import java.util.Random;

public class SequenceTest {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 8;
        // (1)създайте Sequence последователност от 8 елемента
        Sequence sequence = new Sequence(size);
        // (2)инициализирайте Sequence елементите
        // със случайни цели числа от интервала [10, 100]
        for (int i = 0; i < size; i++) {
            sequence.add(10 + random.nextInt(91));
        }
        // (3)използвайте метода getSelector(),за да разпечатате
        // тези числа на конзолата
        // от първия до последния елемент на последователността
        System.out.println("Forwards:");
        SelectorForward selector = sequence.getSelectorForward();
        while (!selector.end()) {
            System.out.printf("%s ", selector.current());
            selector.next();
        }
        // (4)използвайте метода getRSelector(),за да разпечатате
        // на конзолата тези числа
        // от последния елемент до първия на последователността
        System.out.printf("\nBackwards:\n");
        SelectorBackward selectorBackward = sequence.getSelectorBackward();
        while (!selectorBackward.begin()) {
            System.out.printf("%s ", selectorBackward.current());
            selectorBackward.previous();
        }

        System.out.printf("\nTwo way:\n");
        SelectorTwoWay selectorTwoWay = sequence.getSelectorTwoWay();
        while (!selectorTwoWay.end()) {
            System.out.printf("%s ", selectorTwoWay.current());
            selectorTwoWay.next();
        }
        System.out.printf("%s ", selectorTwoWay.current());
        System.out.println();
        while (!selectorTwoWay.begin()) {
            System.out.printf("%s ", selectorTwoWay.current());
            selectorTwoWay.previous();
        }
    }
}
