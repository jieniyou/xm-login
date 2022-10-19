import request from '@/utils/request'

export function getAddressByUserId(userId){
    return request.post('/getAddressByUserId',{"id":userId},{headers:{"Content-Type":"application/json"}})
}
export function delAddressByAddressId(addressId){
    return request.post('/delAddressByUserId',{"addressId":addressId},{headers:{"Content-Type":"application/json"}})
}
export function addAddress(address){
    return request.post('/addAddress',address)
}