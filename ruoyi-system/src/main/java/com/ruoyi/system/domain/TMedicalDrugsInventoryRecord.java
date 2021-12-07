package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 盘点记录对象 t_medical_drugs_inventory_record
 * 
 * @author FXB
 * @date 2021-09-25
 */
public class TMedicalDrugsInventoryRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 盘点记录ID */
    private String id;

    /** 药品名称ID */
    @Excel(name = "药品名称ID")
    private String drugsid;

    /** 账面数量 */
    @Excel(name = "账面数量")
    private Long papernumber;

    /** 实存数量 */
    @Excel(name = "实存数量")
    private Long existnumber;

    /** 购进单价 */
    @Excel(name = "购进单价")
    private Long buyunitprice;

    /** 零售单价 */
    @Excel(name = "零售单价")
    private Long sellunitprice;

    /** 盘盈数量 */
    @Excel(name = "盘盈数量")
    private Long inventorysurplusno;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDrugsid(String drugsid) 
    {
        this.drugsid = drugsid;
    }

    public String getDrugsid() 
    {
        return drugsid;
    }
    public void setPapernumber(Long papernumber) 
    {
        this.papernumber = papernumber;
    }

    public Long getPapernumber() 
    {
        return papernumber;
    }
    public void setExistnumber(Long existnumber) 
    {
        this.existnumber = existnumber;
    }

    public Long getExistnumber() 
    {
        return existnumber;
    }
    public void setBuyunitprice(Long buyunitprice) 
    {
        this.buyunitprice = buyunitprice;
    }

    public Long getBuyunitprice() 
    {
        return buyunitprice;
    }
    public void setSellunitprice(Long sellunitprice) 
    {
        this.sellunitprice = sellunitprice;
    }

    public Long getSellunitprice() 
    {
        return sellunitprice;
    }
    public void setInventorysurplusno(Long inventorysurplusno) 
    {
        this.inventorysurplusno = inventorysurplusno;
    }

    public Long getInventorysurplusno() 
    {
        return inventorysurplusno;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugsid", getDrugsid())
            .append("papernumber", getPapernumber())
            .append("existnumber", getExistnumber())
            .append("buyunitprice", getBuyunitprice())
            .append("sellunitprice", getSellunitprice())
            .append("inventorysurplusno", getInventorysurplusno())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
