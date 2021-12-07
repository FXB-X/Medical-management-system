<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="药品名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入药品名称" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="数量" prop="no">
        <el-input v-model="queryParams.no" placeholder="请输入数量" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="更新时间" prop="updateTime">
        <el-date-picker clearable size="small" v-model="queryParams.updateTime" type="date" value-format="yyyy-MM-dd"
          placeholder="选择更新时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="操作人" prop="operator">
        <el-input v-model="queryParams.operator" placeholder="请输入操作人" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleUpdate"
          v-hasPermi="['system:drugsstorage:add']">出库</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" :loading="exportLoading"
          @click="handleExport" v-hasPermi="['system:drugsstorage:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="drugsstorageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="药库库存" align="center" prop="id" v-if="false" />
      <el-table-column label="药品名称" align="center" prop="name" />
      <el-table-column label="数量" align="center" prop="no" />
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作人" align="center" prop="operator" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-add" @click="handleUpdate(scope.row)"
            v-hasPermi="['system:drugspharmacy:add']">出库</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改药房库存对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
     <el-form ref="form"  :model="form" :rules="rules" label-width="80px">

        <!-- <el-form-item label="药房名字" prop="name">
          <el-select v-model="form.name" placeholder="请选择药房名字">
            <el-option v-for="dict in dict.type.medical_pharmacy_name" :key="dict.value" :label="dict.label"
              :value="dict.value"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="药品名称" prop=""drugsid>
          <el-select v-model="form.drugsid" filterable placeholder="请输入药品名称">
            <el-option v-for="item in drugsstorageList" :key="item.drugsid" :label="item.name" :value="item.drugsid">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="数量" prop="no">
          <el-input v-model="form.no" placeholder="请输入数量" />
        </el-form-item> -->


      <el-table  :data="form" >
        <el-table-column property="name" v-model="form.drugsid" label="药品名称" width="150">

        </el-table-column>

        <el-table-column property="tname" label="药房名称">
          <el-select v-model="form.name" placeholder="请选择药房名字">
            <el-option v-for="dict in dict.type.medical_pharmacy_name" :key="dict.value" :label="dict.label"
              :value="dict.value"></el-option>
          </el-select>
        </el-table-column>
        <el-table-column property="no" label="数量">
            <el-input v-model="form.no" placeholder="请输入数量" />
        </el-table-column>
      </el-table>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listDrugsstorage,
    getDrugsstorage,
    delDrugsstorage,
    addDrugsstorage,
    updateDrugsstorage,
    exportDrugsstorage
  } from "@/api/system/drugsstorage";
  import {
    addDrugspharmacy,
    updateDrugspharmacy,
    exportDrugspharmacy
  } from "@/api/system/drugspharmacy";
  export default {
    name: "Drugsstorage",
    dicts: ['medical_pharmacy_name'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 导出遮罩层
        exportLoading: false,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 药库库存表格数据
        drugsstorageList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          drugsid: null,
          no: null,
          updateTime: null,
          operator: null,
          name: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询药库库存列表 */
      getList() {
        this.loading = true;
        listDrugsstorage(this.queryParams).then(response => {
          this.drugsstorageList = response.rows;
          // debugger
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        // this.form = {
        //   id: null,
        //   drugsid: null,
        //   no: null,
        //   updateTime: null,
        //   operator: null
        // };
        // this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.id)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      // handleAdd(row) {
      //   // var arr = new Array();
      //   // arr.push(id)
      //   // arr.push(name);
      //   // var id_name = arr.join("-");
      //   // // id-name
      //   console.log("---row:"+row)
      //   debugger

      //   this.reset();
      //   this.open = true;
      //   this.title = "出库";
      // },
      /** 出库按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        // console.log("---row:"+id)
        getDrugsstorage(id).then(response => {
          this.form= response.rows;
          this.open = true;
          this.title = "出库";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            debugger
            console.log("---id:"+this.form.id)
            // if (this.form.id != null) {
            //   updateDrugspharmacy(this.form).then(response => {
            //     this.msgSuccess("出库成功");
            //     this.open = false;
            //     this.getList();
            //   });
            // } else {
            //   addDrugspharmacy(this.form).then(response => {
            //     this.msgSuccess("入库成功");
            //     this.open = false;
            //     this.getList();
            //   });
            // }
          }
        });
      },



      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$confirm('是否确认删除药库库存编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDrugsstorage(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有药库库存数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportDrugsstorage(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
      }
    }
  };
</script>
