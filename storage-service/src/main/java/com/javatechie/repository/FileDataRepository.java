package com.javatechie.repository;

import com.javatechie.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData , Long> {
    Optional<FileData> findByName(String fileName);

}
