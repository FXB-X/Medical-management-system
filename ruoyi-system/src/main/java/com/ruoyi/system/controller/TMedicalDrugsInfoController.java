package com.ruoyi.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.system.domain.TMedicalDrugsInfo;
import com.ruoyi.system.service.ITMedicalDrugsInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品信息Controller
 * 
 * @author FXB
 * @date 2021-09-25
 */
@RestController
@RequestMapping("/system/drugsinfo")
public class TMedicalDrugsInfoController extends BaseController
{
    @Autowired
    private ITMedicalDrugsInfoService tMedicalDrugsInfoService;

    /**
     * 查询药品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        startPage();
        List<TMedicalDrugsInfo> list = tMedicalDrugsInfoService.selectTMedicalDrugsInfoList(tMedicalDrugsInfo);
        return getDataTable(list);
    }


    /**
     * 查询药品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinfo:listDrop')")
    @GetMapping("/listdrop")
    public TableDataInfo getDrop()
    {
         TMedicalDrugsInfo t=new TMedicalDrugsInfo();
         t.setStatus(0);
        List<TMedicalDrugsInfo> tMedicalDrugsInfos = tMedicalDrugsInfoService.selectTMedicalDrugsInfoList(t);
        return getDataTable(tMedicalDrugsInfos);
    }

    /**
     * 导出药品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinfo:export')")
    @Log(title = "药品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        List<TMedicalDrugsInfo> list = tMedicalDrugsInfoService.selectTMedicalDrugsInfoList(tMedicalDrugsInfo);
        ExcelUtil<TMedicalDrugsInfo> util = new ExcelUtil<TMedicalDrugsInfo>(TMedicalDrugsInfo.class);
        return util.exportExcel(list, "药品信息数据");
    }

    /**
     * 获取药品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalDrugsInfoService.selectTMedicalDrugsInfoById(id));
    }

    /**
     * 新增药品信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinfo:add')")
    @Log(title = "药品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        return toAjax(tMedicalDrugsInfoService.insertTMedicalDrugsInfo(tMedicalDrugsInfo));
    }

    /**
     * 修改药品信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinfo:edit')")
    @Log(title = "药品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        return toAjax(tMedicalDrugsInfoService.updateTMedicalDrugsInfo(tMedicalDrugsInfo));
    }

    /**
     * 删除药品信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinfo:remove')")
    @Log(title = "药品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalDrugsInfoService.deleteTMedicalDrugsInfoByIds(ids));
    }
}
