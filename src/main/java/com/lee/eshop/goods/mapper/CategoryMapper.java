package com.lee.eshop.goods.mapper;


import com.lee.eshop.goods.po.CategoryPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品模块类目管理 mapper
 * @author admin
 */
@Mapper
public interface CategoryMapper {


    /**
     * 查询跟类目列表
     * @return 跟类目列表
     */
    List<CategoryPO> listRootCategories();


    /**
     * 查询子类目列表
     * @param parentId 父类目id
     * @return 子类目列表
     */
    List<CategoryPO> listChildCategories(long parentId);


    /**
     * 新增类目
     * @param categoryPO 商品类目PO
     */
    void createCategory(CategoryPO categoryPO);

    /**
     * 根据id 查询商品类目
     * @param id 商品类目id
     * @return 商品类目
     */
    CategoryPO getCategoryById(long id);

    /**
     * 更新商品类目信息
     * @param categoryPO 商品类目
     */
    void updateCategory(CategoryPO categoryPO);

    /**
     * 删除商品类目信息
     * @param id 商品类目id
     */
    void deleteCategory(long id);

}
