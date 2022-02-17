package dev.revature.Controller;

import com.google.gson.Gson;
import dev.revature.Entities.Items;
import dev.revature.Service.Abstract.ItemService;
import io.javalin.http.Handler;


public class ItemController {

    ItemService itemService;

    ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    public Handler createItem = ctx ->{
        Gson gson = new Gson();
        Items newItem = gson.fromJson(ctx.body(), Items.class);
        Items createdItem = itemService.createItemService(newItem);
        String itemAsJson = gson.toJson(createdItem);
        ctx.result(itemAsJson);
        ctx.status(201);
    };
}
