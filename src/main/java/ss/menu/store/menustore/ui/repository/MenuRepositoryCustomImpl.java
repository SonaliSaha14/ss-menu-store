package ss.menu.store.menustore.ui.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ss.menu.store.menustore.ui.model.response.Menu;

@Repository
@Transactional
public class MenuRepositoryCustomImpl implements MenuRepositoryCustom{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Menu> getMenuFromDesc(String matchTxt) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("Select * from Menu where lower(description) like ?" , Menu.class);
		query.setParameter(1, "%"+matchTxt.toLowerCase()+"%");
		return query.getResultList();
	}
	
	
	public void updateMenu(Menu menu) {
		Query query = entityManager.createNativeQuery("Update Menu set description = ? where id = ?" , Menu.class);
		query.setParameter(1, menu.getDescription());
		query.setParameter(2, menu.getId());
		query.executeUpdate();
	}

}
