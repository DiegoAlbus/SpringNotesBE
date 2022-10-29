package com.albustweetapp.tweetapp.service;

import com.albustweetapp.tweetapp.model.NoteModel;
import com.albustweetapp.tweetapp.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {
    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public NoteModel addNote(NoteModel note){
        return noteRepo.save(note);
    }

    // note NEEDS A DEFAULT CONSTRUCTOR TO AVOID INSTANTIATION EXCEPTION
    public List<NoteModel> findAllNotes(){
        return noteRepo.findAll();
    }

    public NoteModel updateNote(NoteModel note){
        return noteRepo.save(note);
    }

    public NoteModel findNoteByID(Long id){
        // TODO CHECK OPTIONAL<NoteModel> STUFF (NOTE NOT FOUND EXCEPTION)
        return noteRepo.findNoteById(id);
    }

    public void deleteNote(Long id){
        noteRepo.deleteNoteById(id);
    }
}
