package com.projects.Homepage.Itemlist;

import com.projects.Homepage.Todos.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
