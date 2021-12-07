import request from '@/utils/request'

// 查询药品信息列表
export function listDrugsinfo(query) {
  return request({
    url: '/system/drugsinfo/list',
    method: 'get',
    params: query
  })
}

// 查询药品信息详细
export function getDrugsinfo(id) {
  return request({
    url: '/system/drugsinfo/' + id,
    method: 'get'
  })
}

// 新增药品信息
export function addDrugsinfo(data) {
  return request({
    url: '/system/drugsinfo',
    method: 'post',
    data: data
  })
}

// 修改药品信息
export function updateDrugsinfo(data) {
  return request({
    url: '/system/drugsinfo',
    method: 'put',
    data: data
  })
}

// 删除药品信息
export function delDrugsinfo(id) {
  return request({
    url: '/system/drugsinfo/' + id,
    method: 'delete'
  })
}

// 导出药品信息
export function exportDrugsinfo(query) {
  return request({
    url: '/system/drugsinfo/export',
    method: 'get',
    params: query
  })
}