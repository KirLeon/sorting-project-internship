package com.innowise.Sorters;

import com.innowise.Balls.Ball;
import com.innowise.Exceptions.EmptyArrayException;

public interface Sortable {

  Ball[] sort(Ball[] balls, int k) throws EmptyArrayException;
}
