package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalDrugsInventoryRecordMapper;
import com.ruoyi.system.domain.TMedicalDrugsInventoryRecord;
import com.ruoyi.system.service.ITMedicalDrugsInventoryRecordService;

/**
 * 盘点记录Service业务层处理
 * 
 * @author FXB
 * @date 2021-09-25
 */
@Service
public class TMedicalDrugsInventoryRecordServiceImpl implements ITMedicalDrugsInventoryRecordService 
{
    @Autowired
    private TMedicalDrugsInventoryRecordMapper tMedicalDrugsInventoryRecordMapper;

    /**
     * 查询盘点记录
     * 
     * @param id 盘点记录主键
     * @return 盘点记录
     */
    @Override
    public TMedicalDrugsInventoryRecord selectTMedicalDrugsInventoryRecordById(String id)
    {
        return tMedicalDrugsInventoryRecordMapper.selectTMedicalDrugsInventoryRecordById(id);
    }

    /**
     * 查询盘点记录列表
     * 
     * @param tMedicalDrugsInventoryRecord 盘点记录
     * @return 盘点记录
     */
    @Override
    public List<TMedicalDrugsInventoryRecord> selectTMedicalDrugsInventoryRecordList(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord)
    {
        return tMedicalDrugsInventoryRecordMapper.selectTMedicalDrugsInventoryRecordList(tMedicalDrugsInventoryRecord);
    }

    /**
     * 新增盘点记录
     * 
     * @param tMedicalDrugsInventoryRecord 盘点记录
     * @return 结果
     */
    @Override
    public int insertTMedicalDrugsInventoryRecord(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord)
    {
        tMedicalDrugsInventoryRecord.setCreateTime(DateUtils.getNowDate());
        return tMedicalDrugsInventoryRecordMapper.insertTMedicalDrugsInventoryRecord(tMedicalDrugsInventoryRecord);
    }

    /**
     * 修改盘点记录
     * 
     * @param tMedicalDrugsInventoryRecord 盘点记录
     * @return 结果
     */
    @Override
    public int updateTMedicalDrugsInventoryRecord(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord)
    {
        return tMedicalDrugsInventoryRecordMapper.updateTMedicalDrugsInventoryRecord(tMedicalDrugsInventoryRecord);
    }

    /**
     * 批量删除盘点记录
     * 
     * @param ids 需要删除的盘点记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsInventoryRecordByIds(String[] ids)
    {
        return tMedicalDrugsInventoryRecordMapper.deleteTMedicalDrugsInventoryRecordByIds(ids);
    }

    /**
     * 删除盘点记录信息
     * 
     * @param id 盘点记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsInventoryRecordById(String id)
    {
        return tMedicalDrugsInventoryRecordMapper.deleteTMedicalDrugsInventoryRecordById(id);
    }
}
