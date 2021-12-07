package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.TMedicalDrugsPurchase;
import com.ruoyi.system.domain.TMedicalDrugsStorage;

/**
 * 药库库存Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-25
 */
public interface TMedicalDrugsStorageMapper 
{
    /**
     * 查询药库库存
     *
     * @param ids 药库库存主键
     * @return 药库库存
     */
    public List<TMedicalDrugsStorage> selectTMedicalDrugsStorageById(String[] ids);

    /**
     * 根据药品名称ID查询药库库存
     *
     * @param drugsid 药品主键
     * @return 药库库存
     */
    public TMedicalDrugsStorage selectTMedicalDrugsById(String drugsid);

    /**查询药品信息和药库库存信息表
     *
     * @param tMedicalDrugsStorage 药品库存信息
     * @return 药品信息和药品库存信息表
     */
    public List<TMedicalDrugsStorage> selectTMedicalDrugs(TMedicalDrugsStorage tMedicalDrugsStorage);

    /**
     * 查询药库库存列表
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 药库库存集合
     */
    public List<TMedicalDrugsStorage> selectTMedicalDrugsStorageList(TMedicalDrugsStorage tMedicalDrugsStorage);

    /**
     * 新增药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    public int insertTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage);

    /**
     * 修改药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    public int updateTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage);

    /**
     * 删除药库库存
     * 
     * @param id 药库库存主键
     * @return 结果
     */
    public int deleteTMedicalDrugsStorageById(String id);

    /**
     * 批量删除药库库存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalDrugsStorageByIds(String[] ids);
}
