package com.test1.possystem.service.impl;

import com.test1.possystem.dto.paginated.PaginatedResponseItemDTO;
import com.test1.possystem.dto.request.ItemSaveRequestDTO;
import com.test1.possystem.dto.response.ItemGetResponseDTO;
import com.test1.possystem.entity.Item;
import com.test1.possystem.exception.NotFoundException;
import com.test1.possystem.repo.ItemRepo;
import com.test1.possystem.service.ItemService;
import com.test1.possystem.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {

//        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);

        Item item = itemMapper.DtoToEntity(itemSaveRequestDTO);

        if (!itemRepo.existsById(item.getItemId())) {

            itemRepo.save(item);
            return item.getItemId() + " Saved";
        } else {
            throw new RuntimeException("Item already added");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByName(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName, b);
        if (items.size() > 0) {

            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {
            }.getType());

            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("No item found");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameMapstruct(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName, b);
        if (items.size() > 0) {

            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);

            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("No item found");
        }
    }

    @Override
    public PaginatedResponseItemDTO getPaginatedItemByActiveStatus(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActive(activeStatus, PageRequest.of(page,size));

        if(items.getSize() >0)
        {
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                    itemMapper.listPageItemToListDto(items),
                    itemRepo.countAllByActive(activeStatus)
            );
            return paginatedResponseItemDTO;
        }else{
            throw new NotFoundException("No data found");
        }
    }

}
