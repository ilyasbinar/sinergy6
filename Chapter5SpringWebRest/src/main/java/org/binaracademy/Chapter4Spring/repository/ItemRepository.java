package org.binaracademy.Chapter4Spring.repository;

import org.binaracademy.Chapter4Spring.model.Item;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ListCrudRepository<Item, Long> {

}