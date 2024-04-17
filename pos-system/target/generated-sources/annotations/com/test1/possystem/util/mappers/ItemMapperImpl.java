package com.test1.possystem.util.mappers;

import com.test1.possystem.dto.request.ItemSaveRequestDTO;
import com.test1.possystem.dto.response.ItemGetResponseDTO;
import com.test1.possystem.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T17:56:51+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public List<ItemGetResponseDTO> entityListToDtoList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>( items.size() );
        for ( Item item : items ) {
            list.add( entityToDto( item ) );
        }

        return list;
    }

    @Override
    public ItemGetResponseDTO entityToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO();

        itemGetResponseDTO.setItemId( item.getItemId() );
        itemGetResponseDTO.setItemName( item.getItemName() );
        itemGetResponseDTO.setBalanceQty( item.getBalanceQty() );
        itemGetResponseDTO.setSupplierPrice( item.getSupplierPrice() );
        itemGetResponseDTO.setSellingPrice( item.getSellingPrice() );
        itemGetResponseDTO.setActive( item.isActive() );

        return itemGetResponseDTO;
    }

    @Override
    public Item DtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO) {
        if ( itemSaveRequestDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.setItemName( itemSaveRequestDTO.getItemName() );
        item.setMeasuringUnitType( itemSaveRequestDTO.getMeasuringUnitType() );
        item.setBalanceQty( itemSaveRequestDTO.getBalanceQty() );
        item.setSupplierPrice( itemSaveRequestDTO.getSupplierPrice() );
        item.setSellingPrice( itemSaveRequestDTO.getSellingPrice() );

        return item;
    }

    @Override
    public List<ItemGetResponseDTO> listPageItemToListDto(Page<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>();
        for ( Item item : items ) {
            list.add( entityToDto( item ) );
        }

        return list;
    }
}
