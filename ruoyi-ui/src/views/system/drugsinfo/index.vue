<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="药品名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入药品名称" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item label="单位" prop="unit">
        <el-select v-model="queryParams.unit" placeholder="请选择单位" clearable size="small">
          <el-option v-for="dict in dict.type.medical_drugs_company" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="药品状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择药品状态" clearable size="small">
          <el-option v-for="dict in dict.type.medical_drugs_status" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['system:drugsinfo:add']">新增</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:drugsinfo:edit']"
        >修改</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleupstatus"
          v-hasPermi="['system:drugsinfo:edit']">作废</el-button>
      </el-col>
      
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" :loading="exportLoading"
          @click="handleExport" v-hasPermi="['system:drugsinfo:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="drugsinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="药品ID" align="center" prop="id" v-if="false" />
      <el-table-column label="药品名称" align="center" prop="name" />
      <el-table-column label="规格" align="center" prop="specifications" />
      <el-table-column label="单位" align="center" prop="unit">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.medical_drugs_company" :value="scope.row.unit" />
        </template>
      </el-table-column>
      <el-table-column label="药品描述" align="center" prop="description" />
      <el-table-column label="药品状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.medical_drugs_status" :value="scope.row.status" />
        </template>
      </el-table-column>
      <el-table-column label="购进单价" align="center" prop="buyunitprice" />
      <el-table-column label="零售单价" align="center" prop="sellunitprice" />
      <el-table-column label="操作人" align="center" prop="operator" />
      <el-table-column label="操作时间" align="center" prop="operatortime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.operatortime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['system:drugsinfo:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleupstatus(scope.row)"
            v-hasPermi="['system:drugsinfo:edit']" v-if="scope.row.status===0">作废</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改药品信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="药品名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入药品名称" />
        </el-form-item>
        <el-form-item label="规格" prop="specifications">
          <el-input v-model="form.specifications" placeholder="请输入规格" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-select v-model="form.unit" placeholder="请选择单位">
            <el-option v-for="dict in dict.type.medical_drugs_company" :key="dict.value" :label="dict.label"
              :value="dict.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="药品描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="药品状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择药品状态">
            <el-option v-for="dict in dict.type.medical_drugs_status" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="购进单价" prop="buyunitprice">
          <el-input v-model="form.buyunitprice" placeholder="请输入购进单价" />
        </el-form-item>
        <el-form-item label="零售单价" prop="sellunitprice">
          <el-input v-model="form.sellunitprice" placeholder="请输入零售单价" />
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
    listDrugsinfo,
    getDrugsinfo,
    delDrugsinfo,
    addDrugsinfo,
    updateDrugsinfo,
    exportDrugsinfo
  } from "@/api/system/drugsinfo";

  export default {
    name: "Drugsinfo",
    dicts: ['medical_drugs_company', 'medical_drugs_status'],
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
        // 药品信息表格数据
        drugsinfoList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          name: null,
          specifications: null,
          unit: null,
          description: null,
          status: null,
          buyunitprice: null,
          sellunitprice: null,
          operator: null,
          operatortime: null
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
      /** 查询药品信息列表 */
      getList() {
        this.loading = true;
        listDrugsinfo(this.queryParams).then(response => {
          this.drugsinfoList = response.rows;
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
          name: null,
          specifications: null,
          unit: null,
          description: null,
          status: 0,
          buyunitprice: null,
          sellunitprice: null
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
        this.title = "添加药品信息";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getDrugsinfo(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改药品信息";
        });
      },

      /** 修改状态 */
      handleupstatus(row) {
        console.log(row.id + "---")
        let id = row.id || this.ids
        this.$confirm('此操作将作废该药品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          getDrugsinfo(id).then(response => {
            this.form = response.data;
            console.log("ID：--" + response.data.id);
            console.log("状态：--" + this.form.status);
            let status = 0;
            let msg = null;
            if (this.form.status == 0) {
              status = 1;
              msg = '作废';
            } else {
              status = 0;
              msg = '恢复使用';
            }
            this.form.status = status;
            updateDrugsinfo(this.form).then(response => {
              this.msgSuccess(msg + "成功");
              this.getList();
            });
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消作废'
          });
        });
      },


      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateDrugsinfo(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addDrugsinfo(this.form).then(response => {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$confirm('是否确认删除药品信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDrugsinfo(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有药品信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportDrugsinfo(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
      }
    }
  };
</script>
