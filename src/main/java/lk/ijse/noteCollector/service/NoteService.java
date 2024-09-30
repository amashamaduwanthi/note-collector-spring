package lk.ijse.noteCollector.service;

import lk.ijse.noteCollector.dto.NoteStatus;
import lk.ijse.noteCollector.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote (String noteId);
   void deleteNotes(String noteId);



    void updateNotes(String noteId, NoteDTO updatedNoteDto);
}
