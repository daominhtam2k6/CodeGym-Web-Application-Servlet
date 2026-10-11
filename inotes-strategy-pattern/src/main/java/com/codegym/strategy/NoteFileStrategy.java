package com.codegym.strategy;

import com.codegym.model.Note;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Strategy luu Note vao File TXT.
 *
 * Format:
 *
 * id|title|content|typeId
 *
 * File mac dinh:
 *
 * USER_HOME/inotes-data/notes.txt
 */
public class NoteFileStrategy
        implements NoteStrategy {

    private final Path filePath;


    public NoteFileStrategy()
            throws Exception {

        Path directory =
                Paths.get(
                        System.getProperty(
                                "user.home"
                        ),
                        "inotes-data"
                );


        Files.createDirectories(
                directory
        );


        filePath =
                directory.resolve(
                        "notes.txt"
                );


        if (Files.notExists(filePath)) {

            Files.createFile(
                    filePath
            );
        }
    }


    @Override
    public void save(Note note)
            throws Exception {

        synchronized (
                NoteFileStrategy.class
        ) {

            List<Note> notes =
                    readAll();


            if (note.getId() <= 0) {

                int nextId =
                        nextId(notes);


                note.setId(
                        nextId
                );


                notes.add(
                        note
                );


                writeAll(
                        notes
                );

                return;
            }


            boolean updated =
                    false;


            for (
                    int i = 0;
                    i < notes.size();
                    i++
            ) {

                if (
                        notes
                                .get(i)
                                .getId()
                        == note.getId()
                ) {

                    notes.set(
                            i,
                            note
                    );


                    updated =
                            true;
                }
            }



            if (!updated) {

                notes.add(
                        note
                );
            }


            writeAll(
                    notes
            );
        }
    }


    @Override
    public void delete(int id)
            throws Exception {

        synchronized (
                NoteFileStrategy.class
        ) {

            List<Note> notes =
                    readAll();


            notes.removeIf(
                    note ->
                            note.getId()
                            == id
            );


            writeAll(
                    notes
            );
        }
    }


    @Override
    public List<Note> findAll()
            throws Exception {

        synchronized (
                NoteFileStrategy.class
        ) {

            return readAll();
        }
    }


    @Override
    public List<Note> search(
            String keyword
    ) throws Exception {

        String normalized =
                keyword
                        .trim()
                        .toLowerCase(
                                Locale.ROOT
                        );


        List<Note> result =
                new ArrayList<>();


        for (
                Note note
                : findAll()
        ) {

            String title =
                    note.getTitle()
                            .toLowerCase(
                                    Locale.ROOT
                            );


            String content =
                    note.getContent()
                            .toLowerCase(
                                    Locale.ROOT
                            );


            if (
                    title.contains(
                            normalized
                    )
                    ||
                    content.contains(
                            normalized
                    )
            ) {

                result.add(
                        note
                );
            }
        }


        return result;
    }


    private List<Note> readAll()
            throws Exception {

        List<Note> result =
                new ArrayList<>();


        List<String> lines =
                Files.readAllLines(
                        filePath,
                        StandardCharsets.UTF_8
                );


        for (
                String line
                : lines
        ) {

            if (
                    line == null
                    ||
                    line.trim().isEmpty()
            ) {

                continue;
            }


            String[] fields =
                    line.split(
                            "\\|",
                            4
                    );


            if (fields.length != 4) {

                continue;
            }


            int id =
                    Integer.parseInt(
                            fields[0]
                    );


            String title =
                    fields[1];


            String content =
                    fields[2];


            int typeId =
                    Integer.parseInt(
                            fields[3]
                    );


            result.add(
                    new Note(
                            id,
                            title,
                            content,
                            typeId,
                            typeNameFor(
                                    typeId
                            )
                    )
            );
        }


        return result;
    }


    private void writeAll(
            List<Note> notes
    ) throws Exception {

        List<String> lines =
                new ArrayList<>();


        for (
                Note note
                : notes
        ) {

            lines.add(
                    note.getId()
                    + "|"
                    + clean(
                            note.getTitle()
                    )
                    + "|"
                    + clean(
                            note.getContent()
                    )
                    + "|"
                    + note.getTypeId()
            );
        }


        Files.write(
                filePath,
                lines,
                StandardCharsets.UTF_8
        );
    }


    private int nextId(
            List<Note> notes
    ) {

        int max =
                0;


        for (
                Note note
                : notes
        ) {

            if (
                    note.getId()
                    > max
            ) {

                max =
                        note.getId();
            }
        }


        return max + 1;
    }


    private String clean(
            String value
    ) {

        if (value == null) {

            return "";
        }


        return value
                .replace(
                        "|",
                        "/"
                )
                .replace(
                        "\r",
                        " "
                )
                .replace(
                        "\n",
                        " "
                );
    }


    private String typeNameFor(
            int typeId
    ) {

        if (typeId == 1) {

            return "Cá nhân";
        }


        if (typeId == 2) {

            return "Công việc";
        }


        if (typeId == 3) {

            return "Học tập";
        }


        return "Khác";
    }
}