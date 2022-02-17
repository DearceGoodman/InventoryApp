package dev.revature.Service.Abstract;

import dev.revature.Entities.Items;

public interface ItemService {
    Items createItemService(Items items);
    Boolean deleteItemService(int itemNumber);
    Items decrementItemCount(Items items);
    Items incrementItemCount(Items items);

}
