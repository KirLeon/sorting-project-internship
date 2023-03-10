package com.innowise.Sorters;

import com.innowise.Balls.BallInterface;
import com.innowise.Exceptions.EmptyArrayException;

public interface Sortable {

  BallInterface[] sort(BallInterface[] balls, int k) throws EmptyArrayException;
}
