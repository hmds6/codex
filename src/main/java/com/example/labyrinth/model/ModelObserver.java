package com.example.labyrinth.model;

/**
 * Observer of model changes.
 */
@FunctionalInterface
public interface ModelObserver {
    void modelChanged();
}
