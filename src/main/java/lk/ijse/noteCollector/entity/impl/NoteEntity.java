package lk.ijse.noteCollector.entity.impl;

import jakarta.persistence.*;
import lk.ijse.noteCollector.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "note")
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDescription;
    private String createdDate;
    private String priorityLevel;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;
}
