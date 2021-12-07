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
import com.ruoyi.system.domain.TMedicalDrugsInventoryRecord;
import com.ruoyi.system.service.ITMedicalDrugsInventoryRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 盘点记录Controller
 * 
 * @author FXB
 * @date 2021-09-25
 */
@RestController
@RequestMapping("/system/drugsinventoryrecord")
public class TMedicalDrugsInventoryRecordController extends BaseController
{
    @Autowired
    private ITMedicalDrugsInventoryRecordService tMedicalDrugsInventoryRecordService;

    /**
     * 查询盘点记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinventoryrecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord)
    {
        startPage();
        List<TMedicalDrugsInventoryRecord> list = tMedicalDrugsInventoryRecordService.selectTMedicalDrugsInventoryRecordList(tMedicalDrugsInventoryRecord);
        return getDataTable(list);
    }

    /**
     * 导出盘点记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinventoryrecord:export')")
    @Log(title = "盘点记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord)
    {
        List<TMedicalDrugsInventoryRecord> list = tMedicalDrugsInventoryRecordService.selectTMedicalDrugsInventoryRecordList(tMedicalDrugsInventoryRecord);
        ExcelUtil<TMedicalDrugsInventoryRecord> util = new ExcelUtil<TMedicalDrugsInventoryRecord>(TMedicalDrugsInventoryRecord.class);
        return util.exportExcel(list, "盘点记录数据");
    }

    /**
     * 获取盘点记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinventoryrecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalDrugsInventoryRecordService.selectTMedicalDrugsInventoryRecordById(id));
    }

    /**
     * 新增盘点记录
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinventoryrecord:add')")
    @Log(title = "盘点记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord)
    {
        return toAjax(tMedicalDrugsInventoryRecordService.insertTMedicalDrugsInventoryRecord(tMedicalDrugsInventoryRecord));
    }

    /**
     * 修改盘点记录
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinventoryrecord:edit')")
    @Log(title = "盘点记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord)
    {
        return toAjax(tMedicalDrugsInventoryRecordService.updateTMedicalDrugsInventoryRecord(tMedicalDrugsInventoryRecord));
    }

    /**
     * 删除盘点记录
     */
    @PreAuthorize("@ss.hasPermi('system:drugsinventoryrecord:remove')")
    @Log(title = "盘点记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalDrugsInventoryRecordService.deleteTMedicalDrugsInventoryRecordByIds(ids));
    }
}
