package com.mikey.controller;


import com.mikey.domain.ResponseResult;
import com.mikey.domain.vo.CategoryVo;
import com.mikey.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章分类
 *
 * @author mikey
 * @since 2024-02-05 17:56:36
 */
@RestController
@RequestMapping("/category")
public class CategoryController{
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取分类列表
     * @return
     */
    @GetMapping("/getCategoryList")
    public ResponseResult<CategoryVo[]> categoryList() {
        return categoryService.getCategoryList();
    }
}

