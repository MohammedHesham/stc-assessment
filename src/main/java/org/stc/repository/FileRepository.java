package org.stc.repository;

import org.springframework.stereotype.Repository;
import org.stc.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.stc.domain.Item;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    Optional<File> findFileByItem(Item item);

}
