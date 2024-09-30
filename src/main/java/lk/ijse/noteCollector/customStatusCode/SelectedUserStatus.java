package lk.ijse.noteCollector.customStatusCode;

import lk.ijse.noteCollector.dto.NoteStatus;
import lk.ijse.noteCollector.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserStatus implements UserStatus, NoteStatus {
    private int statusCode;
    private String statusMessage;
}
