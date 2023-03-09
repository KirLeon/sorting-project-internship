package Sorters;

import Balls.Ball;
import Exceptions.EmptyArrayException;

public interface Sortable {

  Ball[] sort(Ball[] balls, int k) throws EmptyArrayException;
}
