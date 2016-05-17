package model.facade;

import java.util.List;
import model.domain.Item;

public interface ItemFacade {
	List<Item> getItens();
	List<Item> getItens(Integer codigo);
	Item salvar(Item item);
	void atualizar(Item item);
	void deletarItem(Integer codigo);
}