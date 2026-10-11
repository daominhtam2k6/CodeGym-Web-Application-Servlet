package com.codegym.strategy;

import com.codegym.model.Note;

import java.util.List;

/**
 * Strategy Pattern:
 *
 * NoteManagement chi lam viec qua interface nay.
 *
 * Tang luu tru co the la:
 *
 * - MySQL
 * - File TXT
 */
public interface NoteStrategy {

    void save(Note note)
            throws Exception;

    void delete(int id)
            throws Exception;

    List<Note> findAll()
            throws Exception;

    List<Note> search(
            String keyword
    ) throws Exception;
}