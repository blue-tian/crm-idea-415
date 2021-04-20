package com.bing.guo.domain.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建者
     */
    @JsonIgnore
    private Long createBy;

    /**
     * 创建时间
     */
    //不参与json字符串转化，不返回前端
    @JsonIgnore
    private LocalDateTime createTime;

    /**
     * 修改者
     */
    @JsonIgnore
    private Long updateBy;

    /**
     * 修改时间
     */
    @JsonIgnore
    private LocalDateTime updateTime;

    private void setData() {
        if (id == null) {
            this.createBy=1L;
            this.createTime=LocalDateTime.now();
        } else {
            this.updateBy=2L;
            this.updateTime=LocalDateTime.now();
        }
    }

}
