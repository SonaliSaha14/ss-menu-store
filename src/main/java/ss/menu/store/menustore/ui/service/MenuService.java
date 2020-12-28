package ss.menu.store.menustore.ui.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ss.menu.store.menustore.ui.repository.MenuRepository;
import ss.menu.store.menustore.ui.model.response.Menu;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;
	
	public List<Menu> getAllMenu(){
		return (List<Menu>) menuRepository.findAll();
	}
	
	public List<Menu> getMenuFromDesc(String matchTxt){
		return (List<Menu>) menuRepository.getMenuFromDesc(matchTxt);
	}
	
	public void AddMenu(Menu menu) {
		menuRepository.save(menu);
	}
	
	public Optional<Menu> getMenuById(String menuId) {
		Optional<Menu> menu = menuRepository.findById(menuId.toUpperCase());
		return menu;
	}
	
	public void updateMenu(Menu menu) {
		menuRepository.updateMenu(menu);
	}

	public void deletMenu(String menuId) {
		menuRepository.deleteById(menuId.toUpperCase());
		
	}
	
	
	

}
