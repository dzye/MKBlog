package com.mikey.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.Category;
import com.mikey.domain.vo.CategoryVo;

/**
 * 分类表(Category)表服务接口
 *
 * @author mikey
 * @since 2024-02-05 15:53:43
 */
public interface CategoryService extends IService<Category> {
    ResponseResult<CategoryVo[]> getCategoryList();
}
