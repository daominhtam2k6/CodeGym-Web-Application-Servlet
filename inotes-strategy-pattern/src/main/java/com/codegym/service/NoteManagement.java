package com.codegym.service;

import com.codegym.model.Note;
import com.codegym.strategy.NoteStrategy;

import java.util.List;

/**
 * Context trong Strategy Pattern.
 *
 * Lop nay khong can biet du lieu dang duoc
 * luu vao MySQL hay File.
 */
public class NoteManagement {

    private NoteStrategy strategy;


    public NoteManagement() {
    }


    public NoteManagement(
            NoteStrategy strategy
    ) {

        this.strategy =
                strategy;
    }


    public void setStrategy(
            NoteStrategy strategy
    ) {

        this.strategy =
                strategy;
    }


    public NoteStrategy getStrategy() {

        return strategy;
    }


    public List<Note> findAll()
            throws Exception {

        ensureStrategy();


        return strategy.findAll();
    }


    public List<Note> searchNotes(
            String keyword
    ) throws Exception {

        ensureStrategy();


        if (
                keyword == null
                ||
                keyword.trim().isEmpty()
        ) {

            return strategy.findAll();
        }


        return strategy.search(
                keyword
        );
    }


    public Note findById(int id)
            throws Exception {

        for (
                Note note
                : findAll()
        ) {

            if (note.getId() == id) {

                return note;
            }
        }


        return null;
    }


    public Note addNote(
            String title,
            String content,
            int typeId
    ) throws Exception {

        ensureStrategy();


        Note note =
                new Note(
                        title,
                        content,
                        typeId
                );


        note.setStrategy(
                strategy
        );


        note.save();


        return note;
    }


    public void updateNote(
            int id,
            String title,
            String content,
            int typeId
    ) throws Exception {

        ensureStrategy();


        Note note =
                new Note(
                        id,
                        title,
                        content,
                        typeId
                );


        note.setStrategy(
                strategy
        );


        note.save();
    }


    public void deleteNote(int id)
            throws Exception {

        ensureStrategy();


        Note note =
                new Note();


        note.setStrategy(
                strategy
        );


        note.delete(
                id
        );
    }


    private void ensureStrategy() {

        if (strategy == null) {

            throw new IllegalStateException(
                    "NoteStrategy chua duoc cau hinh."
            );
        }
    }
}