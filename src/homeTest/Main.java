package homeTest;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Integer[] listElements = {1, 2, 3, 4, 5, 6, 7};
        Integer[] expectedElements = {2, 3, 4, 5, 6, 7};

        SimpleArrayList<Integer> arrayList = new SimpleArrayList<>();

        for (int i = 0; i < listElements.length; i++) {
            arrayList.add(listElements[i]);
        }
        //System.out.println(arrayList.toString());

        SimpleArrayList<Integer> expectedArrayList = new SimpleArrayList<>();

        for (int i = 0; i < expectedElements.length; i++) {
            expectedArrayList.add(expectedElements[i]);
        }


        Iterator<Integer> iterator = null;
        try {
            iterator = arrayList.iterator();
        } catch (UnsupportedOperationException u) {
            throw new AssertionError("Iterator not implemented");
        }

        if (iterator == null)
            throw new AssertionError("Iterator must be no equals null");

        try {
            iterator.next();
            iterator.remove();
        } catch (IllegalStateException e) {
            throw new AssertionError("Non-expected throw IllegalStateException form iterator.remove()");
        }

        System.out.println(expectedArrayList.toString() + " length = " + expectedArrayList.size());
        System.out.println(arrayList.toString() + " length = " + arrayList.size());
        if (arrayList.equals(expectedArrayList)) {
            System.out.println("test pass");
        }



        //test linked list
        Integer[] testElement = {1, 2, 3, 4, 5, 6, 7, 8};
        //first array list
        SimpleArrayList<Integer> firstSimpleArrayList = new SimpleArrayList<>();
        for (int i = 0; i < testElement.length; i++) {
            firstSimpleArrayList.add(testElement[i]);
        }

        //second array list
        SimpleArrayList<Integer> secondSimpleArrayList = new SimpleArrayList<>();

        for (int i = 0; i < testElement.length - 2; i++) {
            secondSimpleArrayList.add(testElement[i]);
        }
        System.out.println(firstSimpleArrayList.hashCode());
        System.out.println(secondSimpleArrayList.hashCode());

        if (firstSimpleArrayList.hashCode() != secondSimpleArrayList.hashCode()) {
            System.out.println("test passed 2");
        }


        //check linked list

        Integer[] testElement2  = {1,2,3,4,5,6,7,8};
        //first array list
        SimpleLinkedList<Integer> firstSimpleLinkedList = new SimpleLinkedList<>();
        for (int i = 0; i <testElement2.length ; i++) {
            firstSimpleLinkedList.add(testElement2[i]);
        }

        //second array list
        SimpleLinkedList<Integer> secondSimpleLinkedList = new SimpleLinkedList<>();

        for (int i = 0; i <testElement2.length ; i++) {
            secondSimpleLinkedList.add(testElement2[i]);
        }

        System.out.println(firstSimpleLinkedList.toString());
        System.out.println(secondSimpleLinkedList.toString());

        //check
        if (!firstSimpleLinkedList.equals(secondSimpleLinkedList))
            throw new AssertionError("Two simpleLinkedList with identical type and with identical elements should be equals");


        System.out.print("OK");
    }

}