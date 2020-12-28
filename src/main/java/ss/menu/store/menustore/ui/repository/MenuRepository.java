package ss.menu.store.menustore.ui.repository;

import org.springframework.data.repository.CrudRepository;

import ss.menu.store.menustore.ui.model.response.Menu;

public interface MenuRepository extends CrudRepository<Menu, String>,MenuRepositoryCustom {

}
