package com.test1.possystem.dto.paginated;

import com.test1.possystem.dto.response.ResponseOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDTO> list;
    private long pageCount;
}
