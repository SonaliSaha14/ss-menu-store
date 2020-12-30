package ss.menu.store.menustore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ss.menu.store.menustore.exception.MenuAppException;
import ss.menu.store.menustore.model.response.Menu;
import ss.menu.store.menustore.service.MenuService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("support")
public class SupportController {
    MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping(path = "/createTestData")
    public List<Menu> createMenu() {
        try {
            List<Menu> menuList = new ArrayList<>();
            Menu menu = new Menu();
            menu.setId("ss-mm-001");
            menu.setDescription("English Breakfast");
            menuList.add(menu);
            menuService.AddMenu(menu);

            menu = new Menu();
            menu.setId("ss-mm-002");
            menu.setDescription("Indian Breakfast");

            menuList.add(menu);
            menuService.AddMenu(menu);

            menu = new Menu();
            menu.setId("ss-mm-003");
            menu.setDescription("American Breakfast");

            menuList.add(menu);
            menuService.AddMenu(menu);

            menu = new Menu();
            menu.setId("ss-mm-004");
            menu.setDescription("Japanese Breakfast");

            menuList.add(menu);
            menuService.AddMenu(menu);

            menuService.addMenus(menuList);

            return menuService.getAllMenu();

        } catch (Exception exp) {
            throw new MenuAppException("Error to add a new Menu");
        }
    }
}
