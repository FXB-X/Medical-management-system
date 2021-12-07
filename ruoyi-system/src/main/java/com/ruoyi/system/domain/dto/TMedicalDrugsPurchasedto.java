package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.TMedicalDrugsPurchase;


/**
 *采购入库
 */
public class TMedicalDrugsPurchasedto {

  private   String [] id;
  private  Integer code;
  private TMedicalDrugsPurchase tMedicalDrugsPurchase;

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public TMedicalDrugsPurchase gettMedicalDrugsPurchase() {
        return tMedicalDrugsPurchase;
    }

    public void settMedicalDrugsPurchase(TMedicalDrugsPurchase tMedicalDrugsPurchase) {
        this.tMedicalDrugsPurchase = tMedicalDrugsPurchase;
    }



}
