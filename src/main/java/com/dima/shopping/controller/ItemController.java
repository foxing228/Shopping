package com.dima.shopping.controller;

import com.dima.shopping.domain.Item;
import com.dima.shopping.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Transactional
@Controller
@RequestMapping("/")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("items")
    public String getAll(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items";
    }

}
