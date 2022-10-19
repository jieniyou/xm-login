import request from '@/utils/request'
import store from '@/store';
import router from '@/router';

export function getAllCart() {
    if (store.getters.status != '') {
        return request.post("queryAllCart")
    } else {
        return router.push({ path: '/Login' })
    }
}

export function getShoppingCartByUserId(id){
    return request.post('getShoppingCartByUserId',{'id':id},{headers:{"Content-Type":"application/json"}})
}

export function addShoppingCart(cart){
    return request.post('addShoppingCart',cart)
}

export function delShoppingcartById(id){
    return request.post('delShoppingcartById',{'shoppingcartId':id},{headers:{"Content-Type":"application/json"}})
}

export function settlementById(id){
    return request.post('settlementById',{'shoppingcartId':id},{headers:{"Content-Type":"application/json"}})
}
export function gotoPay(wallet){
    return request.post('gotoPay',wallet)
}

export function updateTakeStatus(id){
    return request.post("updateTakeStatus",{"shoppingcartId":id},{headers:{"Content-Type":"application/json"}})
}