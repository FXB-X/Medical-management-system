package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalDrugsInfo;
import com.ruoyi.system.domain.TMedicalDrugsStorage;

/**
 * 药品信息Service接口
 * 
 * @author FXB
 * @date 2021-09-25
 */
public interface ITMedicalDrugsInfoService 
{
    /**
     * 查询药品信息
     * 
     * @param id 药品信息主键
     * @return 药品信息
     */
    public TMedicalDrugsInfo selectTMedicalDrugsInfoById(String id);

    /**
     * 查询药品信息列表
     * 
     * @param tMedicalDrugsInfo 药品信息
     * @return 药品信息集合
     */
    public List<TMedicalDrugsInfo> selectTMedicalDrugsInfoList(TMedicalDrugsInfo tMedicalDrugsInfo);

    /**
     * 根据药品名称ID查询药库库存
     *
     * @param drugsid 药品名称ID
     * @return 药库库存
     */
    public TMedicalDrugsStorage selectTMedicalDrugsById(String drugsid);

    /**
     * 新增药品信息
     * 
     * @param tMedicalDrugsInfo 药品信息
     * @return 结果
     */
    public int insertTMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo);

    /**
     * 修改药品信息
     * 
     * @param tMedicalDrugsInfo 药品信息
     * @return 结果
     */
    public int updateTMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo);

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的药品信息主键集合
     * @return 结果
     */
    public int deleteTMedicalDrugsInfoByIds(String[] ids);

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    public int deleteTMedicalDrugsInfoById(String id);
}
