package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalDrugsInventoryRecord;

/**
 * 盘点记录Service接口
 * 
 * @author FXB
 * @date 2021-09-25
 */
public interface ITMedicalDrugsInventoryRecordService 
{
    /**
     * 查询盘点记录
     * 
     * @param id 盘点记录主键
     * @return 盘点记录
     */
    public TMedicalDrugsInventoryRecord selectTMedicalDrugsInventoryRecordById(String id);

    /**
     * 查询盘点记录列表
     * 
     * @param tMedicalDrugsInventoryRecord 盘点记录
     * @return 盘点记录集合
     */
    public List<TMedicalDrugsInventoryRecord> selectTMedicalDrugsInventoryRecordList(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord);

    /**
     * 新增盘点记录
     * 
     * @param tMedicalDrugsInventoryRecord 盘点记录
     * @return 结果
     */
    public int insertTMedicalDrugsInventoryRecord(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord);

    /**
     * 修改盘点记录
     * 
     * @param tMedicalDrugsInventoryRecord 盘点记录
     * @return 结果
     */
    public int updateTMedicalDrugsInventoryRecord(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord);

    /**
     * 批量删除盘点记录
     * 
     * @param ids 需要删除的盘点记录主键集合
     * @return 结果
     */
    public int deleteTMedicalDrugsInventoryRecordByIds(String[] ids);

    /**
     * 删除盘点记录信息
     * 
     * @param id 盘点记录主键
     * @return 结果
     */
    public int deleteTMedicalDrugsInventoryRecordById(String id);
}
