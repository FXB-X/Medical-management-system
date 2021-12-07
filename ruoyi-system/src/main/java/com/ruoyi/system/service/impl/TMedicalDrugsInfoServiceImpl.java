package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.TMedicalDrugsStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalDrugsInfoMapper;
import com.ruoyi.system.domain.TMedicalDrugsInfo;
import com.ruoyi.system.service.ITMedicalDrugsInfoService;

/**
 * 药品信息Service业务层处理
 * 
 * @author FXB
 * @date 2021-09-25
 */
@Service
public class TMedicalDrugsInfoServiceImpl implements ITMedicalDrugsInfoService 
{
    @Autowired
    private TMedicalDrugsInfoMapper tMedicalDrugsInfoMapper;

    /**
     * 查询药品信息
     * 
     * @param id 药品信息主键
     * @return 药品信息
     */
    @Override
    public TMedicalDrugsInfo selectTMedicalDrugsInfoById(String id)
    {
        return tMedicalDrugsInfoMapper.selectTMedicalDrugsInfoById(id);
    }

    /**
     * 查询药品信息列表
     * 
     * @param tMedicalDrugsInfo 药品信息
     * @return 药品信息
     */
    @Override
    public List<TMedicalDrugsInfo> selectTMedicalDrugsInfoList(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        return tMedicalDrugsInfoMapper.selectTMedicalDrugsInfoList(tMedicalDrugsInfo);
    }

    @Override
    public TMedicalDrugsStorage selectTMedicalDrugsById(String drugsid) {
        return null;
    }

    /**
     * 新增药品信息
     * 
     * @param tMedicalDrugsInfo 药品信息
     * @return 结果
     */
    @Override
    public int insertTMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        tMedicalDrugsInfo.setId(SecurityUtils.getUsername()+new Date().getTime());
        tMedicalDrugsInfo.setOperator(SecurityUtils.getUsername());
        tMedicalDrugsInfo.setOperatortime(new Date());
        return tMedicalDrugsInfoMapper.insertTMedicalDrugsInfo(tMedicalDrugsInfo);
    }

    /**
     * 修改药品信息
     * 
     * @param tMedicalDrugsInfo 药品信息
     * @return 结果
     */
    @Override
    public int updateTMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        tMedicalDrugsInfo.setOperator(SecurityUtils.getUsername());
        tMedicalDrugsInfo.setOperatortime(new Date());
        return tMedicalDrugsInfoMapper.updateTMedicalDrugsInfo(tMedicalDrugsInfo);
    }

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的药品信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsInfoByIds(String[] ids)
    {
        return tMedicalDrugsInfoMapper.deleteTMedicalDrugsInfoByIds(ids);
    }

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsInfoById(String id)
    {
        return tMedicalDrugsInfoMapper.deleteTMedicalDrugsInfoById(id);
    }
}
