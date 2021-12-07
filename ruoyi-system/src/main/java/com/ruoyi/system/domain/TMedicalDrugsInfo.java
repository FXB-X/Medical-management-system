package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品信息对象 t_medical_drugs_info
 * 
 * @author FXB
 * @date 2021-09-25
 */
public class TMedicalDrugsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品ID */
    private String id;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String name;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 药品描述 */
    @Excel(name = "药品描述")
    private String description;

    /** 药品状态（1.在用，2.作废） */
    @Excel(name = "药品状态", readConverterExp = "1=.在用，2.作废")
    private Integer status;

    /** 购进单价 */
    @Excel(name = "购进单价")
    private BigDecimal buyunitprice;

    /** 零售单价 */
    @Excel(name = "零售单价")
    private BigDecimal sellunitprice;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作时间
 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间 ", width = 30)
    private Date operatortime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setBuyunitprice(BigDecimal buyunitprice) 
    {
        this.buyunitprice = buyunitprice;
    }

    public BigDecimal getBuyunitprice() 
    {
        return buyunitprice;
    }
    public void setSellunitprice(BigDecimal sellunitprice) 
    {
        this.sellunitprice = sellunitprice;
    }

    public BigDecimal getSellunitprice() 
    {
        return sellunitprice;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setOperatortime(Date operatortime) 
    {
        this.operatortime = operatortime;
    }

    public Date getOperatortime() 
    {
        return operatortime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("specifications", getSpecifications())
            .append("unit", getUnit())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("buyunitprice", getBuyunitprice())
            .append("sellunitprice", getSellunitprice())
            .append("operator", getOperator())
            .append("operatortime", getOperatortime())
            .toString();
    }
}
