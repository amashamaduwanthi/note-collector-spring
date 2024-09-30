package lk.ijse.noteCollector.dao;

import lk.ijse.noteCollector.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao extends JpaRepository<NoteEntity,String> {
}
