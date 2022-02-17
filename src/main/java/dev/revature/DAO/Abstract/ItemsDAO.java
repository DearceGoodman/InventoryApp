package dev.revature.DAO.Abstract;

import dev.revature.Entities.Items;

public interface ItemsDAO {
    Items createItems(Items items);
    Boolean deleteItems(int itemNumber);
    Items decrementItemCount(Items items);
    Items incrementItemCount(Items items);
}
