<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="药品名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入药品名称" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <!-- <el-form-item label="药品来源" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入药品来源" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item> -->
      <el-form-item label="药品来源" prop="source">
        <el-select v-model="queryParams.source" placeholder="请选择药品来源" clearable size="small">
          <el-option v-for="dict in dict.type.medical_drugs_source" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="产地" prop="address">
        <el-select v-model="queryParams.address" placeholder="请选择产地" clearable size="small">
          <el-option v-for="dict in dict.type.medical_drugs_address" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>


      <el-form-item label="生产日期" prop="manufacturetime">
        <el-date-picker clearable size="small" v-model="queryParams.manufacturetime" type="date"
          value-format="yyyy-MM-dd" placeholder="选择生产日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="有效期" prop="termofvalidity">
        <el-input v-model="queryParams.termofvalidity" placeholder="请输入有效期" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="填制人" prop="filledby">
        <el-input v-model="queryParams.filledby" placeholder="请输入填制人" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="填制时间" prop="createtime">
        <el-date-picker clearable size="small" v-model="queryParams.createtime" type="date" value-format="yyyy-MM-dd"
          placeholder="选择填制时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="核查人" prop="verifier">
        <el-input v-model="queryParams.verifier" placeholder="请输入核查人" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item label="审核人" prop="reviewer">
        <el-input v-model="queryParams.reviewer" placeholder="请输入审核人" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['system:drugspurchase:add']">采购申请</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" @click="handeverifier" :disabled="multiple"
          v-hasPermi="['system:drugspurchase:edit']">核查</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-edit" size="mini" @click="handleAudit" :disabled="multiple"
          v-hasPermi="['system:drugspurchase:remove']">审核</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" @click="handeveradd" :disabled="multiple"
          v-hasPermi="['system:drugspurchase:edit']">采购入库</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" :loading="exportLoading"
          @click="handleExport" v-hasPermi="['system:drugspurchase:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="drugspurchaseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column v-if="false" label="药品采购信息ID" align="center" prop="id" />
      <el-table-column label="药品名称" align="center" prop="tmedicalDrugsInfo.name" />
      <el-table-column label="药品来源" align="center" prop="source">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.medical_drugs_source" :value="scope.row.source"/>
              </template>
            </el-table-column>
       <el-table-column label="产地" align="center" prop="address">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.medical_drugs_address" :value="scope.row.address"/>
        </template>
      </el-table-column>
      <el-table-column label="批号" align="center" prop="batchnumbe" />
      <el-table-column label="数量" align="center" prop="no" />
      <el-table-column label="生产日期" align="center" prop="manufacturetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manufacturetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="有效期" align="center" prop="termofvalidity" />
      <el-table-column label="摘要" align="center" prop="abstracts" />
      <el-table-column label="填制人" align="center" prop="filledby" />
      <el-table-column label="填制时间" align="center" prop="createtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createtime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="核查人" align="center" prop="verifier" />
      <el-table-column label="核查日期" align="center" prop="verificationtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.verificationtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核日期" align="center" prop="audittime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.audittime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleDelete(scope.row)"
            v-hasPermi="['system:drugspurchase:edit']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改药品采购信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="药品名称" prop="drugsid">
          <el-select v-model="form.drugsid" filterable placeholder="请输入药品名称">
            <el-option v-for="item in listDrop" :key="item.id" :label="item.name" :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="药品来源" prop="source">
          <el-select v-model="form.source" placeholder="请选择药品来源">
            <el-option
              v-for="dict in dict.type.medical_drugs_source"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产地" prop="address">
          <el-select v-model="form.address" placeholder="请选择产地">
            <el-option v-for="dict in dict.type.medical_drugs_address" :key="dict.value" :label="dict.label"
              :value="dict.value"></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="批号" prop="batchnumbe">
          <el-input v-model="form.batchnumbe" placeholder="请输入批号" />
        </el-form-item> -->
        <el-form-item label="数量" prop="no">
          <el-input v-model="form.no" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="生产日期" prop="manufacturetime">
          <el-date-picker clearable size="small" v-model="form.manufacturetime" type="date" value-format="yyyy-MM-dd"
            placeholder="选择生产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效期" prop="termofvalidity">
          <el-input v-model="form.termofvalidity" placeholder="请输入有效期" />
        </el-form-item>
        <el-form-item label="摘要" prop="abstracts">
          <el-input v-model="form.abstracts" type="textarea" placeholder="请输入内容" />
        </el-form-item>
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
    listDrugspurchase,
    getDrugspurchase,
    addDrugspurchase,
    updateDrugspurchase,
    delDrugspurchase,
    exportDrugspurchase,
    getupdate,
    getStorageadd,
    listDrugsp
  } from "@/api/system/drugspurchase";

  export default {
    name: "Drugspurchase",
     dicts: ['medical_drugs_source', 'medical_drugs_address'],

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
        // 药品采购信息表格数据
        drugspurchaseList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          drugsid: null,
          source: null,
          address: null,
          batchnumbe: null,
          no: null,
          manufacturetime: null,
          termofvalidity: null,
          abstracts: null,
          filledby: null,
          createtime: null,
          verifier: null,
          verificationtime: null,
          reviewer: null,
          audittime: null,
          name: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {},
        //核查数组
        fier: {
          id: null,
          code: null
        },
        // 药品名集合
        listDrop: []
      };
    },
    created() {
      this.handlist();
      this.getList();

    },
    methods: {
      /** 查询药品采购信息列表 */
      getList() {
        this.loading = true;
        listDrugspurchase(this.queryParams).then(response => {
          this.drugspurchaseList = response.rows;
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
        this.form = {
          id: null,
          drugsid: null,
          source: null,
          address: null,
          batchnumbe: null,
          no: null,
          manufacturetime: null,
          termofvalidity: null,
          abstracts: null,
          filledby: null,
          createtime: null,
          verifier: null,
          verificationtime: null,
          reviewer: null,
          audittime: null
        };
        this.resetForm("form");
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
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加药品采购信息";
      },

      // 查询药品名和ID
      handlist() {
        listDrugsp().then(response => {
          this.listDrop = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },

      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        // var arr = new Array();
        // arr.push(id)
        // arr.push(name);
        // var id_name = arr.join("-");
        // // id-name

        getDrugspurchase(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改药品采购信息";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateDrugspurchase(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addDrugspurchase(this.form).then(response => {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },

      /*  核查按钮  */
      handeverifier(row) {
        const ids = row.id || this.ids;
        const code = 1;
        this.fier.code = code;
        this.fier.id = ids;

        console.log("id:" + ids + "code:" + code);
        console.log("this.fier:" + this.fier.id);
        if (ids != null) {
          getupdate(this.fier).then(response => {
            this.msgSuccess("核查通过");
          });

        }
        this.getList();
      },

      // 审核按钮
      handleAudit(row) {
        const ids = row.id || this.ids;
        const code = 0;
        this.fier.code = code;
        this.fier.id = ids;
        if (ids != null) {
          getupdate(this.fier).then(response => {
            this.msgSuccess("审核通过");
          });
        }
        this.getList();
      },

      /*  采购入库按钮  */
      handeveradd(row) {
        const ids = row.id || this.ids;
        console.log("id:" + ids);
        console.log("reviewer:" + row.drugsid);
        debugger
        if (ids != null) {
          getStorageadd(ids).then(response => {
            this.msgSuccess("入库成功");
            this.getList();
          });
        }
      },

      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$confirm('是否确认删除药品采购信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDrugspurchase(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
      },

      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有药品采购信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportDrugspurchase(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
      }
    }
  };
</script>
