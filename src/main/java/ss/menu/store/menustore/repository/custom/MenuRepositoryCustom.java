package ss.menu.store.menustore.repository.custom;

import java.util.List;

import ss.menu.store.menustore.model.response.Menu;

public interface MenuRepositoryCustom {
	
	List<Menu> getMenuFromDesc(String matchTxt);
	
	public void updateMenu(Menu menu);

}
