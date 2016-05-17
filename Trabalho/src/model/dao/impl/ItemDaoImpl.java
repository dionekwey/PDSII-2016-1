package model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import model.domain.*;
import model.dao.*;

public class ItemDaoImpl implements ItemDao {

	@PersistenceContext(unitName="TrabalhoPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Item> getItens(Item item) {
		StringBuffer hql = new StringBuffer("from Item c" + " where 1 = 1");		
		if (item.getCodItem() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (item.getCodItem() != null) {
			query.setParameter("codigo",item.getCodItem());
		} 
		return query.getResultList();
	}
		
	@Override
	@Transactional
	public void excluir(Item item) {
		item = entityManager.merge(item);
		entityManager.remove(item);
	}

	@Override
	@Transactional
	public Item salvar(Item item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	@Transactional
	public void atualizar(Item item) {
		item = entityManager.merge(item);
		entityManager.persist(item);		
	}

}
