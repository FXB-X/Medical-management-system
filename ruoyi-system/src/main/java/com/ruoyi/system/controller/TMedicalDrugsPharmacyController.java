package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.TMedicalDrugsPharmacy;
import com.ruoyi.system.service.ITMedicalDrugsPharmacyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药房库存Controller
 * 
 * @author FXB
 * @date 2021-09-25
 */
@RestController
@RequestMapping("/system/drugspharmacy")
public class TMedicalDrugsPharmacyController extends BaseController
{
    @Autowired
    private ITMedicalDrugsPharmacyService tMedicalDrugsPharmacyService;

    /**
     * 查询药房库存列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugspharmacy:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalDrugsPharmacy tMedicalDrugsPharmacy)
    {
        startPage();
        List<TMedicalDrugsPharmacy> list = tMedicalDrugsPharmacyService.selectTMedicalDrugsPharmacyList(tMedicalDrugsPharmacy);
        return getDataTable(list);
    }

    /**
     * 导出药房库存列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugspharmacy:export')")
    @Log(title = "药房库存", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalDrugsPharmacy tMedicalDrugsPharmacy)
    {
        List<TMedicalDrugsPharmacy> list = tMedicalDrugsPharmacyService.selectTMedicalDrugsPharmacyList(tMedicalDrugsPharmacy);
        ExcelUtil<TMedicalDrugsPharmacy> util = new ExcelUtil<TMedicalDrugsPharmacy>(TMedicalDrugsPharmacy.class);
        return util.exportExcel(list, "药房库存数据");
    }

    /**
     * 获取药房库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugspharmacy:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalDrugsPharmacyService.selectTMedicalDrugsPharmacyById(id));
    }

    /**
     * 新增药房库存
     */
    @PreAuthorize("@ss.hasPermi('system:drugspharmacy:add')")
    @Log(title = "药房库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalDrugsPharmacy tMedicalDrugsPharmacy)
    {
        return toAjax(tMedicalDrugsPharmacyService.insertTMedicalDrugsPharmacy(tMedicalDrugsPharmacy));
    }

    /**
     * 修改药房库存
     */
    @PreAuthorize("@ss.hasPermi('system:drugspharmacy:edit')")
    @Log(title = "药房库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalDrugsPharmacy tMedicalDrugsPharmacy)
    {
        return toAjax(tMedicalDrugsPharmacyService.updateTMedicalDrugsPharmacy(tMedicalDrugsPharmacy));
    }

    /**
     * 删除药房库存
     */
    @PreAuthorize("@ss.hasPermi('system:drugspharmacy:remove')")
    @Log(title = "药房库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalDrugsPharmacyService.deleteTMedicalDrugsPharmacyByIds(ids));
    }
}
