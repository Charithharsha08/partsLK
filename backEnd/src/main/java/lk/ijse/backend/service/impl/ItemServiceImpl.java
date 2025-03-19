package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.ItemDTO;
import lk.ijse.backend.entity.Item;
import lk.ijse.backend.repo.ItemRepo;
import lk.ijse.backend.service.ItemService;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int addItem(ItemDTO itemDTO) {
        if (itemRepo.existsItemByItemName(itemDTO.getItemName()) && itemRepo.existsByShop_ShopId(itemDTO.getShopId())) {
            return VarList.Not_Acceptable;
        }else {
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
            return VarList.Created;
        }
    }

    @Override
    public int deleteItem(long itemId) {
        if (itemRepo.existsById(itemId)) {
            itemRepo.deleteById(itemId);
            return VarList.OK;
        } else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemId())) {
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
            return VarList.OK;
        } else {
            return VarList.Not_Found;
        }
    }

    @Override
    public ItemDTO searchItem(long itemId) {
        if (itemRepo.existsById(itemId)) {
            return modelMapper.map(itemRepo.findById(itemId).get(), ItemDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> itemList = itemRepo.findAll();
        return modelMapper.map(itemList, List.class);
    }

    @Override
    public ItemDTO searchItemByName(String itemName) {
        if (itemRepo.existsItemByItemName(itemName)) {
            return modelMapper.map(itemRepo.findItemByItemName(itemName), ItemDTO.class);
        } else {
            return null;
        }
    }
}
