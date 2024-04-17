package com.test1.possystem.util.mappers;

import com.test1.possystem.dto.request.ItemSaveRequestDTO;
import com.test1.possystem.dto.response.ItemGetResponseDTO;
import com.test1.possystem.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

    ItemGetResponseDTO entityToDto(Item item);

    Item DtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> listPageItemToListDto(Page<Item> items);

}
