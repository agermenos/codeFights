package com.sleepsoft.challenges.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    int currentPosition = 0;
    List<Integer> valueList = new LinkedList<Integer>();
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        currentPosition=0;
        while (iterator.hasNext()) {
            valueList.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return valueList.get(currentPosition);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return valueList.get(currentPosition++);
    }

    @Override
    public boolean hasNext() {
        return valueList.size()>currentPosition;
    }
}