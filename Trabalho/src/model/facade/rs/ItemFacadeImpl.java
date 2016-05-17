package model.facade.rs;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.dao.ItemDao;
import model.domain.Item;
import model.facade.ItemFacade;

@Transactional
@Path("/item")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ItemFacadeImpl implements ItemFacade {

	@Inject
	private ItemDao ItemDao;
	
	@Override
	@GET
	public List<Item> getItens() {
		return ItemDao.getItens(new Item());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Item> getItens(@PathParam("codigo") Integer codigo) {
		Item Item = new Item();
		Item.setCodItem(codigo);
		return ItemDao.getItens(Item);
	}
	

	@Override
	@POST 
	public Item salvar(Item Item) { 
		Item = ItemDao.salvar(Item);
	 	return Item;
	}
	
	@Override
	@PUT 
	public void atualizar(Item Item) { 
		ItemDao.atualizar(Item);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarItem(@PathParam("codigo") Integer codigo) {
		Item Item = new Item();
		Item.setCodItem(codigo);
		ItemDao.excluir(Item);
	}

}
