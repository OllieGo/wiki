package com.olliego.wiki.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 电子书
 * </p>
 *
 * @author olliego
 * @since 2022-02-10
 */
public class Ebook implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建人
     */
    @TableField("create_people")
    private String createPeople;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField("modify_people")
    private String modifyPeople;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private LocalDateTime modifyTime;

    /**
     * 是否删除 0正常 1删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 分类一
     */
    @TableField("category_one_id")
    private Long categoryOneId;

    /**
     * 分类二
     */
    @TableField("category_two_id")
    private Long categoryTwoId;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 封面
     */
    @TableField("cover")
    private String cover;

    /**
     * 文档数
     */
    @TableField("doc_count")
    private Integer docCount;

    /**
     * 阅读数
     */
    @TableField("view_count")
    private Integer viewCount;

    /**
     * 点赞数
     */
    @TableField("vote_count")
    private Integer voteCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getModifyPeople() {
        return modifyPeople;
    }

    public void setModifyPeople(String modifyPeople) {
        this.modifyPeople = modifyPeople;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getCategoryOneId() {
        return categoryOneId;
    }

    public void setCategoryOneId(Long categoryOneId) {
        this.categoryOneId = categoryOneId;
    }
    public Long getCategoryTwoId() {
        return categoryTwoId;
    }

    public void setCategoryTwoId(Long categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "Ebook{" +
        "id=" + id +
        ", createPeople=" + createPeople +
        ", createTime=" + createTime +
        ", modifyPeople=" + modifyPeople +
        ", modifyTime=" + modifyTime +
        ", deleted=" + deleted +
        ", name=" + name +
        ", categoryOneId=" + categoryOneId +
        ", categoryTwoId=" + categoryTwoId +
        ", description=" + description +
        ", cover=" + cover +
        ", docCount=" + docCount +
        ", viewCount=" + viewCount +
        ", voteCount=" + voteCount +
        "}";
    }
}
