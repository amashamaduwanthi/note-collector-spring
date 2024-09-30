package lk.ijse.noteCollector.imp;

import lk.ijse.noteCollector.customStatusCode.SelectedUserStatus;
import lk.ijse.noteCollector.dao.NoteDao;
import lk.ijse.noteCollector.dto.NoteStatus;
import lk.ijse.noteCollector.dto.impl.NoteDTO;
import lk.ijse.noteCollector.entity.impl.NoteEntity;
import lk.ijse.noteCollector.exception.DataPersistException;
import lk.ijse.noteCollector.exception.NoteNotFoundException;
import lk.ijse.noteCollector.exception.UserNotFoundException;
import lk.ijse.noteCollector.service.NoteService;
import lk.ijse.noteCollector.util.AppUtil;
import lk.ijse.noteCollector.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteServiceIMPL implements NoteService {
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private Mapping noteMapping;

//   public NoteServiceIMPL(){
//        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","remind","happy birthday","2023-10-19","1","u001"));
//        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","java","happy birthday","2023-10-19","1","u002"));
//        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","remind","happy birthday","2023-10-19","1","u003"));
//        noteDTOList.add(new NoteDTO("NOTE-1dd11b6a-3c22-4ea9-8120-62b754c0e582","remind","happy birthday","2023-10-19","1","u004"));
//    }
    @Override
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        NoteEntity savedNote =
                noteDao.save(noteMapping.toNoteEntity(noteDTO));
        if(savedNote == null){
            throw new DataPersistException("Note not saved");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
      return   noteMapping.asNoteDtoList(noteDao.findAll());
    }

    @Override
    public NoteStatus getNote(String noteId) {
        if(noteDao.existsById(noteId)){
            var selectedUser = noteDao.getReferenceById(noteId);
            return noteMapping.toNoteDto(selectedUser);
        }else {
            return new SelectedUserStatus(2,"Selected note not found");
        }
    }

    @Override
    public void deleteNotes(String noteId) {
        Optional<NoteEntity>foundNote=noteDao.findById(noteId);
        if(!foundNote.isPresent()){
            throw new NoteNotFoundException("Note with id " + noteId + " not found");
        }else {
            noteDao.deleteById(noteId);
        }
    }

    @Override
    public void updateNotes(String noteId,NoteDTO noteDTO) {
        Optional<NoteEntity>foundNote=noteDao.findById(noteId);
        if(!foundNote.isPresent()){
            throw new NoteNotFoundException("Note with id " + noteId + " not found");
        }else {
            foundNote.get().setCreatedDate(noteDTO.getCreatedDate());
            foundNote.get().setNoteDescription(noteDTO.getNoteDescription());
            foundNote.get().setNoteTitle(noteDTO.getNoteTitle());
            foundNote.get().setPriorityLevel(noteDTO.getPriorityLevel());


        }
    }
}
