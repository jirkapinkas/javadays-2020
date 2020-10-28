package com.example.helloworld.repository.priklad4;

import com.example.helloworld.entity.priklad4.Note;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.access.prepost.PreAuthorize;

//@PreAuthorize("hasRole('ADMIN')")
public interface NoteRepository extends JpaRepository<Note, Long> {
}
