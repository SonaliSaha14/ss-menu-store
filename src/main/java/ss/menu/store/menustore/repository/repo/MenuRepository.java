package ss.menu.store.menustore.repository.repo;

import org.springframework.data.repository.CrudRepository;

import ss.menu.store.menustore.model.response.Menu;
import ss.menu.store.menustore.repository.custom.MenuRepositoryCustom;

public interface MenuRepository extends CrudRepository<Menu, String>, MenuRepositoryCustom {

}
