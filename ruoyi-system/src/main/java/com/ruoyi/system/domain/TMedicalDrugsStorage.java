package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药库库存对象 t_medical_drugs_storage
 * 
 * @author ruoyi
 * @date 2021-09-25
 */
public class TMedicalDrugsStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药库库存ID */
    private String id;

    /** 药品名称ID */
    @Excel(name = "药品名称ID")
    private String drugsid;

    /** 数量 */
    @Excel(name = "数量")
    private Long no;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /**
     * 药品信息
     */
    private TMedicalDrugsInfo tMedicalDrugsInfo;

    /**
     * 药品名
     */
    private String name;

    public TMedicalDrugsStorage() {
    }

    public TMedicalDrugsInfo getTMedicalDrugsInfo() {
        return tMedicalDrugsInfo;
    }

    public void setTMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo) {
        this.tMedicalDrugsInfo = tMedicalDrugsInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public TMedicalDrugsStorage setDrugsid(String drugsid)
    {
        this.drugsid = drugsid;
        return null;
    }

    public String getDrugsid() 
    {
        return drugsid;
    }
    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugsid", getDrugsid())
            .append("no", getNo())
            .append("updateTime", getUpdateTime())
            .append("operator", getOperator())
            .toString();
    }
}
