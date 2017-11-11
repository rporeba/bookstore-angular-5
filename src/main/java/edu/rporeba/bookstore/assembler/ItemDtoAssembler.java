package edu.rporeba.bookstore.assembler;

import edu.rporeba.bookstore.dto.ItemDto;
import edu.rporeba.bookstore.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDtoAssembler {

    public static ItemDto toDto(Item item) {

        ItemDto itemDto = new ItemDto();

        itemDto.setId(item.getItemId());
        itemDto.setBorrows(item.getBorrows());
        itemDto.setBookBorrowed(item.isBookBorrowed());

        return itemDto;

    }

    public static List<ItemDto> dtoList(List<Item> items) {

        return items.stream().map(ItemDtoAssembler::toDto).collect(Collectors.toList());

    }


}
