package ss.menu.store.menustore.controller;

import ss.menu.store.menustore.exception.MenuAppException;
import ss.menu.store.menustore.model.request.MenuRequest;
import ss.menu.store.menustore.model.request.MenuUpdateRequest;
import ss.menu.store.menustore.model.response.Menu;
import ss.menu.store.menustore.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menus")
public class MenuController {

    MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    private List<Menu> menuList;

    @GetMapping
    public String getAllMenu() throws MenuAppException {

        String mnuDtlsStr = menuService.getAllMenuData();
        if (mnuDtlsStr == null || mnuDtlsStr.isEmpty()) {
            throw new MenuAppException("No Data Found");
        }
        return mnuDtlsStr;
    }

    @GetMapping(path = "/{searchString}")
    public List<Menu> getMenu(@PathVariable String searchString) throws MenuAppException {
        menuList = menuService.getMenuFromDesc(searchString);

        if (menuList == null || menuList.isEmpty()) {
            throw new MenuAppException("No Match Found");
        }
        return menuList;
    }

    @PostMapping
    public List<Menu> createMenu(@RequestBody MenuRequest menuRequest) {
        try {

            Menu newMenu = new Menu();
            newMenu.setId(menuRequest.getMenuId());
            newMenu.setDescription(menuRequest.getMenuDesc());

            menuService.AddMenu(newMenu);

            menuList = menuService.getAllMenu();

        } catch (Exception exp) {
            throw new MenuAppException("Error to add a new Menu");
        }
        return menuList;

    }

    @PutMapping(path = "/{menuId}")
    public List<Menu> updateMenu(@PathVariable String menuId, @RequestBody MenuUpdateRequest menuUpdRequest) {
        try {
            Optional<Menu> menu = menuService.getMenuById(menuId);
            if (menu.get() != null) {
                menu.get().setDescription(menuUpdRequest.getMenuDesc());
                menuService.updateMenu(menu.get());
            } else {
                Menu newMenu = new Menu();
                newMenu.setId(menuId);
                newMenu.setDescription(menuUpdRequest.getMenuDesc());
                menuService.AddMenu(newMenu);
            }
            menuList = menuService.getAllMenu();
        } catch (Exception exp) {
            throw new MenuAppException("Error to update a Menu");
        }
        return menuList;
    }

    @DeleteMapping(path = "/{menuId}")
    public List<Menu> deleteMenu(@PathVariable String menuId) {
        menuService.deletMenu(menuId);
        menuList = menuService.getAllMenu();
        return menuList;

    }

}
