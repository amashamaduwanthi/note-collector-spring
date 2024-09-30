package lk.ijse.noteCollector.dto.impl;

import lk.ijse.noteCollector.dto.NoteStatus;
import lk.ijse.noteCollector.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements NoteStatus {
    private String noteId;
    private String noteTitle;
    private String noteDescription;
    private String createdDate;
    private String priorityLevel;
    private String userId;
}
