package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalDrugsPharmacyMapper;
import com.ruoyi.system.domain.TMedicalDrugsPharmacy;
import com.ruoyi.system.service.ITMedicalDrugsPharmacyService;

/**
 * 药房库存Service业务层处理
 * 
 * @author FXB
 * @date 2021-09-25
 */
@Service
public class TMedicalDrugsPharmacyServiceImpl implements ITMedicalDrugsPharmacyService 
{
    @Autowired
    private TMedicalDrugsPharmacyMapper tMedicalDrugsPharmacyMapper;

    /**
     * 查询药房库存
     * 
     * @param id 药房库存主键
     * @return 药房库存
     */
    @Override
    public TMedicalDrugsPharmacy selectTMedicalDrugsPharmacyById(String id)
    {
        return tMedicalDrugsPharmacyMapper.selectTMedicalDrugsPharmacyById(id);
    }

    /**
     * 查询药房库存列表
     * 
     * @param tMedicalDrugsPharmacy 药房库存
     * @return 药房库存
     */
    @Override
    public List<TMedicalDrugsPharmacy> selectTMedicalDrugsPharmacyList(TMedicalDrugsPharmacy tMedicalDrugsPharmacy)
    {
        return tMedicalDrugsPharmacyMapper.selectTMedicalDrugsPharmacyList(tMedicalDrugsPharmacy);
    }

    /**
     * 新增药房库存
     * 
     * @param tMedicalDrugsPharmacy 药房库存
     * @return 结果
     */
    @Override
    public int insertTMedicalDrugsPharmacy(TMedicalDrugsPharmacy tMedicalDrugsPharmacy)
    {
        tMedicalDrugsPharmacy.setId(SecurityUtils.getUsername()+new Date().getTime());
        tMedicalDrugsPharmacy.setOperator(SecurityUtils.getUsername());
        tMedicalDrugsPharmacy.setUpdateTime(new Date());
        return tMedicalDrugsPharmacyMapper.insertTMedicalDrugsPharmacy(tMedicalDrugsPharmacy);
    }

    /**
     * 修改药房库存
     * 
     * @param tMedicalDrugsPharmacy 药房库存
     * @return 结果
     */
    @Override
    public int updateTMedicalDrugsPharmacy(TMedicalDrugsPharmacy tMedicalDrugsPharmacy)
    {
        tMedicalDrugsPharmacy.setUpdateTime(DateUtils.getNowDate());
        return tMedicalDrugsPharmacyMapper.updateTMedicalDrugsPharmacy(tMedicalDrugsPharmacy);
    }

    /**
     * 批量删除药房库存
     * 
     * @param ids 需要删除的药房库存主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsPharmacyByIds(String[] ids)
    {
        return tMedicalDrugsPharmacyMapper.deleteTMedicalDrugsPharmacyByIds(ids);
    }

    /**
     * 删除药房库存信息
     * 
     * @param id 药房库存主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsPharmacyById(String id)
    {
        return tMedicalDrugsPharmacyMapper.deleteTMedicalDrugsPharmacyById(id);
    }
}
