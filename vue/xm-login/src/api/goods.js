import request from '@/utils/request';
import store from '@/store';
import router from '@/router';

export function getAllSlideshow(){
    return request.post("getSlideshow")
}

export function getAllCategory(){
    return request.post("queryCategory")
}

export function getPhone(){
    return request.post("phone/getAll")
}
export function getPhoneByModel(model){
    return request.post("queryPhoneByModel",{'model':model},{headers:{"Content-Type": "application/json"}})
}
export function getPhoneByCategory(categoryId){
    return request.post("queryPhoneByCategoryId",{'categoryId':categoryId},{headers:{"Content-Type":"application/json"}})
}
export function getGoodsDetails(goodsId){
    return request.post("queryGoodsDetailsId",{'id':goodsId},{headers:{"Content-Type":"application/json"}})
}

export function getBalanceById(id){
    return request.post("queryBalanceById",{'id':id},{headers:{"Content-Type":"application/json"}})
}
export function shopping(wallit){
    if(store.getters.status!=''){
        return request.post("shopping",wallit)
    }else{
        return router.push({path:'/Login'})
    }
    
}