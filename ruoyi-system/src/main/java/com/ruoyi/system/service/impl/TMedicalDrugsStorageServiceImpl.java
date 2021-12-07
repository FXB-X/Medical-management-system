package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalDrugsStorageMapper;
import com.ruoyi.system.domain.TMedicalDrugsStorage;
import com.ruoyi.system.service.ITMedicalDrugsStorageService;

/**
 * 药库库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-25
 */
@Service
public class TMedicalDrugsStorageServiceImpl implements ITMedicalDrugsStorageService 
{
    @Autowired
    private TMedicalDrugsStorageMapper tMedicalDrugsStorageMapper;

    /**
     * 查询药库库存
     * 
     * @param ids 药库库存主键
     * @return 药库库存
     */
    @Override
    public List<TMedicalDrugsStorage> selectTMedicalDrugsStorageById(String[] ids)
    {
       return tMedicalDrugsStorageMapper.selectTMedicalDrugsStorageById(ids);
    }

    /**
     * 查询药库库存列表
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 药库库存
     */
    @Override
    public List<TMedicalDrugsStorage> selectTMedicalDrugsStorageList(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        return tMedicalDrugsStorageMapper.selectTMedicalDrugsStorageList(tMedicalDrugsStorage);
    }

    /**
     * 根据药品名称ID查询药库库存
     *
     * @param drugsid 药品名称ID
     * @return 药库库存
     */
    @Override
    public TMedicalDrugsStorage selectTMedicalDrugsById(String drugsid) {
        return tMedicalDrugsStorageMapper.selectTMedicalDrugsById(drugsid);
    }

    /**
     * 查询药品信息和药库库存信息表
     *
     * @param tMedicalDrugsStorage 药品库存信息
     * @return 药品信息和药品库存信息表
     */
    @Override
    public List<TMedicalDrugsStorage> selectTMedicalDrugs(TMedicalDrugsStorage tMedicalDrugsStorage) {
        return tMedicalDrugsStorageMapper.selectTMedicalDrugs(tMedicalDrugsStorage);
    }

    /**
     * 新增药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    @Override
    public int insertTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        tMedicalDrugsStorage.setId(SecurityUtils.getUsername()+new Date().getTime());
        tMedicalDrugsStorage.setOperator(SecurityUtils.getUsername());
        tMedicalDrugsStorage.setUpdateTime(new Date());
        return tMedicalDrugsStorageMapper.insertTMedicalDrugsStorage(tMedicalDrugsStorage);
    }

    /**
     * 修改药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    @Override
    public int updateTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        tMedicalDrugsStorage.setUpdateTime(new Date());
        return tMedicalDrugsStorageMapper.updateTMedicalDrugsStorage(tMedicalDrugsStorage);
    }

    /**
     * 批量删除药库库存
     * 
     * @param ids 需要删除的药库库存主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsStorageByIds(String[] ids)
    {
        return tMedicalDrugsStorageMapper.deleteTMedicalDrugsStorageByIds(ids);
    }

    /**
     * 删除药库库存信息
     * 
     * @param id 药库库存主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsStorageById(String id)
    {
        return tMedicalDrugsStorageMapper.deleteTMedicalDrugsStorageById(id);
    }
}
