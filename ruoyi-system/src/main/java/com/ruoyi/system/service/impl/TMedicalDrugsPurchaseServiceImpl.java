package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.dto.TMedicalDrugsPurchasedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalDrugsPurchaseMapper;
import com.ruoyi.system.domain.TMedicalDrugsPurchase;
import com.ruoyi.system.service.ITMedicalDrugsPurchaseService;

/**
 * 药品采购信息Service业务层处理
 * 
 * @author FXB
 * @date 2021-09-26
 */
@Service
public class TMedicalDrugsPurchaseServiceImpl implements ITMedicalDrugsPurchaseService
{
    @Autowired
    private TMedicalDrugsPurchaseMapper tMedicalDrugsPurchaseMapper;

    /**
     * 查询药品采购信息
     * 
     * @param id 药品采购信息主键
     * @return 药品采购信息
     */
    @Override
    public TMedicalDrugsPurchase selectTMedicalDrugsPurchaseById(String id)
    {
        return tMedicalDrugsPurchaseMapper.selectTMedicalDrugsPurchaseById(id);
    }

    /**
     * 查询药品采购信息列表
     * 
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 药品采购信息
     */
    @Override
    public List<TMedicalDrugsPurchase> selectTMedicalDrugsPurchaseList(TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        return tMedicalDrugsPurchaseMapper.selectTMedicalDrugsPurchaseList(tMedicalDrugsPurchase);
    }

    /**
     * 查询药品信息和药品采购信息表
     *
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 药品信息和药品采购信息表
     */
    @Override
    public List<TMedicalDrugsPurchase> selectTMedicalDrugs(TMedicalDrugsPurchase tMedicalDrugsPurchase) {
        return tMedicalDrugsPurchaseMapper.selectTMedicalDrugs(tMedicalDrugsPurchase);
    }

    /**
     * 新增药品采购信息
     * 
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 结果
     */
    @Override
    public int insertTMedicalDrugsPurchase(TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        tMedicalDrugsPurchase.setId(SecurityUtils.getUsername()+new Date().getTime());
        tMedicalDrugsPurchase.setFilledby(SecurityUtils.getUsername());
        tMedicalDrugsPurchase.setBatchnumbe(new Date().getTime()+"");
        tMedicalDrugsPurchase.setCreatetime(new Date());
        return tMedicalDrugsPurchaseMapper.insertTMedicalDrugsPurchase(tMedicalDrugsPurchase);
    }

    /**
     * 修改药品采购信息
     * 
     * @param tMedicalDrugsPurchase 药品采购信息
     * @return 结果
     */
    @Override
    public int updateTMedicalDrugsPurchase(TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        return tMedicalDrugsPurchaseMapper.updateTMedicalDrugsPurchase(tMedicalDrugsPurchase);
    }

    /**
     * 批量删除药品采购信息
     * 
     * @param ids 需要删除的药品采购信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsPurchaseByIds(String[] ids)
    {
        return tMedicalDrugsPurchaseMapper.deleteTMedicalDrugsPurchaseByIds(ids);
    }

    /**
     * 删除药品采购信息信息
     * 
     * @param id 药品采购信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsPurchaseById(String id)
    {
        return tMedicalDrugsPurchaseMapper.deleteTMedicalDrugsPurchaseById(id);
    }




}
