package model.facade.ws;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.dao.ItemDao;
import model.domain.Item;
import model.facade.ItemFacade;

@WebService(serviceName = "ws/item")
public class ItemFacadeImpl implements ItemFacade {

	@Inject
	private ItemDao itemDao;

	@WebMethod
	public List<Item> getItens() {
		return itemDao.getItens(new Item());
	}

	@Override
	@WebMethod(operationName = "getItemCodigo")
	public List<Item> getItens(@WebParam(name = "codigoItem") Integer codigo) {
		Item item = new Item();
		item.setCodItem(codigo);
		return itemDao.getItens(item);
	}

	@WebMethod
	public Item salvar(@WebParam(name = "item") Item item) {
		return itemDao.salvar(item);
	}

	@WebMethod
	public void atualizar(@WebParam(name = "item") Item item) {
		itemDao.atualizar(item);
	}

	@WebMethod
	public void deletarItem(@WebParam(name = "codigoItem") Integer codigo) {
		Item item = new Item();
		item.setCodItem(codigo);
		itemDao.excluir(item);
	}

}
