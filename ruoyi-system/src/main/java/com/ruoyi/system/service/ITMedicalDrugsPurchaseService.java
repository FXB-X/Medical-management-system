package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalDrugsPurchase;
import com.ruoyi.system.domain.dto.TMedicalDrugsPurchasedto;

/**
 * 药品采购信息Service接口
 * 
 * @author FXB
 * @date 2021-09-26
 */
public interface ITMedicalDrugsPurchaseService 
{
    /**
     * 查询药品采购信息
     * 
     * @param id 药品采购信息主键
     * @return 药品采购信息
     */
    public TMedicalDrugsPurchase selectTMedicalDrugsPurchaseById(String id);

    /**
     * 查询药品采购信息列表
     * 
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 药品采购信息集合
     */
    public List<TMedicalDrugsPurchase> selectTMedicalDrugsPurchaseList(TMedicalDrugsPurchase tMedicalDrugsPurchase);

    /**查询药品信息和药品采购信息表
     *
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 药品信息和药品采购信息表
     */
    public List<TMedicalDrugsPurchase> selectTMedicalDrugs(TMedicalDrugsPurchase tMedicalDrugsPurchase);

    /**
     * 新增药品采购信息
     * 
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 结果
     */
    public int insertTMedicalDrugsPurchase(TMedicalDrugsPurchase tMedicalDrugsPurchase);

    /**
     * 修改药品采购信息
     * 
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 结果
     */
    public int updateTMedicalDrugsPurchase(TMedicalDrugsPurchase tMedicalDrugsPurchase);

    /**
     * 批量删除药品采购信息
     * 
     * @param ids 需要删除的药品采购信息主键集合
     * @return 结果
     */
    public int deleteTMedicalDrugsPurchaseByIds(String[] ids);

    /**
     * 删除药品采购信息信息
     * 
     * @param id 药品采购信息主键
     * @return 结果
     */
    public int deleteTMedicalDrugsPurchaseById(String id);

}
