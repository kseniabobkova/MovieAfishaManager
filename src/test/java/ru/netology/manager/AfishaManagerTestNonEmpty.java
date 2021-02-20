package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTestNonEmpty {
    @Test
    public void shouldRemoveIfExists() {
        AfishaManager manager = new AfishaManager();
        int idToRemove = 1;
        MovieItem first = new MovieItem(1,  "first");
        MovieItem second = new MovieItem(2, "second");
        MovieItem third = new MovieItem(3, "third");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        AfishaManager manager = new AfishaManager();
        int idToRemove = 4;
        MovieItem first = new MovieItem(1,  "first");
        MovieItem second = new MovieItem(2,  "second");
        MovieItem third = new MovieItem(3, "third");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}