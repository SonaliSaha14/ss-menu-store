package ss.menu.store.menustore.ui.repository;

import java.util.List;

import ss.menu.store.menustore.ui.model.response.Menu;

public interface MenuRepositoryCustom {
	
	List<Menu> getMenuFromDesc(String matchTxt);
	
	public void updateMenu(Menu menu);

}
