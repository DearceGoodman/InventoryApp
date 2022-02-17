package dev.revature.Service.Implementation;

import dev.revature.DAO.Abstract.ItemsDAO;
import dev.revature.Entities.Items;
import dev.revature.Service.Abstract.ItemService;

public class ItemServiceImp implements ItemService {

    ItemsDAO itemsDAO;
    public ItemServiceImp(ItemsDAO itemsDAO){
        this.itemsDAO = itemsDAO;
    }

    @Override
    public Items createItemService(Items items) {
        return this.itemsDAO.createItems(items);
    }

    @Override
    public Boolean deleteItemService(int itemNumber) {
        return this.itemsDAO.deleteItems(itemNumber);
    }

    @Override
    public Items decrementItemCount(Items items) {
        return null;
    }

    @Override
    public Items incrementItemCount(Items items) {
        return null;
    }
}
