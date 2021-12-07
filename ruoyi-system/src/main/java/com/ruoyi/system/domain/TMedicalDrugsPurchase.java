package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品采购信息对象 t_medical_drugs_purchase
 * 
 * @author FXB
 * @date 2021-09-26
 */
public class TMedicalDrugsPurchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品采购信息ID */
    private String id;

    /** 药品名称ID */
    @Excel(name = "药品名称ID")
    private String drugsid;

    /** 药品来源 */
    @Excel(name = "药品来源")
    private String source;

    /** 产地 */
    @Excel(name = "产地")
    private String address;

    /** 批号 */
    @Excel(name = "批号")
    private String batchnumbe;

    /** 数量 */
    @Excel(name = "数量")
    private Long no;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manufacturetime;

    /** 有效期 */
    @Excel(name = "有效期")
    private Integer termofvalidity;

    /** 摘要 */
    @Excel(name = "摘要")
    private String abstracts;

    /** 填制人 */
    @Excel(name = "填制人")
    private String filledby;

    /** 填制日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "填制日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /** 核查人 */
    @Excel(name = "核查人")
    private String verifier;

    /** 核查日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "核查日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date verificationtime;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewer;

    /** 审核日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:dd:ss")
    @Excel(name = "审核日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date audittime;


    private  TMedicalDrugsInfo tMedicalDrugsInfo;


    private String name;


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
    public void setDrugsid(String drugsid) 
    {
        this.drugsid = drugsid;
    }

    public String getDrugsid() 
    {
        return drugsid;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setBatchnumbe(String batchnumbe) 
    {
        this.batchnumbe = batchnumbe;
    }

    public String getBatchnumbe() 
    {
        return batchnumbe;
    }
    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setManufacturetime(Date manufacturetime) 
    {
        this.manufacturetime = manufacturetime;
    }

    public Date getManufacturetime() 
    {
        return manufacturetime;
    }
    public void setTermofvalidity(Integer termofvalidity) 
    {
        this.termofvalidity = termofvalidity;
    }

    public Integer getTermofvalidity() 
    {
        return termofvalidity;
    }
    public void setAbstracts(String abstracts) 
    {
        this.abstracts = abstracts;
    }

    public String getAbstracts() 
    {
        return abstracts;
    }
    public void setFilledby(String filledby) 
    {
        this.filledby = filledby;
    }

    public String getFilledby() 
    {
        return filledby;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setVerifier(String verifier) 
    {
        this.verifier = verifier;
    }

    public String getVerifier() 
    {
        return verifier;
    }
    public void setVerificationtime(Date verificationtime) 
    {
        this.verificationtime = verificationtime;
    }

    public Date getVerificationtime() 
    {
        return verificationtime;
    }
    public void setReviewer(String reviewer) 
    {
        this.reviewer = reviewer;
    }

    public String getReviewer() 
    {
        return reviewer;
    }
    public void setAudittime(Date audittime) 
    {
        this.audittime = audittime;
    }

    public Date getAudittime() 
    {
        return audittime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugsid", getDrugsid())
            .append("source", getSource())
            .append("address", getAddress())
            .append("batchnumbe", getBatchnumbe())
            .append("no", getNo())
            .append("manufacturetime", getManufacturetime())
            .append("termofvalidity", getTermofvalidity())
            .append("abstracts", getAbstracts())
            .append("filledby", getFilledby())
            .append("createtime", getCreatetime())
            .append("verifier", getVerifier())
            .append("verificationtime", getVerificationtime())
            .append("reviewer", getReviewer())
            .append("audittime", getAudittime())
            .toString();
    }
}
