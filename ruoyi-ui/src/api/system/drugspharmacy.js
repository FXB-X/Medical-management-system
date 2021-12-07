import request from '@/utils/request'

// 查询药房库存列表
export function listDrugspharmacy(query) {
  return request({
    url: '/system/drugspharmacy/list',
    method: 'get',
    params: query
  })
}

// 查询药房库存详细
export function getDrugspharmacy(id) {
  return request({
    url: '/system/drugspharmacy/' + id,
    method: 'get'
  })
}

// 新增药房库存
export function addDrugspharmacy(data) {
  return request({
    url: '/system/drugspharmacy',
    method: 'post',
    data: data
  })
}

// 修改药房库存
export function updateDrugspharmacy(data) {
  return request({
    url: '/system/drugspharmacy',
    method: 'put',
    data: data
  })
}

// 删除药房库存
export function delDrugspharmacy(id) {
  return request({
    url: '/system/drugspharmacy/' + id,
    method: 'delete'
  })
}

// 导出药房库存
export function exportDrugspharmacy(query) {
  return request({
    url: '/system/drugspharmacy/export',
    method: 'get',
    params: query
  })
}