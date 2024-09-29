package lk.ijse.noteCollector.controller;

import lk.ijse.noteCollector.dto.impl.NoteDTO;
import lk.ijse.noteCollector.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
  private   NoteService noteService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO SaveNote(@RequestBody NoteDTO noteDTO){

        return noteService.saveNote(noteDTO);

    }
    public NoteDTO getSelectedNote(){
        return null;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNote(){
        return noteService.getAllNotes();

    }

    public void deleteNote(String noteId){

    }
    public void updateNote(String noteId,NoteDTO noteDTO){

    }
}
