import request from '@/utils/request'

// 查询药库库存列表
export function listDrugsstorage(query) {
  return request({
    url: '/system/drugsstorage/list',
    method: 'get',
    params: query
  })
}

// 查询药库库存详细
export function getDrugsstorage(id) {
  return request({
    url: '/system/drugsstorage/' + id,
    method: 'get'
  })
}

// 新增药库库存
export function addDrugsstorage(data) {
  return request({
    url: '/system/drugsstorage',
    method: 'post',
    data: data
  })
}

// 修改药库库存
export function updateDrugsstorage(data) {
  return request({
    url: '/system/drugsstorage',
    method: 'put',
    data: data
  })
}

// 删除药库库存
export function delDrugsstorage(id) {
  return request({
    url: '/system/drugsstorage/' + id,
    method: 'delete'
  })
}

// 导出药库库存
export function exportDrugsstorage(query) {
  return request({
    url: '/system/drugsstorage/export',
    method: 'get',
    params: query
  })
}