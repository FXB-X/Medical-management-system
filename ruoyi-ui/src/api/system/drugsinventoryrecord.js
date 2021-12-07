import request from '@/utils/request'

// 查询盘点记录列表
export function listDrugsinventoryrecord(query) {
  return request({
    url: '/system/drugsinventoryrecord/list',
    method: 'get',
    params: query
  })
}

// 查询盘点记录详细
export function getDrugsinventoryrecord(id) {
  return request({
    url: '/system/drugsinventoryrecord/' + id,
    method: 'get'
  })
}

// 新增盘点记录
export function addDrugsinventoryrecord(data) {
  return request({
    url: '/system/drugsinventoryrecord',
    method: 'post',
    data: data
  })
}

// 修改盘点记录
export function updateDrugsinventoryrecord(data) {
  return request({
    url: '/system/drugsinventoryrecord',
    method: 'put',
    data: data
  })
}

// 删除盘点记录
export function delDrugsinventoryrecord(id) {
  return request({
    url: '/system/drugsinventoryrecord/' + id,
    method: 'delete'
  })
}

// 导出盘点记录
export function exportDrugsinventoryrecord(query) {
  return request({
    url: '/system/drugsinventoryrecord/export',
    method: 'get',
    params: query
  })
}