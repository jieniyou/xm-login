import request from '@/utils/request/index';

export function getEmailCode(data){
    return request.get("/sys-user/sendEmail?"+`emailAddress=`+data)
}
