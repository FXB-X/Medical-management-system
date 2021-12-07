package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.TMedicalDrugsStorage;
import com.ruoyi.system.domain.dto.TMedicalDrugsPurchasedto;
import com.ruoyi.system.service.ITMedicalDrugsStorageService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TMedicalDrugsPurchase;
import com.ruoyi.system.service.ITMedicalDrugsPurchaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品采购信息Controller
 * 
 * @author FXB
 * @date 2021-09-26
 */
@RestController
@RequestMapping("/system/drugspurchase")
public class TMedicalDrugsPurchaseController extends BaseController
{
    @Autowired
    private ITMedicalDrugsPurchaseService tMedicalDrugsPurchaseService;

    @Autowired
    private ITMedicalDrugsStorageService tMedicalDrugsStorageService;

    /**
     * 查询药品采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugspurchase:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        startPage();
        List<TMedicalDrugsPurchase> list = tMedicalDrugsPurchaseService.selectTMedicalDrugs(tMedicalDrugsPurchase);
        return getDataTable(list);
    }


    /**
     * 导出药品采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugspurchase:export')")
    @Log(title = "药品采购信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        List<TMedicalDrugsPurchase> list = tMedicalDrugsPurchaseService.selectTMedicalDrugsPurchaseList(tMedicalDrugsPurchase);
        ExcelUtil<TMedicalDrugsPurchase> util = new ExcelUtil<TMedicalDrugsPurchase>(TMedicalDrugsPurchase.class);
        return util.exportExcel(list, "药品采购信息数据");
    }
//
//    /**
//     * 获取药品采购信息详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('system:drugspurchase:query')")
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") String id)
//    {
//        return AjaxResult.success(tMedicalDrugsPurchaseService.selectTMedicalDrugsPurchaseById(id));
//    }




    /**
     * 新增药品采购信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugspurchase:add')")
    @Log(title = "药品采购信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        return toAjax(tMedicalDrugsPurchaseService.insertTMedicalDrugsPurchase(tMedicalDrugsPurchase));
    }

    /**
     * 修改药品采购信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugspurchase:edit')")
    @Log(title = "药品采购信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        return toAjax(tMedicalDrugsPurchaseService.updateTMedicalDrugsPurchase(tMedicalDrugsPurchase));
    }

    /**
     * 删除药品采购信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugspurchase:remove')")
    @Log(title = "药品采购信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalDrugsPurchaseService.deleteTMedicalDrugsPurchaseByIds(ids));
    }


    /**
     * 药品采购入库
     */
    @PreAuthorize("@ss.hasPermi('system:drugspurchase:Storageadd')")
    @Log(title = "药品采购入库")
    @GetMapping("/{ids}")
    public AjaxResult getStorageadd(@PathVariable String[] ids)
    {

        TMedicalDrugsStorage ts=new TMedicalDrugsStorage();


        for (String id : ids) {
            TMedicalDrugsPurchase tM = tMedicalDrugsPurchaseService.selectTMedicalDrugsPurchaseById(id);
            TMedicalDrugsStorage tms = tMedicalDrugsStorageService.selectTMedicalDrugsById(tM.getDrugsid());
            /*
            * 如果药库表中有该药品，就修改药品数量
            * 没有就新增
            * */
            if(tms !=null){
                ts.setId(tms.getId());
                ts.setNo(tM.getNo()+tms.getNo());
                tMedicalDrugsStorageService.updateTMedicalDrugsStorage(ts);
            }else{
                ts.setNo(tM.getNo());
                ts.setDrugsid(tM.getDrugsid());
                tMedicalDrugsStorageService.insertTMedicalDrugsStorage(ts);

            }

        }

        return toAjax(1);
    }


    /**
     * 批量修改
     * @param tMedicalDrugsPurchasedto
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:drugspurchase:update')")
    @PutMapping("/")
    public AjaxResult getupdate(@RequestBody TMedicalDrugsPurchasedto tMedicalDrugsPurchasedto)
    {

        String name= SecurityUtils.getUsername();
        Date   time=new Date();
        String[] ids = tMedicalDrugsPurchasedto.getId();
        Integer code = tMedicalDrugsPurchasedto.getCode();
        TMedicalDrugsPurchase tMedicalDrugsPurchase = new TMedicalDrugsPurchase();

        if(code == 1){
                tMedicalDrugsPurchase.setVerificationtime(time);
                tMedicalDrugsPurchase.setVerifier(name);
            }else {
                tMedicalDrugsPurchase.setAudittime(time);
                tMedicalDrugsPurchase.setReviewer(name);
        }

        for (String id : ids) {
            tMedicalDrugsPurchase.setId(id);
            tMedicalDrugsPurchaseService.updateTMedicalDrugsPurchase(tMedicalDrugsPurchase);
        }

        return toAjax(1);
    }




}
