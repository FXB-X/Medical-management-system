import request from '@/utils/request'

// 查询药品采购信息列表
export function listDrugspurchase(query) {
  return request({
    url: '/system/drugspurchase/list',
    method: 'get',
    params: query
  })
}

// 查询药品名和ID
export function listDrugsp(query) {
  return request({
    url: '/system/drugsinfo/listdrop',
    method: 'get',
    params: query
  })
}

// 查询药品采购信息详细
export function getDrugspurchase(id) {
  return request({
    url: '/system/drugspurchase/' + id,
    method: 'get'
  })
}

// 新增药品采购信息
export function addDrugspurchase(data) {
  return request({
    url: '/system/drugspurchase',
    method: 'post',
    data: data
  })
}

// 修改药品采购信息
export function updateDrugspurchase(data) {
  return request({
    url: '/system/drugspurchase',
    method: 'put',
    data: data
  })
}


// 采购入库
export function getStorageadd(ids) {
  return request({
    url: '/system/drugspurchase/'+ ids,
    method: 'get'
  })
}

// 批量修改药品采购
export function getupdate(data) {
  return request({
    url: '/system/drugspurchase/',
    method: 'put',
    data:data
  })
}


// 删除药品采购信息
export function delDrugspurchase(id) {
  return request({
    url: '/system/drugspurchase/' + id,
    method: 'delete'
  })
}

// 导出药品采购信息
export function exportDrugspurchase(query) {
  return request({
    url: '/system/drugspurchase/export',
    method: 'get',
    params: query
  })
}
