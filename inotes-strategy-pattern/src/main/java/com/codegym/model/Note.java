package com.codegym.model;

import com.codegym.strategy.NoteStrategy;

/**
 * Model Note.
 *
 * Ngoai cac thuoc tinh du lieu,
 * Note co the uy quyen save/delete
 * cho mot NoteStrategy.
 */
public class Note {

    private int id;

    private String title;

    private String content;

    private int typeId;

    private String typeName;

    private transient NoteStrategy strategy;


    public Note() {
    }


    public Note(
            String title,
            String content,
            int typeId
    ) {

        this.title = title;

        this.content = content;

        this.typeId = typeId;
    }


    public Note(
            int id,
            String title,
            String content,
            int typeId
    ) {

        this.id = id;

        this.title = title;

        this.content = content;

        this.typeId = typeId;
    }


    public Note(
            int id,
            String title,
            String content,
            int typeId,
            String typeName
    ) {

        this.id = id;

        this.title = title;

        this.content = content;

        this.typeId = typeId;

        this.typeName = typeName;
    }


    public void save()
            throws Exception {

        if (strategy == null) {

            throw new IllegalStateException(
                    "NoteStrategy chua duoc cau hinh."
            );
        }


        strategy.save(this);
    }


    public void delete(int id)
            throws Exception {

        if (strategy == null) {

            throw new IllegalStateException(
                    "NoteStrategy chua duoc cau hinh."
            );
        }


        strategy.delete(id);
    }


    public int getId() {

        return id;
    }


    public void setId(int id) {

        this.id = id;
    }


    public String getTitle() {

        return title;
    }


    public void setTitle(String title) {

        this.title = title;
    }


    public String getContent() {

        return content;
    }


    public void setContent(
            String content
    ) {

        this.content = content;
    }


    public int getTypeId() {

        return typeId;
    }


    public void setTypeId(int typeId) {

        this.typeId = typeId;
    }


    public String getTypeName() {

        return typeName;
    }


    public void setTypeName(
            String typeName
    ) {

        this.typeName = typeName;
    }


    public NoteStrategy getStrategy() {

        return strategy;
    }


    public void setStrategy(
            NoteStrategy strategy
    ) {

        this.strategy = strategy;
    }
}