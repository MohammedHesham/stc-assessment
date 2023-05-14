package org.stc.repository;

import org.stc.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.domain.enumerations.ItemType;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findItemByNameAndType(String name, ItemType itemType);
}
