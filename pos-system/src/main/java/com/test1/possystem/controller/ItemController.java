package com.test1.possystem.controller;

import com.test1.possystem.dto.paginated.PaginatedResponseItemDTO;
import com.test1.possystem.dto.request.ItemSaveRequestDTO;
import com.test1.possystem.dto.response.ItemGetResponseDTO;
import com.test1.possystem.service.ItemService;
import com.test1.possystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")

public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {

        String msg = itemService.saveItem(itemSaveRequestDTO);
        return msg;
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByName(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByName(itemName);
        return itemGetResponseDTOS;
    }

    @GetMapping(
            path = "/get-by-name-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameMapstruct(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameMapstruct(itemName);
        return itemGetResponseDTOS;
    }

    @GetMapping(
            path = "/get-all-by-status",
            params = {"status", "page", "size"})

    public ResponseEntity<StandardResponse> getItemByActiveStatus(
            @RequestParam(value = "status") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getPaginatedItemByActiveStatus(activeStatus, page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );

    }
}
