package com.albustweetapp.tweetapp.repo;

import com.albustweetapp.tweetapp.model.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<NoteModel, Long> {
    void deleteNoteById(Long id);

    NoteModel findNoteById(Long id);
}
