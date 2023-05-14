package org.stc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stc.controller.errors.NotFoundException;
import org.stc.domain.Item;
import org.stc.domain.PermissionGroup;
import org.stc.domain.enumerations.ItemType;
import org.stc.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService( ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    Item findItemByNameAndType(ItemType itemType, String name) {
        return itemRepository.findItemByNameAndType(name, itemType).orElseThrow(()
                -> new NotFoundException("Failed to find item"));
    }


    Item create(String itemName, ItemType itemType, PermissionGroup permissionGroup, Item parent) {
        Item item = new Item();
        item.setName(itemName);
        item.setType(itemType);
        item.setParent(parent);
        item.setPermissionGroup(permissionGroup);
        item = itemRepository.save(item);
        return item;
    }
}
