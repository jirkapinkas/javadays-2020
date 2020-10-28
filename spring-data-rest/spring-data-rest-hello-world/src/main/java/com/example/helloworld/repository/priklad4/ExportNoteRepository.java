package com.example.helloworld.repository.priklad4;

import com.example.helloworld.entity.priklad4.ExportNote;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ExportNoteRepository extends Repository<ExportNote, Long> {

    // Když bude tato operace zapoznámkovaná,
    // tak půjde získat list záznamů, ale bez stránkování
//    Page<ExportNote> findAll(Pageable pageable);

    List<ExportNote> findAll();

    Optional<ExportNote> findById(Long id);

}
