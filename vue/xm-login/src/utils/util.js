import { getBalanceById } from '@/api/goods';
import { Message } from "element-ui";
import store from '@/store';
export default {
    wallet: function (id) {
        getBalanceById(id).then(resp => {
            let data = resp.data
            if (data.success) {
                store.commit("setWallet", data.content)
            } else {
                Message({
                    message: data.message,
                    type: 'error'
                })
            }
        }).catch(error => {
            Message({
                message: '钱包数据加载失败',
                type: 'error'
            })
        })

    }
}