package lk.ijse.noteCollector.service;

import lk.ijse.noteCollector.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteDTO saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteDTO getNote (String noteId);
    boolean deleteNotes(String noteId);
    boolean updateNotes(String noteId);


}
