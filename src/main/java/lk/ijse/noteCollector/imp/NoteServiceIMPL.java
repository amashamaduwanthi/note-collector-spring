package lk.ijse.noteCollector.imp;

import lk.ijse.noteCollector.dto.impl.NoteDTO;
import lk.ijse.noteCollector.service.NoteService;
import lk.ijse.noteCollector.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NoteServiceIMPL implements NoteService {
    private static List<NoteDTO> noteDTOList=new ArrayList<>();
   public NoteServiceIMPL(){
        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","remind","happy birthday","2023-10-19","1","u001"));
        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","java","happy birthday","2023-10-19","1","u002"));
        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","remind","happy birthday","2023-10-19","1","u003"));
        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","remind","happy birthday","2023-10-19","1","u004"));
    }
    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        return noteDTO;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteDTOList;
    }

    @Override
    public NoteDTO getNote(String noteId) {
       return null;
    }

    @Override
    public boolean deleteNotes(String noteId) {
        return false;
    }

    @Override
    public boolean updateNotes(String noteId) {
        return false;
    }
}
