package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.TMedicalDrugsInfo;

/**
 * 药品信息Mapper接口
 * 
 * @author FXB
 * @date 2021-09-25
 */
public interface TMedicalDrugsInfoMapper 
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
     * 删除药品信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    public int deleteTMedicalDrugsInfoById(String id);

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalDrugsInfoByIds(String[] ids);
}
