package com.leyou.item.web;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点id，去查询商品的分类
     * @param pid
     * @return
     */
    @RequestMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByPid(@RequestParam("pid")Long pid){
        System.out.println("111");

        return ResponseEntity.ok(categoryService.queryCategoryListByPid(pid));
    }
}
