import request from '@/utils/request'

// 查询药库库存列表
export function listStorage(query) {
  return request({
    url: '/system/storage/list',
    method: 'get',
    params: query
  })
}

// 查询药库库存详细
export function getStorage(id) {
  return request({
    url: '/system/storage/' + id,
    method: 'get'
  })
}

// 新增药库库存
export function addStorage(data) {
  return request({
    url: '/system/storage',
    method: 'post',
    data: data
  })
}

// 修改药库库存
export function updateStorage(data) {
  return request({
    url: '/system/storage',
    method: 'put',
    data: data
  })
}

// 删除药库库存
export function delStorage(id) {
  return request({
    url: '/system/storage/' + id,
    method: 'delete'
  })
}

// 导出药库库存
export function exportStorage(query) {
  return request({
    url: '/system/storage/export',
    method: 'get',
    params: query
  })
}