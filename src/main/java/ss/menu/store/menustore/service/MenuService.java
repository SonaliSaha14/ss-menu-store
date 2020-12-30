package ss.menu.store.menustore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ss.menu.store.menustore.model.response.Menu;
import ss.menu.store.menustore.repository.repo.MenuRepository;

import java.util.List;
import java.util.Optional;

@Component
public class MenuService {

    MenuRepository menuRepository;

    @Autowired
    public void setMenuRepository(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Value("${data.service.url}")
    private String dataServUrl;

    public List<Menu> getAllMenu() {
        return (List<Menu>) menuRepository.findAll();
    }

    public String getAllMenuData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(dataServUrl, String.class);
    }

    public List<Menu> getMenuFromDesc(String matchTxt) {
        return (List<Menu>) menuRepository.getMenuFromDesc(matchTxt);
    }

    public void AddMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void addMenus(List<Menu> menuList) {
        assert menuList != null : "Menu List must not be null";
        menuList.forEach(menu -> menuRepository.save(menu));
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
