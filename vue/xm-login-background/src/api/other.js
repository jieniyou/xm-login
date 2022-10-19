import request from '@/utils/request'

//轮播
export function selectSlideshow(){

    return request.post("selectSlideshow")
}

export function insertSlideshow(form) {
    return request.post("insertSlideshow",form)
    
}

export function delSlideshow(id){
    return request.post("delSlideshow",{"id":id})
}

export function updateSlideshow(id,status){
    return request.post("updateSlideshow",{"id":id,"slideshowStatus":status})
}

export function editSlideshow(form){
    return request.post("editSlideshow",form)
}

//商品
export function selectGoods(){
    return request.post("selectGoods")
}

export function editGoods(form){
    return request.post("editGoods",form)
}
//发货
export function selectDeliverGoods(){
    return request.post("selectDeliverGoods")
}

export function updateDeliverGoods(id,status){
    return request.post("updateDeliverGoods",{"shoppingcartId":id,"goodsDeliveryStatus":status})
}