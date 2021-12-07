package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalDrugsPharmacy;

/**
 * 药房库存Service接口
 * 
 * @author FXB
 * @date 2021-09-25
 */
public interface ITMedicalDrugsPharmacyService 
{
    /**
     * 查询药房库存
     * 
     * @param id 药房库存主键
     * @return 药房库存
     */
    public TMedicalDrugsPharmacy selectTMedicalDrugsPharmacyById(String id);

    /**
     * 查询药房库存列表
     * 
     * @param tMedicalDrugsPharmacy 药房库存
     * @return 药房库存集合
     */
    public List<TMedicalDrugsPharmacy> selectTMedicalDrugsPharmacyList(TMedicalDrugsPharmacy tMedicalDrugsPharmacy);

    /**
     * 新增药房库存
     * 
     * @param tMedicalDrugsPharmacy 药房库存
     * @return 结果
     */
    public int insertTMedicalDrugsPharmacy(TMedicalDrugsPharmacy tMedicalDrugsPharmacy);

    /**
     * 修改药房库存
     * 
     * @param tMedicalDrugsPharmacy 药房库存
     * @return 结果
     */
    public int updateTMedicalDrugsPharmacy(TMedicalDrugsPharmacy tMedicalDrugsPharmacy);

    /**
     * 批量删除药房库存
     * 
     * @param ids 需要删除的药房库存主键集合
     * @return 结果
     */
    public int deleteTMedicalDrugsPharmacyByIds(String[] ids);

    /**
     * 删除药房库存信息
     * 
     * @param id 药房库存主键
     * @return 结果
     */
    public int deleteTMedicalDrugsPharmacyById(String id);
}
