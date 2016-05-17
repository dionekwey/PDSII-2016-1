package model.dao;

import java.util.List;

import model.domain.*;

public interface ItemDao {
	List<Item> getItens(Item item);	
	public void excluir(Item item);
	Item salvar(Item item);
	void atualizar(Item item);	
}

