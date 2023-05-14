package org.stc.repository;

import org.springframework.stereotype.Repository;
import org.stc.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {}
