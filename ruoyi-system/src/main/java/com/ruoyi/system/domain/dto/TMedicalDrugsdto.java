package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.TMedicalDrugsInfo;
import com.ruoyi.system.domain.TMedicalDrugsPurchase;


/**
 *
 */
public class TMedicalDrugsdto {

  private TMedicalDrugsPurchase tMedicalDrugsPurchase;
  private TMedicalDrugsInfo tMedicalDrugsInfo;


    public TMedicalDrugsPurchase gettMedicalDrugsPurchase() {
        return tMedicalDrugsPurchase;
    }

    public void settMedicalDrugsPurchase(TMedicalDrugsPurchase tMedicalDrugsPurchase) {
        this.tMedicalDrugsPurchase = tMedicalDrugsPurchase;
    }

    public TMedicalDrugsInfo gettMedicalDrugsInfo() {
        return tMedicalDrugsInfo;
    }

    public void settMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo) {
        this.tMedicalDrugsInfo = tMedicalDrugsInfo;
    }
}
