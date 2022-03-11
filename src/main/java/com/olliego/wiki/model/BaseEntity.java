package com.olliego.wiki.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity<T extends Model> extends Model<T> {

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 创建人
     */
    @TableField(value = "create_people")
    private String createPeople;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(value = "modify_people")
    private String modifyPeople;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE, update = "NOW()",value = "modify_time")
    private Date modifyTime;

    /**
     * 0 正常 1 删除
     */
    @TableField(value = "deleted")
    @TableLogic
    private Integer deleted;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
