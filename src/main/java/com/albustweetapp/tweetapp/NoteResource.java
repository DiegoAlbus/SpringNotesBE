package com.albustweetapp.tweetapp;

import com.albustweetapp.tweetapp.model.NoteModel;
import com.albustweetapp.tweetapp.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteResource {
    private final NoteService noteService;

    public NoteResource(NoteService noteService) {
        this.noteService = noteService;
    }

    // CONFIGURED CORS GLOBALLY IN MAIN APP METHOD -> corsConfigurer
    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<NoteModel>> getAllNotes(){
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<NoteModel> getNote(@PathVariable("id") Long id){
        return new ResponseEntity<>(noteService.findNoteByID(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<NoteModel> addNote(@RequestBody NoteModel note){

        if (note.getImageURL().isEmpty()) {
            note.setImageURL("https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/Sauron.jpg/290px-Sauron.jpg");
        }
        note.setDate(new Date());
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<NoteModel> updateNote(@RequestBody NoteModel note){
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updateNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}