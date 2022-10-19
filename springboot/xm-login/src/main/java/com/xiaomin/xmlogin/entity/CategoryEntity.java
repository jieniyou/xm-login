package com.xiaomin.xmlogin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login
 * @Date_Time: 2022/9/30 13:53
 */
@TableName("tb_category")
public class CategoryEntity {
    private long id;
    private String categoryName;

    public CategoryEntity() {
    }

    public CategoryEntity(long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
