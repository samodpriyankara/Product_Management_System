package com.test1.possystem.service;

import com.test1.possystem.dto.paginated.PaginatedResponseItemDTO;
import com.test1.possystem.dto.request.ItemSaveRequestDTO;
import com.test1.possystem.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByName(String itemName);

    List<ItemGetResponseDTO> getItemByNameMapstruct(String itemName);

    PaginatedResponseItemDTO getPaginatedItemByActiveStatus(boolean activeStatus, int page, int size);
}
